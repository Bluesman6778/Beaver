package Beaver.io;
import java.io.Serializable;

public class Data implements Serializable{
	private String key;
	private String value;
	static final long serialVersionUID = 1L;

	public void setKey(String p){
		key = p;
	}
	public String getKey(){
		return key;
	}
	public void setValue(String p){
		value = p;
	}
	public String getValue(){
		return value;
	}
}
