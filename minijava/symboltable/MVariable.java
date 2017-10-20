package minijava.symboltable;

import java.util.Vector;

public class MVariable extends MType {
	public String type;
	public String name;
	//变量所在类
	public MClass PClass;
	//变量所在方法
	public MMethod PMethod;
	//变量在类中(level=1)还是方法中(level=2)
	public int level;
	//变量是否有过被赋值
	public boolean safe;
	
	//构造函数
	public MVariable(String _type, String _name, MClasses environ) {
		type = _type;
		name = _name;
		PClass = environ.PClass;
		PMethod = environ.PMethod;
		level = environ.level;
		safe = false;
	}
	//复制构造函数
	public MVariable(MVariable tmp) {
		type = tmp.type;
		name = tmp.name;
		PClass = tmp.PClass;
		PMethod = tmp.PMethod;
		level = tmp.level;
		safe = tmp.safe;
	}
	
	public void print() {
		System.out.print("        ");
		System.out.println(type+" "+name);
	}
}