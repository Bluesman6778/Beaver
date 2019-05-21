package Beaver.net;

import java.net.InetAddress;
import java.io.Serializable;
import Beaver.io.Data;

public class Request implements Serializable{
	private InetAddress inetAddress;
	private int type;
	private Data data;
	static final long serialVersionUID = 1L;
	public void setInetAddress( InetAddress ia){
		inetAddress = ia;
	}
	public InetAddress getInetAddress(){
		return inetAddress;
	}

	public void setType(int p){
		type = p;
	}
	public int getType(){
		return type;
	}
	public Data getData(){
		return data;
	}
	public void setData(Data p){
		data = p;
	}
}
