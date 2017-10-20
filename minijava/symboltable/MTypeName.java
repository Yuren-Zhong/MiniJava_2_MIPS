package minijava.symboltable;

import java.util.Vector;

//用于返回表达式的类型
public class MTypeName extends MType {
	public String name; 
	
	public MTypeName(String _name) {
		name = _name;
	}
}