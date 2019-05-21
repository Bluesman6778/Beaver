package Beaver.io;
public interface Storage{
	public int count();
	public boolean insert(Data p);
	public boolean update(Data p);
	public boolean delete(Data p);
	public boolean upsert(Data p);
	public boolean exists(Data p);
	public Data read(Data p);
	public Data[] all();
}
