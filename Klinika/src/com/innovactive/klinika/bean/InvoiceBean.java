package com.innovactive.klinika.bean;

import java.util.Date;

public class InvoiceBean {
	private int invoiceID;
	private float totValue;
	private Date invoiceDate;
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public float getTotValue() {
		return totValue;
	}
	public void setTotValue(float totValue) {
		this.totValue = totValue;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	
	
}
