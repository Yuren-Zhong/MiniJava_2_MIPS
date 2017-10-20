package minijava.visitor;

import java.util.Enumeration;
import java.util.Vector;

import minijava.symboltable.MClass;
import minijava.symboltable.MClasses;
import minijava.symboltable.MType;
import minijava.symboltable.MTypeName;
import minijava.symboltable.MVariable;
import minijava.symboltable.MMethod;
import minijava.syntaxtree.AllocationExpression;
import minijava.syntaxtree.AndExpression;
import minijava.syntaxtree.ArrayAllocationExpression;
import minijava.syntaxtree.ArrayAssignmentStatement;
import minijava.syntaxtree.ArrayLength;
import minijava.syntaxtree.ArrayLookup;
import minijava.syntaxtree.ArrayType;
import minijava.syntaxtree.AssignmentStatement;
import minijava.syntaxtree.Block;
import minijava.syntaxtree.BooleanType;
import minijava.syntaxtree.BracketExpression;
import minijava.syntaxtree.ClassDeclaration;
import minijava.syntaxtree.ClassExtendsDeclaration;
import minijava.syntaxtree.CompareExpression;
import minijava.syntaxtree.Expression;
import minijava.syntaxtree.ExpressionList;
import minijava.syntaxtree.ExpressionRest;
import minijava.syntaxtree.FalseLiteral;
import minijava.syntaxtree.FormalParameter;
import minijava.syntaxtree.FormalParameterList;
import minijava.syntaxtree.FormalParameterRest;
import minijava.syntaxtree.Goal;
import minijava.syntaxtree.Identifier;
import minijava.syntaxtree.IfStatement;
import minijava.syntaxtree.IntegerLiteral;
import minijava.syntaxtree.IntegerType;
import minijava.syntaxtree.MainClass;
import minijava.syntaxtree.MessageSend;
import minijava.syntaxtree.MethodDeclaration;
import minijava.syntaxtree.MinusExpression;
import minijava.syntaxtree.Node;
import minijava.syntaxtree.NodeList;
import minijava.syntaxtree.NodeListOptional;
import minijava.syntaxtree.NodeOptional;
import minijava.syntaxtree.NodeSequence;
import minijava.syntaxtree.NodeToken;
import minijava.syntaxtree.NotExpression;
import minijava.syntaxtree.PlusExpression;
import minijava.syntaxtree.PrimaryExpression;
import minijava.syntaxtree.PrintStatement;
import minijava.syntaxtree.Statement;
import minijava.syntaxtree.ThisExpression;
import minijava.syntaxtree.TimesExpression;
import minijava.syntaxtree.TrueLiteral;
import minijava.syntaxtree.Type;
import minijava.syntaxtree.TypeDeclaration;
import minijava.syntaxtree.VarDeclaration;
import minijava.syntaxtree.WhileStatement;


