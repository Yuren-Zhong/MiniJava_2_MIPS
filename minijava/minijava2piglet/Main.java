package minijava.minijava2piglet;

import minijava.MiniJavaParser;
import minijava.ParseException;
import minijava.TokenMgrError;
import minijava.symboltable.MClasses;
import minijava.symboltable.MType;
import minijava.syntaxtree.Node;
import minijava.visitor.BuildSymbolTableVisitor;
import minijava.visitor.minijava2pigletVisitor;
import minijava.visitor.GJDepthFirst;
import java.io.*;


public class Main { 
 
    public static void main(String[] args) {
    	try {
    		File f = new File("/home/master/Documents/test/Factorial.java");
			f.createNewFile();
			FileInputStream fs = new FileInputStream(f);
    		Node root = new MiniJavaParser(fs).Goal();
			//Node root = new MiniJavaParser(System.in).Goal();
    		//初始化符号表中最大的类
			MClasses my_classes = new MClasses();
    		//Traverse the Abstract Grammar Tree
    		root.accept(new BuildSymbolTableVisitor(),my_classes);
    		//Print the SymbolTable
    		//my_classes.check_symboltable();
    		//my_classes.print();
    		//Traverse second time
    		//root.accept(new TypeCheckVisitor(), my_classes);
    		my_classes.build_hashtable();
    		root.accept(new minijava2pigletVisitor(), my_classes);
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