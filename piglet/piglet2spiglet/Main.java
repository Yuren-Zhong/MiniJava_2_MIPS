package piglet.piglet2spiglet;


import piglet.ParseException;
import piglet.PigletParser;
import piglet.TokenMgrError;
import piglet.syntaxtree.Node;
import piglet.visitor.GetMaxTempVisitor;
import piglet.visitor.Piglet2SpigletVisitor;


public class Main { 
 
    public static void main(String[] args) {
    	try {
    		Node root = new PigletParser(System.in).Goal();
    		Environment environ = new Environment();
    		GetMaxTempVisitor v1 = new GetMaxTempVisitor();
    		Piglet2SpigletVisitor v2 = new Piglet2SpigletVisitor();
    		//Traverse the Abstract Grammar Tree
    		root.accept(v1,environ);
    		root.accept(v2,environ);
    	}
    	catch(TokenMgrError e){
    		//Handle Lexical Errors
    		e.printStackTrace();
    	}
    	catch (ParseException e){
    		//Handle Grammar Errors
    		e.printStackTrace();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
}