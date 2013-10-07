package com.doduck.gaeloadtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.googlecode.objectify.cmd.LoadType;
import com.googlecode.objectify.cmd.Query;
import com.googlecode.objectify.cmd.QueryKeys;

public class LoadTest extends HttpServlet{

	
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OfyService.ofy(); 
		
		final long fibNanoStart = System.nanoTime();
		final long fibMiliStart = System.currentTimeMillis();
		fibonacci(30); //5ms on 2.6Ghz
		final long fibNanoEnd = System.nanoTime();
		final long fibMiliEnd = System.currentTimeMillis();
		
		LoadTimer load = new LoadTimer(fibNanoStart, fibMiliStart, fibNanoEnd, fibMiliEnd);
		
		final long dbNanoStart = System.nanoTime();
		final long dbMiliStart = System.currentTimeMillis();
		OfyService.ofy().save().entity(load).now();
		final long dbNanoStop = System.nanoTime();
		final long dbMiliStop = System.currentTimeMillis();
		
		load.setDbNanoStart(dbNanoStart);
		load.setDbMiliStart(dbMiliStart);
		load.setDbNanoEnd(dbNanoStop);
		load.setDbMiliEnd(dbMiliStop);
		OfyService.ofy().save().entity(load).now();
		
		PrintWriter out = response.getWriter();
		out.println("fibonacci in: "+(fibMiliEnd-fibMiliStart)+"ms");
		out.println("<br />");
		out.println("save in DB in:"+(dbMiliStop-dbMiliStart)+"ms");
	}
	
	private long fibonacci(int n){
		if (n <= 1) 
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
	
	@ApiMethod( httpMethod = "get")
	public void cleanDB()  {
		QueryKeys<LoadTimer> queryKeys = OfyService.ofy().load().type(LoadTimer.class).keys();
		LoadType<LoadTimer> all = OfyService.ofy().load().type(LoadTimer.class);
		OfyService.ofy().delete().entities(all);
		OfyService.ofy().delete().keys(queryKeys);
	}
}