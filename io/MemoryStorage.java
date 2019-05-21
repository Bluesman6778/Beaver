package Beaver.io;

import java.util.HashMap;
import java.util.Set;

public class MemoryStorage implements Storage{
	private HashMap<String,String> hashMap;

	public MemoryStorage(){
		hashMap = new HashMap<String,String>();
	}
 	public int count(){
		return hashMap.size();
	}
	public boolean insert(Data p){
		boolean ret = false;
		if( hashMap.get(p.getKey()) == null){
			hashMap.put(p.getKey(),p.getValue());
			ret = true;
		}
		return ret;
	}
	public boolean update(Data p){
		boolean ret = false;
		if( hashMap.get(p.getKey()) != null){
			hashMap.put(p.getKey(),p.getValue());
			ret = true;
		}
		return ret;
	}
	public boolean delete(Data p){
		boolean ret = false;
		if( hashMap.get(p.getKey()) != null){
			hashMap.remove(p);
			ret = true;
		}
		return ret;
	}
	public boolean upsert(Data p){
		boolean ret = false;
		hashMap.put(p.getKey(),p.getValue());
		ret = true;
		return ret;
	}
	public boolean exists(Data p){
		boolean ret = false;
		if( hashMap.get(p.getKey()) != null){
			ret = true;
		}
		return ret;
	}
	public Data read(Data p){
		String val = hashMap.get(p.getKey());
		p.setValue(val);
		return p;
	}
	public Data[] all(){
		Set<String> keySet = hashMap.keySet();
		String[]  keys = new String[keySet.size()];
		keySet.toArray(keys);
		Data[] data = new Data[keys.length];
		for(int i=0;i<keys.length;i++){
			String val = hashMap.get(keys[i]);
			data[i].setKey(keys[i]);
			data[i].setValue(val);
		}
		return data;
	}
}
