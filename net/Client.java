package Beaver.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.ObjectOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import  Beaver.util.Statics;
import  Beaver.io.Data;
public class Client{
	InetAddress inetAddress = null;
	Socket sock = null;
	public static void main(String[] args){
		try{
			Client c = new Client();
/*
			Request req = new Request();
			Data data = new Data();
			data.setKey(args[0]);
			data.setValue(args[1]);
			req.setData(data);
			req.setType(Statics.INSERT);
*/
			c.open();
//			c.send(req);
			c.send(args[0]);
		}catch(UnknownHostException uhe){
			uhe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public Client() throws UnknownHostException{
		inetAddress = InetAddress.getLocalHost();
	}
	public void open() throws UnknownHostException, IOException{
		 sock = new Socket("127.0.0.1",30051);
	}
/*}
	public void send(Request r) throws IOException{
		r.setInetAddress(inetAddress);
		ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
		oos.writeObject(r);
	}
*/
	public void send(String s) throws IOException{
//		ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		dos.writeChars(s);
	}
	public void receive(){
	}
	public void close(){
	}
}