public class minijava2pigletVisitor extends GJDepthFirst<MType,MType>  {
	//
	   // Auto class visitors--probably don't need to be overridden.
	   //
	   public MType visit(NodeList n, MType argu) {
	      MType _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this,argu);
	         _count++;
	      }
	      return _ret;
	   }

	   public MType visit(NodeListOptional n, MType argu) {
	      if ( n.present() ) {
	         MType _ret=null;
	         int _count=0;
	         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	            e.nextElement().accept(this,argu);
	            _count++;
	         }
	         return _ret;
	      }
	      else
	         return null;
	   }

	   public MType visit(NodeOptional n, MType argu) {
	      if ( n.present() )
	         return n.node.accept(this,argu);
	      else
	         return null;
	   }

	   public MType visit(NodeSequence n, MType argu) {
	      MType _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this,argu);
	         _count++;
	      }
	      return _ret;
	   }

	   public MType visit(NodeToken n, MType argu) { return null; }

	   //
	   // User-generated visitor methods below
	   //

	   /**
	    * f0 -> MainClass()
	    * f1 -> ( TypeDeclaration() )*
	    * f2 -> <EOF>
	    */
	   public MType visit(Goal n, MType argu) {
	      MType _ret=null;
	      
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      
	      return _ret;
	   }

	   /**
	    * f0 -> "class"
	    * f1 -> Identifier()
	    * f2 -> "{"
	    * f3 -> "public"
	    * f4 -> "static"
	    * f5 -> "void"
	    * f6 -> "main"
	    * f7 -> "("
	    * f8 -> "String"
	    * f9 -> "["
	    * f10 -> "]"
	    * f11 -> Identifier()
	    * f12 -> ")"
	    * f13 -> "{"
	    * f14 -> PrintStatement()
	    * f15 -> "}"
	    * f16 -> "}"
	    */
	   public MType visit(MainClass n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      all.write("MAIN"); ++all.tab_num;
	      n.f14.accept(this, argu);
	      --all.tab_num; all.write("END"); all.write("");
	      
	      return _ret;
	   }

	   /**
	    * f0 -> ClassDeclaration()
	    *       | ClassExtendsDeclaration()
	    */
	   public MType visit(TypeDeclaration n, MType argu) {
	      MType _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "class"
	    * f1 -> Identifier()
	    * f2 -> "{"
	    * f3 -> ( VarDeclaration() )*
	    * f4 -> ( MethodDeclaration() )*
	    * f5 -> "}"
	    */
	   public MType visit(ClassDeclaration n, MType argu) {
	      MType _ret=null;
	      MClass m_class ;
	      String class_name = n.f1.f0.toString();    

	      MClasses all = (MClasses)argu;
	      m_class = all.find_class(class_name);
	      	 //改变当前环境
			 all.PClass = m_class;
			 all.level = 1;
			 n.f4.accept(this, (MClasses)argu);
			 //回溯
			 all.PClass = null;
			 all.level = 0;
			 
	      return _ret;
	   }

	   /**
	    * f0 -> "class"
	    * f1 -> Identifier()
	    * f2 -> "extends"
	    * f3 -> Identifier()
	    * f4 -> "{"
	    * f5 -> ( VarDeclaration() )*
	    * f6 -> ( MethodDeclaration() )*
	    * f7 -> "}"
	    */
	   public MType visit(ClassExtendsDeclaration n, MType argu) {
	      MType _ret=null;
	      MClass m_class;
		  String class_name = n.f1.f0.toString();

	      MClasses all = (MClasses)argu;
		  m_class = all.find_class(class_name);
	      	 //改变当前环境
			 all.PClass = m_class;
			 all.level = 1; 
			 n.f6.accept(this, argu);
			 //回溯
			 all.PClass = null;
			 all.level = 0;
		  
	      return _ret;
	   }

	   /**
	    * f0 -> Type()
	    * f1 -> Identifier()
	    * f2 -> ";"
	    */
	   public MType visit(VarDeclaration n, MType argu) {
	      MType _ret=null;

	      return _ret;
	   }

	   /**
	    * f0 -> "public"
	    * f1 -> Type()
	    * f2 -> Identifier()
	    * f3 -> "("
	    * f4 -> ( FormalParameterList() )?
	    * f5 -> ")"
	    * f6 -> "{"
	    * f7 -> ( VarDeclaration() )*
	    * f8 -> ( Statement() )*
	    * f9 -> "return"
	    * f10 -> Expression()
	    * f11 -> ";"
	    * f12 -> "}"
	    */
	   public MType visit(MethodDeclaration n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      String i_name = n.f2.f0.toString();
		  MMethod m_method = all.PClass.find_method(i_name);
		  all.PMethod = m_method;
		  all.level = 2;
		  all.temp_last = 1;
		  
		  all.write(all.PClass.name+"__"+i_name+" [2]"); ++all.tab_num;
		  all.write("BEGIN"); ++all.tab_num;
		  
		  n.f8.accept(this, argu);
		  
		  --all.tab_num; all.write("RETURN"); ++all.tab_num;
		  n.f10.accept(this, argu);
		  --all.tab_num; all.write("END"); --all.tab_num;
		  all.write("");
		  
		  all.PMethod = null;
		  all.level = 1;
		  
	      return _ret;
	   }

	   /**
	    * f0 -> FormalParameter()
	    * f1 -> ( FormalParameterRest() )*
	    */
	   public MType visit(FormalParameterList n, MType argu) {
	      MType _ret=null;

	      return _ret;
	   }

	   /**
	    * f0 -> Type()
	    * f1 -> Identifier()
	    */
	   public MType visit(FormalParameter n, MType argu) {
	      MType _ret=null;

	      return _ret;
	   }

	   /**
	    * f0 -> ","
	    * f1 -> FormalParameter()
	    */
	   public MType visit(FormalParameterRest n, MType argu) {
	      MType _ret=null;

	      return _ret;
	   }

	   /**
	    * f0 -> ArrayType()
	    *       | BooleanType()
	    *       | IntegerType()
	    *       | Identifier()
	    */
	   public MType visit(Type n, MType argu) {
	      MType _ret=null;

	      return _ret;
	   }

	   /**
	    * f0 -> "int"
	    * f1 -> "["
	    * f2 -> "]"
	    */
	   public MType visit(ArrayType n, MType argu) {
	      MType _ret=null;
	      
	      return _ret;
	   }

	   /**
	    * f0 -> "boolean"
	    */
	   public MType visit(BooleanType n, MType argu) {
	      MType _ret=null;
	      
	      return _ret;
	   }

	   /**
	    * f0 -> "int"
	    */
	   public MType visit(IntegerType n, MType argu) {
	      MType _ret=null;
	      
	      return _ret;
	   }

	   /**
	    * f0 -> Block()
	    *       | AssignmentStatement()
	    *       | ArrayAssignmentStatement()
	    *       | IfStatement()
	    *       | WhileStatement()
	    *       | PrintStatement()
	    */
	   public MType visit(Statement n, MType argu) {
	      MType _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "{"
	    * f1 -> ( Statement() )*
	    * f2 -> "}"
	    */
	   public MType visit(Block n, MType argu) {
	      MType _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Identifier()
	    * f1 -> "="
	    * f2 -> Expression()
	    * f3 -> ";"
	    */
	   public MType visit(AssignmentStatement n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      String i_name = n.f0.f0.toString();
	      all.get_address(i_name);
	      
	      all.write("HSTORE TEMP " + all.head + " " + all.offset); ++all.tab_num;
	      n.f2.accept(this, argu);
	      --all.tab_num;
	      
	      return _ret;
	   }

	   /**
	    * f0 -> Identifier()
	    * f1 -> "["
	    * f2 -> Expression()
	    * f3 -> "]"
	    * f4 -> "="
	    * f5 -> Expression()
	    * f6 -> ";"
	    */
	   public MType visit(ArrayAssignmentStatement n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      String i_name = n.f0.f0.toString();
	      all.get_address(i_name);
	      
	      int t1 = ++all.temp_last;
	      int t2 = ++all.temp_last;
	      all.write("HLOAD TEMP " + t1 + " TEMP " + all.head + " " + all.offset);
	      all.write("MOVE TEMP "+t2+" PLUS TEMP " + t1); ++all.tab_num;
	      
	      all.write("TIMES 4");
	      all.write("PLUS 1"); ++all.tab_num;
	      n.f2.accept(this, argu); --all.tab_num;
	      
	      --all.tab_num;
	      all.write("HSTORE TEMP "+t2+" 0 "); ++all.tab_num;
	      n.f5.accept(this, argu);
	      --all.tab_num;
	      return _ret;
	   }

	   /**
	    * f0 -> "if"
	    * f1 -> "("
	    * f2 -> Expression()
	    * f3 -> ")"
	    * f4 -> Statement()
	    * f5 -> "else"
	    * f6 -> Statement()
	    */
	   public MType visit(IfStatement n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      int t1 = ++all.temp_last;
	      all.write("MOVE TEMP "+t1); ++all.tab_num;
	      n.f2.accept(this, argu); --all.tab_num;
	      
	      int l1 = ++all.label_last;
	      int l2 = ++all.label_last;
	      
	      all.write("CJUMP TEMP "+t1+" L"+l1); ++all.tab_num;
	      n.f4.accept(this, argu);
	      --all.tab_num; all.write("JUMP L"+l2);
	      
	      all.write("L"+l1+" NOOP"); ++all.tab_num;
	      n.f6.accept(this, argu);
	      --all.tab_num; all.write("L"+l2+" NOOP");
	      return _ret;
	   }

	   /**
	    * f0 -> "while"
	    * f1 -> "("
	    * f2 -> Expression()
	    * f3 -> ")"
	    * f4 -> Statement()
	    */
	   public MType visit(WhileStatement n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      int l1 = ++all.label_last;
	      int l2 = ++all.label_last;
	      
	      all.write("L"+l1+" NOOP"); ++all.tab_num;
	      
	      int t1 = ++all.temp_last;
	      all.write("MOVE TEMP "+t1); ++all.tab_num;
	      n.f2.accept(this, argu); --all.tab_num;
	      
	      --all.tab_num; all.write("CJUMP TEMP "+t1+" L"+l2); ++all.tab_num;
	      n.f4.accept(this, argu);
	      --all.tab_num; all.write("JUMP L"+l1);
	      all.write("L"+l2+" NOOP");
	      
	      return _ret;
	   }

	   /**
	    * f0 -> "System.err.println"
	    * f1 -> "("
	    * f2 -> Expression()
	    * f3 -> ")"
	    * f4 -> ";"
	    */
	   public MType visit(PrintStatement n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      all.write("PRINT"); ++all.tab_num;
	      n.f2.accept(this, argu);
	      --all.tab_num;
	      
	      return _ret;
	   }

	   /**
	    * f0 -> AndExpression()
	    *       | CompareExpression()
	    *       | PlusExpression()
	    *       | MinusExpression()
	    *       | TimesExpression()
	    *       | ArrayLookup()
	    *       | ArrayLength()
	    *       | MessageSend()
	    *       | PrimaryExpression()
	    */
	   public MType visit(Expression n, MType argu) {
		  MType _ret=null;
		  n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "&&"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(AndExpression n, MType argu) {
		  MType _ret=null;
		  MClasses all = (MClasses)argu;
		  
		  int t1 = ++all.temp_last;
		  int t2 = ++all.temp_last;
		  int t3 = ++all.temp_last;
		  int l1 = ++all.tab_num;
		  
		  all.write("BEGIN"); ++all.tab_num;
		  all.write("MOVE TEMP "+t3+" 0");
		  
		  all.write("MOVE TEMP "+t1); ++all.tab_num;
		  n.f0.accept(this, argu); --all.tab_num;
		  all.write("CJUMP TEMP "+t1+" L"+l1);
		  
		  all.write("MOVE TEMP "+t2); ++all.tab_num;
		  n.f2.accept(this, argu); --all.tab_num;
		  all.write("CJUMP TEMP "+t2+" L"+l1);
		  
		  all.write("MOVE TEMP "+t3+" 1");
		  
		  --all.tab_num; all.write("L"+l1+" NOOP");
		  all.write("RETURN TEMP "+t3);
		  all.write("END");
		  
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "<"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(CompareExpression n, MType argu) {
		  MType _ret=null;
		  MClasses all = (MClasses)argu;
		  
		  all.write("LT "); ++all.tab_num;
		  n.f0.accept(this, argu);
		  n.f2.accept(this, argu);
		  --all.tab_num;
		  
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "+"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(PlusExpression n, MType argu) {
		   	  MType _ret=null;
			  MClasses all = (MClasses)argu;
			  
			  all.write("PLUS "); ++all.tab_num;
			  n.f0.accept(this, argu);
			  n.f2.accept(this, argu);
			  --all.tab_num;
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "-"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(MinusExpression n, MType argu) {
		      MType _ret=null;
			  MClasses all = (MClasses)argu;
			  
			  all.write("MINUS "); ++all.tab_num;
			  n.f0.accept(this, argu);
			  n.f2.accept(this, argu);
			  --all.tab_num;
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "*"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(TimesExpression n, MType argu) {
		   	  MType _ret=null;
			  MClasses all = (MClasses)argu;
			  
			  all.write("TIMES "); ++all.tab_num;
			  n.f0.accept(this, argu);
			  n.f2.accept(this, argu);
			  --all.tab_num;
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "["
	    * f2 -> PrimaryExpression()
	    * f3 -> "]"
	    */
	   public MType visit(ArrayLookup n, MType argu) {
		  MType _ret=null;
		  MClasses all = (MClasses)argu;
		  
		  int t1 = ++all.temp_last;
		  int t2 = ++all.temp_last;
		  int t3 = ++all.temp_last;
		  int t4 = ++all.temp_last;
		  
		  all.write("BEGIN"); ++all.tab_num;
		  
		  all.write("MOVE TEMP "+t1); ++all.tab_num;
		  n.f0.accept(this, argu); --all.tab_num;
		  
		  all.write("MOVE TEMP "+t2); ++all.tab_num;
		  all.write("TIMES 4");
		  all.write("PLUS 1"); ++all.tab_num;
		  n.f2.accept(this, argu); --all.tab_num;
		  --all.tab_num;
		  
		  all.write("MOVE TEMP "+t3+" PLUS TEMP "+t1+" TEMP "+t2); 
		  all.write("HLOAD TEMP "+t4+" TEMP "+t3+" 0"); --all.tab_num;
		  all.write("RETURN TEMP "+t4);
		  all.write("END");
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "."
	    * f2 -> "length"
	    */
	   public MType visit(ArrayLength n, MType argu) {
		  MType _ret=null;
		  MClasses all = (MClasses)argu;
		  
		  int t1 = ++all.temp_last;
		  int t2 = ++all.temp_last;
		  
		  all.write("BEGIN"); ++all.tab_num;
		  all.write("MOVE TEMP "+t1); ++all.tab_num;
		  n.f0.accept(this, argu); --all.tab_num;
		  
		  all.write("HLOAD TEMP "+t2+" TEMP "+t1+" 0"); --all.tab_num;
		  all.write("RETURN TEMP "+t2);
		  all.write("END");
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "."
	    * f2 -> Identifier()
	    * f3 -> "("
	    * f4 -> ( ExpressionList() )?
	    * f5 -> ")"
	    */
	   public MType visit(MessageSend n, MType argu) {
		  MType _ret=null;
		  MClasses all = (MClasses)argu;
		  
		  all.write("BEGIN"); ++all.tab_num;
		  
		  int t1 = ++all.temp_last;
		  int t2 = ++all.temp_last;
		  int t3 = ++all.temp_last;
		  
		  all.write("MOVE TEMP "+t1); ++all.tab_num;
		  n.f0.accept(this, argu); --all.tab_num;
		  all.write("HLOAD TEMP "+t2+" TEMP "+t1+" 0");
		  all.write("HLOAD TEMP "+t3+" TEMP "+t2+" "+all.get_method_offset(n.f2.f0.toString()));
		  
		  int len = all.get_method_para(n.f2.f0.toString()) + 1;
		  int t4 = ++all.temp_last;
		  all.write("MOVE TEMP "+t4+" HALLOCATE "+len * 4);
		  
		  int old_temp = all.now_temp;
		  int old_temp_num = all.now_temp_num;
		  all.now_temp = t4;
		  all.now_temp_num = 0;
		  n.f4.accept(this, argu);
		  
		  --all.tab_num;
		  all.write("RETURN CALL TEMP "+t3+" (TEMP "+t1+" TEMP "+t4+")");
		  all.write("END");
		  
		  all.now_temp = old_temp;
		  all.now_temp_num = old_temp_num;
		  
	      return _ret;
	   }

	   /**
	    * f0 -> Expression()
	    * f1 -> ( ExpressionRest() )*
	    */
	   public MType visit(ExpressionList n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      all.write("HSTORE TEMP "+all.now_temp+" "+all.now_temp_num); ++all.tab_num;
	      n.f0.accept(this, argu); --all.tab_num;
	      all.now_temp_num += 4;
	      n.f1.accept(this, argu);
	      
	      return _ret;
	   }

	   /**
	    * f0 -> ","
	    * f1 -> Expression()
	    */
	   public MType visit(ExpressionRest n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      all.write("HSTORE TEMP "+all.now_temp+" "+all.now_temp_num); ++all.tab_num;
	      n.f1.accept(this, argu); --all.tab_num;
	      all.now_temp_num += 4;
	      
	      return _ret;
	   }

	   /**
	    * f0 -> IntegerLiteral()
	    *       | TrueLiteral()
	    *       | FalseLiteral()
	    *       | Identifier()
	    *       | ThisExpression()
	    *       | ArrayAllocationExpression()
	    *       | AllocationExpression()
	    *       | NotExpression()
	    *       | BracketExpression()
	    */
	   public MType visit(PrimaryExpression n, MType argu) {
		   MType _ret=null;
		   n.f0.accept(this, argu);
	       return _ret;
	   }

	   /**
	    * f0 -> <INTEGER_LITERAL>
	    */
	   public MType visit(IntegerLiteral n, MType argu) {
		  MType _ret = null;
		  MClasses all = (MClasses)argu;
		  
		  all.write(n.f0.toString());
	      return _ret;
	   }

	   /**
	    * f0 -> "true"
	    */
	   public MType visit(TrueLiteral n, MType argu) {
		  MType _ret = null;
		  MClasses all = (MClasses)argu;
			  
		  all.write("1");
	      return _ret;
	   }

	   /**
	    * f0 -> "false"
	    */
	   public MType visit(FalseLiteral n, MType argu) {
		   MType _ret = null;
		   MClasses all = (MClasses)argu;
				  
		   all.write("0");
		   return _ret;
	   }

	   /**
	    * f0 -> <IDENTIFIER>
	    */
	   public MType visit(Identifier n, MType argu) {		   
		   MType _ret = null;
		   MClasses all = (MClasses)argu;
		   
		   String i_name = n.f0.toString();
		   all.get_address(i_name);
		   
		   all.write("BEGIN"); ++all.tab_num;
		   int t1 = ++all.temp_last;
		   all.write("HLOAD TEMP "+t1+" TEMP "+all.head+" "+all.offset); --all.tab_num;
		   all.write("RETURN TEMP "+t1);
		   all.write("END");
		   
		   return _ret;
	   }

	   /**
	    * f0 -> "this"
	    */
	   public MType visit(ThisExpression n, MType argu) {
		  MType _ret = null;
		  MClasses all = (MClasses)argu;
		  all.write("TEMP 0");
	      return _ret;
	   }

	   /**
	    * f0 -> "new"
	    * f1 -> "int"
	    * f2 -> "["
	    * f3 -> Expression()
	    * f4 -> "]"
	    */
	   public MType visit(ArrayAllocationExpression n, MType argu) {
		  MType _ret = null;
		  MClasses all = (MClasses)argu;
		  
		  all.write("BEGIN"); ++all.tab_num;
		  int t1 = ++all.temp_last;
		  int t2 = ++all.temp_last;
		  
		  all.write("MOVE TEMP "+t1); ++all.tab_num;
		  n.f3.accept(this, argu); --all.tab_num;
		  
		  all.write("MOVE TEMP "+t2+" HALLOCATE TIMES 4 PLUS 1 TEMP "+t1);
		  all.write("HSTORE TEMP "+t2+" 0 TEMP "+t1);
		  --all.tab_num;
		  all.write("RETURN TEMP "+t2);
		  all.write("END");
		  
	      return _ret;
	   }

	   /**
	    * f0 -> "new"
	    * f1 -> Identifier()
	    * f2 -> "("
	    * f3 -> ")"
	    */
	   public MType visit(AllocationExpression n, MType argu) {
		  MType _ret = null;
		  MClasses all = (MClasses)argu;
		  
		  int t1 = ++all.temp_last;
		  int t2 = ++all.temp_last;
		  
		  all.write("BEGIN"); ++all.tab_num;
		  all.write("MOVE TEMP "+t1+" HALLOCATE "+(all.hash_var.size()+1)*4);
		  all.write("MOVE TEMP "+t2+" HALLOCATE "+(all.hash_method.size())*4);
		  all.write("HSTORE TEMP "+t1+" 0 TEMP "+t2);
		  
		  boolean used[] = new boolean[all.hash_method.size()];
		  for (int i = 0; i < all.hash_method.size(); ++i)
			  used[i] = false;
		  
		  MClass m_class = all.find_class(n.f1.f0.toString());
		  while (m_class != null) {
			  for (int i = 0; i < m_class.methods.size(); ++i) {
				  MMethod m_method = (MMethod)m_class.methods.elementAt(i);
				  String m_name = m_method.name;
				  int method_num = all.get_method_offset(m_name)/4;
				  if (!used[method_num]) {
					  used[method_num] = true;
					  all.write("HSTORE TEMP "+t2+" "+method_num * 4+" "+m_class.name+"__"+m_name);
				  }
			  }
			  m_class = all.find_class(m_class.fa_name);
		  }
		  --all.tab_num;
		  all.write("RETURN TEMP "+t1);
		  all.write("END");
		  
	      return _ret;
	   }

	   /**
	    * f0 -> "!"
	    * f1 -> Expression()
	    */
	   public MType visit(NotExpression n, MType argu) {
		  MType _ret = null;
	      MClasses all = (MClasses)argu;
	      
	      all.write("LT"); ++all.tab_num;
	      n.f1.accept(this, argu);
	      --all.tab_num; all.write("1");
	      
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> Expression()
	    * f2 -> ")"
	    */
	   public MType visit(BracketExpression n, MType argu) {
		  MType _ret = null;
		  n.f1.accept(this, argu);
	      return _ret;
	   }
}
