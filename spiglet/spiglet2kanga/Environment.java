package spiglet.spiglet2kanga;
import java.util.Vector;

public class Environment {
	public int p_num;
	public int s_num;
	public int l_num;
	public int pass_num;
	public int head[] = new int[1000];
	public int last[] = new int[1000];
	public int max_temp = 0;
	public int tab_num = 0;
	
	public String name[] = new String[3000];
	public boolean live[][] = new boolean[3000][1000];
	public boolean make[][] = new boolean[3000][1000];
	public boolean destroy[][] = new boolean[3000][1000];
	
	public int left[] = new int[1000];
	public int right[] = new int[1000];
	public boolean used[] = new boolean[1000];
	public boolean left_point[][] = new boolean[3000][1000];
	public String reg[] = new String[1000];
	public int queue[] = new int[20];
	public String reg_name[] = new String[20];
	public boolean is_stack[] = new boolean[1000];
	
	public int next[][] = new int[3000][2];
	public String label_name[] = new String[3000];
	public int label_loc[] = new int[3000];
	public String J_label[] = new String[3000];
	
	public boolean k1;
	public boolean k2;
	public boolean k3;
	public int tt;
	
	public Environment() {
		for (int i = 0; i < 1000; ++i)
			for (int j = 0; j < 1000; ++j) {
				live[i][j] = false;
				make[i][j] = false;
				destroy[i][j] = false;
			}
		int j = 0;
		for (int i = 0; i < 4; ++i)
			reg_name[j++] = "a"+i;
		for (int i = 0; i < 8; ++i)
			reg_name[j++] = "s"+i;
		for (int i = 0; i < 8; ++i)
			reg_name[j++] = "t"+i;
	}
	
	public void get_interval() {
		for (int i = 1; i <= s_num; ++i) {
			if (name[i].equals("CJumpStmt") || name[i].equals("JumpStmt")) {
				for (int j = 1; j <= l_num; ++j)
					if (J_label[i].equals(label_name[j]))
						next[i][1] = label_loc[j];
			}
			else
				next[i][1] = i + 1;
			
			if (name[i].equals("JumpStmt"))
				next[i][0] = next[i][1];
			else next[i][0] = i + 1;
		}
		
		for (int i = 1; i <= p_num; ++i)
		while (true) {
			boolean flag = false;
			for (int j = last[i]; j >= head[i]; --j) {
				for (int k = 0; k <= max_temp; ++k) {
					boolean old = live[j][k];
					if (j != last[i])
						live[j][k] = live[next[j][0]][k] | live[next[j][1]][k];
					else live[j][k] = false;
					if (destroy[j][k])
						live[j][k] = false;
					if (make[j][k])
						live[j][k] = true;
					if (live[j][k] != old)
						flag = true;
				}
			}
			if (flag ==false)
				break;
		}
	}
	
	public int stack_num;
	
	public String get_stack(int i) {
		is_stack[i] = true;
		if (i < 20)
			return "SPILLEDARG "+i;
		else
			return "SPILLEDARG "+(++stack_num);
	}
	
	public void distribute_reg(int i) {
			stack_num = 39;
			for (int j = 0; j <= max_temp; ++j) {
				used[j] = false;
				left[j] = 1001;
				right[j] = 0;
				reg[j] = "";
				is_stack[j] = false;
				for (int k = 0; k < 1000; ++k)
					left_point[k][j] = false;
			}
			for (int j = 0; j < 20; ++j)
				queue[j] = -1;
			
			for (int j = head[i]; j <= last[i]; ++j)
				for (int k = 0; k <= max_temp; ++k)
					if (live[j][k] == true) {
						if (used[k] == false)
							left[k] = j;
						used[k] = true;
						right[k] = j;
					}
			for (int k = 0; k <= max_temp; ++k)
				if (used[k])
					left_point[left[k]][k] = true;
			for (int j = head[i]; j <= last[i]; ++j) {
				for (int k = 0; k <= max_temp; ++k)
					if (used[k] && left_point[j][k]) {
						int l;
						for (l = 0; l < 20; ++l)
							if (queue[l] == -1)
								break;
						if (l == 20) {
							int max_right = 0;
							int q = 0;
							
							for (l = 1; l < 20; ++l)
								if (right[queue[l]] > right[max_right]) {
									max_right = queue[l];
									q = l;
								}
							if (right[max_right] < right[k])
								reg[k] = get_stack(k);
							else {
								reg[max_right] = get_stack(max_right);
								reg[k] = reg_name[q];
							}
						}
						else {
							reg[k] = reg_name[l];
							queue[l] = k;
						}
					}
				
				for (int k = 0; k < 20; ++k)
					if (queue[k] != -1 && right[queue[k]] == j)
						queue[k] = -1;
			}
		}
	
	public void print(String s) {
		for (int i = 0; i < tab_num; ++i)
			System.out.print("    ");
		System.out.println(s);
	}
	
	public String get_temp(int i) {
		if (is_stack[i]) {
			print("ALOAD t8 "+reg[i]);
			return "t8";
		}
		else
			return reg[i];
	}
}