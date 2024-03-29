package Beaver.control;

import java.io.IOException;
import Beaver.util.Statics;
import Beaver.net.Server;
import Beaver.net.Request;
import Beaver.io.Storage;

public class MainLoop implements Runnable{
	private boolean be = true;
	private Server server = null;
	Request request = null;
	private Storage storage = null;
	public MainLoop(){
	}
	public void setExit(){
		be = false;
	}
	public void setStorage(Storage s){
		storage = s;
	}
	public void go(int portNo){
		server = new Server(portNo);
		try{
			server.open();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		int cnt=0;
		while(be){
			try{
				request = server.read();
				Thread t = new Thread(this);
				t.start();
			}catch(IOException ioe){
				ioe.printStackTrace();
				setExit();	
			}catch(ClassNotFoundException cnfe){
				cnfe.printStackTrace();
				setExit();
			}
			cnt++;
		}
	}

	public void run(){
		try{
			server.write("test");
		}catch(IOException ex){
			ex.printStackTrace();
		}	
	}
}
