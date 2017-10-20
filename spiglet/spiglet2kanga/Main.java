package spiglet.spiglet2kanga;

import spiglet.ParseException;
import spiglet.SpigletParser;
import spiglet.TokenMgrError;
import spiglet.syntaxtree.Node;
import spiglet.visitor.GJDepthFirst;
import spiglet.visitor.LivenessVisitor;
import spiglet.visitor.Spiglet2KangaVisitor;




public class Main { 
 
    public static void main(String[] args) {
    	try {
    		Node root = new SpigletParser(System.in).Goal();
    		Environment environ = new Environment();
    		LivenessVisitor v1 = new LivenessVisitor();
    		Spiglet2KangaVisitor v2 = new Spiglet2KangaVisitor();
    		root.accept(v1,environ);
    		environ.last[environ.p_num] = environ.s_num;
    		environ.get_interval();
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