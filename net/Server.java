package Beaver.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
		return null;
	}
	public void write(String msg) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		StringBuilder sb = new StringBuilder();
		int chk=0;
		int c;
		int cnt=0;
		while( (c = br.read()) >= 0 ){
			if(c == '\n'){
				chk++;
			}else if(c == '\r'){
				chk++;
			}else if(c != '\r'){
				chk = 0;
			}
			sb.append((char)c);
			cnt++;
			if( chk >= 4) break;
		}
System.out.println("rcv[" + sb.toString() + "]");
//		Request req = new Request();
//		Data data = new Data();
//		data.setValue(sb.toString());
//		req.setData(data);
//		ObjectInputStream os = new ObjectInputStream(socket.getInputStream());
//		Request req = (Request)os.readObject();
//		return req;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		if(sb.toString().indexOf("favicon")>=0){
			bw.write("HTTP/1.1 404 Not Found" + "\r\n");
			bw.flush();
		}else{
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
	}
	public void setPortNo(int port){
		portNo = port;
	}
	public int getPortNo(){
		return portNo;
	}
}
