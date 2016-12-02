package com.muthagroup.vo;

import java.sql.Date;
import java.util.ArrayList;

public class MuthaGroupVO
{

ArrayList<ArrayList<Integer>> list;
ArrayList<String> dis_list;
ArrayList<String> stock_list;
Date date;
 @SuppressWarnings("rawtypes")
public ArrayList getList() {
	return list;
}

public void setList(ArrayList<ArrayList<Integer>> list) {
	this.list = list;
}

 
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public ArrayList<String> getDis_list() {
	return dis_list;
}

public void setDis_list(ArrayList<String> dis_list) {
	this.dis_list = dis_list;
}

public ArrayList<String> getStock_list() {
	return stock_list;
}

public void setStock_list(ArrayList<String> stock_list) {
	this.stock_list = stock_list;
}



}
