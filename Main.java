import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream outstream=new ByteArrayOutputStream();
		while (true){
			int temp=System.in.read();
			if (temp==-1) break;
			outstream.write(temp);
		}		
		PrintStream old=System.out;
		System.setOut(new PrintStream(outstream));
	
			System.setIn(new ByteArrayInputStream(outstream.toByteArray().clone()));			
			outstream.reset();
			new minijava.minijava2piglet.Main().main(args);
			
			System.setIn(new ByteArrayInputStream(outstream.toByteArray().clone()));
			outstream.reset();			
			new piglet.piglet2spiglet.Main().main(args);
			
			System.setIn(new ByteArrayInputStream(outstream.toByteArray().clone()));
			outstream.reset();
			new spiglet.spiglet2kanga.Main().main(args);
			
			System.setIn(new ByteArrayInputStream(outstream.toByteArray().clone()));
			System.setOut(old);
			new kanga.kanga2mips.Main().main(args);
	}
}