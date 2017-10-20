//
// Generated by JTB 1.3.2
//

package kanga.syntaxtree;

/**
 * The interface which NodeList, NodeListOptional, and NodeSequence
 * implement.
 */
public interface NodeListInterface extends Node {
   public void addNode(Node n);
   public Node elementAt(int i);
   public java.util.Enumeration<Node> elements();
   public int size();

   public void accept(kanga.visitor.Visitor v);
   public <R,A> R accept(kanga.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(kanga.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(kanga.visitor.GJVoidVisitor<A> v, A argu);
}

