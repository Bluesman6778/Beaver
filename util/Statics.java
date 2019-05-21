package Beaver.util;
public final class Statics{
	public static final int NA = -99999;
	public static final int defalutTimeoutMiliSec = 60000;
	public static final int INSERT = 1 << 0;
	public static final int READ = 1 << 1;
	public static final int UPDATE = 1 << 2;
	public static final int DELETE = 1 << 3;
	public static final int COUNT = 1 << 4;
	public static final int EXISTS = 1 << 5;
	public static final int UPSERT = 1 << 6;
	public static final int ALL = 1 << 7;
}
