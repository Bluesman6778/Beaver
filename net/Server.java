package Beaver.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import Beaver.util.Statics;
import Beaver.net.Request;
import Beaver.io.Data;

public class Server{
	private int portNo = Statics.NA;
	private ServerSocket serverSocket = null;
	private Socket socket = null;

	public Server(){
	}
	public Server(int port){
		portNo = port;
	}
	public void open() throws IOException{
		serverSocket = new ServerSocket(portNo);
	}
	public void open(int port) throws IOException{
		setPortNo(port);
		serverSocket = new ServerSocket(getPortNo());
	}
	public void close(){
	}
	public Request read() throws IOException,ClassNotFoundException{
		socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
 		InputStreamReader reader = new InputStreamReader(is);
		while(reader.ready()){
			System.out.print((char)reader.read());
		}
		return null;
	}
	public void write(String msg) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		String str = "<h1>Hello World3!!</h1>";
		Calendar cal = Calendar.getInstance();
		str += "<br/>";
		str += cal.getTime().toString();

		bw.write("HTTP/1.1 200 OK" + "\r\n");
		bw.write("Content-Type: text/html" + "\r\n");
		bw.write("Connection: close" + "\r\n");
		bw.write("Content-Length: "  + str.length()+"\r\n");
		bw.write("\r\n");
		bw.write(str);
		bw.flush();
	}
	public void setPortNo(int port){
		portNo = port;
	}
	public int getPortNo(){
		return portNo;
	}
}
