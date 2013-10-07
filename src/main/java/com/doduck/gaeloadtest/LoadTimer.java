package com.doduck.gaeloadtest;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class LoadTimer {

	@Id 
	private String id;
	private long fibNanoStart;
	private long fibMiliStart;
	private long fibNanoEnd;
	private long fibMiliEnd;
	
	private long dbNanoStart;
	private long dbMiliStart;
	private long dbNanoEnd;
	private long dbMiliEnd;
	
	public LoadTimer() {
	}
	
	public LoadTimer(long fibNanoStart, long fibMiliStart, long fibNanoEnd, long fibMiliEnd){
		this.fibNanoStart = fibNanoStart;
		this.fibMiliStart = fibMiliStart;
		this.fibNanoEnd = fibNanoEnd;
		this.fibMiliEnd = fibMiliEnd;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getFibNanoStart() {
		return fibNanoStart;
	}

	public void setFibNanoStart(long fibNanoStart) {
		this.fibNanoStart = fibNanoStart;
	}

	public long getFibMiliStart() {
		return fibMiliStart;
	}

	public void setFibMiliStart(long fibMiliStart) {
		this.fibMiliStart = fibMiliStart;
	}

	public long getFibNanoEnd() {
		return fibNanoEnd;
	}

	public void setFibNanoEnd(long fibNanoEnd) {
		this.fibNanoEnd = fibNanoEnd;
	}

	public long getFibMiliEnd() {
		return fibMiliEnd;
	}

	public void setFibMiliEnd(long fibMiliEnd) {
		this.fibMiliEnd = fibMiliEnd;
	}

	public long getDbNanoStart() {
		return dbNanoStart;
	}

	public void setDbNanoStart(long dbNanoStart) {
		this.dbNanoStart = dbNanoStart;
	}

	public long getDbMiliStart() {
		return dbMiliStart;
	}

	public void setDbMiliStart(long dbMiliStart) {
		this.dbMiliStart = dbMiliStart;
	}

	public long getDbNanoEnd() {
		return dbNanoEnd;
	}

	public void setDbNanoEnd(long dbNanoEnd) {
		this.dbNanoEnd = dbNanoEnd;
	}

	public long getDbMiliEnd() {
		return dbMiliEnd;
	}

	public void setDbMiliEnd(long dbMiliEnd) {
		this.dbMiliEnd = dbMiliEnd;
	}
	
}
