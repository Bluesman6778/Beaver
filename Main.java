package Beaver;

import Beaver.control.MainLoop;
import Beaver.io.MemoryStorage;

public class Main{
	public Main(){
	}
	public static void main(String[] args){
		Main main = new Main();
		MemoryStorage memoryStorage = new MemoryStorage();
		MainLoop mainLoop = new MainLoop();
		mainLoop.setStorage(memoryStorage);
		mainLoop.go();
	}
}
