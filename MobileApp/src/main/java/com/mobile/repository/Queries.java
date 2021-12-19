package com.mobile.repository;

public class Queries {
	
	public static final String INSERTQUERY="insert into mobile(model,brand,os,price,storage) values(?,?,?,?,?)";
	public static final String UPDATEQUERY="update mobile set price=? where mobileid=?";
	public static final String DELETEQUERY="delete from mobile where mobileid=?";
	public static final String SELECTALLQUERY="select * from mobile";
	public static final String SELECTBYIDQUERY="select * from mobile where mobileid = ?";
	public static final String GETBYBRANDQUERY="select * from mobile where brand = ?";
	public static final String GETBRANDMODELQUERY="select * from mobile where brand = ? and model like ?";
	public static final String GETPRICEQUERY="select * from mobile where price <= ?";
	public static final String GETBYOSQUERY="select * from mobile where os = ?";
}
