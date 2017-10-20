package piglet.piglet2spiglet;


public class Environment {
	public int max_temp;
	public int tab_num;
	public String last;
	public String now;
	
	public Environment() {
		max_temp = 0;
		tab_num = 0;
		last = "";
		now = "";
	}
	
	public void print(String s) {
		for (int i = 0; i < tab_num; ++i)
			System.out.print("    ");
		System.out.println(s);
	}
}