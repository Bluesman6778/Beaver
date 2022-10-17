package Beaver;
import java.io.IOException;
import java.nio.file.Paths;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Beaver.control.MainLoop;
import Beaver.io.MemoryStorage;
import Beaver.util.Settings;

public class Main{
	public Main(){
	}
	public static void main(String[] args){
		Main main = new Main();
		try{
			Settings settings = main.loadSettings(args[0]);
			MemoryStorage memoryStorage = new MemoryStorage();
			MainLoop mainLoop = new MainLoop();
			mainLoop.setStorage(memoryStorage);
			mainLoop.go(settings.getPortNo());
		}catch(IOException ioe){
			ioe.printStackTrace();
			System.exit(-1);
		}
	}
	private Settings loadSettings(String jsonFilePath) throws IOException{
		ObjectMapper  objectMapper = new ObjectMapper();
		JsonNode root = objectMapper.readTree(Paths.get(jsonFilePath).toFile());
		Settings ret = new Settings();
		ret.setPortNo(root.get("portNo").asInt());
		return ret;
	}
}
