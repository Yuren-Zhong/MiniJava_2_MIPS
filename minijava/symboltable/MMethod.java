package minijava.symboltable;

import java.util.Vector;

public class MMethod extends MType {
	public String type;	//返回类型 
	public String name;	//方法名
	public MClass PClass;	//所在类
	public Vector variables = new Vector();	//拥有的变量
	public int para_num;	//传递参数个数
	public int line;	//方法申明所在行
	
	//构造函数
	public MMethod(String _type, String _name, MClasses _environ, int _line) {
		type = _type;
		name = _name;
		PClass = _environ.PClass;
		para_num = 0;
		line = _line;
	}
	//复制构造函数，用于由父类继承方法
	public MMethod(MMethod tmp) {
		type = tmp.type;
		name = tmp.name;
		PClass = tmp.PClass;
		for (int i = 0; i < tmp.variables.size(); ++i) {
			MVariable tmp_var = (MVariable)tmp.variables.elementAt(i);
			MVariable add_new = new MVariable(tmp_var);
			variables.addElement(add_new);
		}
		para_num = tmp.para_num;
	}
	//添加变量
	public String InsertVariable(MVariable v_variable) {
		String variable_name = v_variable.name;
		if (Repeated(variable_name))
			return "Variable double declaration " +"\"" + variable_name +"\"";
		variables.addElement(v_variable);
		return null;
	}
	//判断变量是否重复
	public boolean Repeated(String variable_name) {
		int sz = variables.size();
		for (int i = 0; i < sz; i++) {
			String v_name = ((MVariable)variables.elementAt(i)).name;
			if (v_name.equals(variable_name))
				return true;
		}
		return false;
	}
	//将所在类的变量添加至方法中
	public void inherit() {
		for (int i = 0; i < PClass.variables.size(); ++i) {
			MVariable m_var = (MVariable)PClass.variables.elementAt(i);
			String variable_name = m_var.name;
			if (!Repeated(variable_name))
				variables.addElement(m_var);
		}
	}
	//打印，用于调试
	public void print() {
		System.out.print("    ");
		System.out.println(type+" "+name);
		for (int i = 0; i < variables.size(); ++i) {
			((MVariable)variables.elementAt(i)).print();
		}
	}
	//在方法中寻找变量
	public MVariable find_var(String i_name) {
		for (int i = 0; i < variables.size(); ++i) {
			MVariable tmp = (MVariable)variables.elementAt(i);
			if (tmp.name.equals(i_name))
				return tmp;
		}
		return null;
	}
}