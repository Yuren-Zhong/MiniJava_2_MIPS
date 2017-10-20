package kanga.kanga2mips;

import kanga.KangaParser;
import kanga.ParseException;
import kanga.TokenMgrError;
import kanga.syntaxtree.Node;
import kanga.visitor.Kanga2MipsVisitor;

public class Main {

	public static void main(String[] args) {
		try {
			Node root = new KangaParser(System.in).Goal();
			Kanga2MipsVisitor v = new Kanga2MipsVisitor();
			Environment environ = new Environment();
			root.accept(v, environ);
		} catch (TokenMgrError e) {
			// Handle Lexical Errors
			e.printStackTrace();
		} catch (ParseException e) {
			// Handle Grammar Errors
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}