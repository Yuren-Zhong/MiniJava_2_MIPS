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


public class TypeCheckVisitor extends GJDepthFirst<MType,MType>  {
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
	      //n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
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
	      n.f14.accept(this, argu);
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
	      String class_name ;
	      
	      class_name = n.f1.f0.toString();    

	      MClasses all = (MClasses)argu;
	      m_class = all.find_class(class_name);
	      	 //改变当前环境
			 all.PClass = m_class;
			 all.level = 1;
			 n.f3.accept(this, (MClasses)argu);
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
		  String class_name;
		  String error_msg;

		  class_name = n.f1.f0.toString();

	      MClasses all = (MClasses)argu;
		  m_class = all.find_class(class_name);
	      	 //改变当前环境
			 all.PClass = m_class;
			 all.level = 1; 
			 n.f5.accept(this, argu);
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

	      String t_name = "";
	      String i_name = n.f1.f0.toString();
	      //检查是否出现为申明的类型
	      MClasses all = (MClasses)argu;
	      MVariable m_var = all.find_var(i_name);
	      t_name = m_var.type;
	      if (!all.is_exist_type(t_name)){
	    	  System.err.println("Line"+n.f1.f0.beginLine+": "+ t_name + " does not exist");
	      }

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
	      String t_name = "";
	      String i_name = n.f2.f0.toString();
	      
	      MClasses all = (MClasses)argu;
		  MMethod m_method = all.PClass.find_method(i_name);
		  t_name = m_method.type;
		  //检查返回类型是否合法
		  if (!all.is_exist_type(t_name)){
			  System.err.println("Line"+n.f2.f0.beginLine+": " + t_name +" does not exist");
		  }
		  	//改变当前环境
			all.PMethod = m_method;
			all.level = 2;
			n.f4.accept(this, all);
			n.f7.accept(this, all);
			n.f8.accept(this, all);
			//检查return的类型是否合法
			MTypeName expr = (MTypeName)n.f10.accept(this, all);
			if (!all.is_derived(t_name, expr.name))
				System.err.println("Line"+n.f9.beginLine+":" + " return type does not match");
			//回溯
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
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Type()
	    * f1 -> Identifier()
	    */
	   public MType visit(FormalParameter n, MType argu) {
	      MType _ret=null;

	      String i_name = n.f1.f0.toString();

	      MClasses all = (MClasses)argu;
	      MVariable m_var = all.find_var(i_name);
	      //检查type和name是否合法
		  if (m_var == null)
			  System.err.println("Line"+n.f1.f0.beginLine+": " +  i_name + " does not exist");
		  else if (!all.is_exist_type(m_var.type))
			  System.err.println("Line"+n.f1.f0.beginLine+": " +  "type of " + i_name + " does not exist");
	      return _ret;
	   }

	   /**
	    * f0 -> ","
	    * f1 -> FormalParameter()
	    */
	   public MType visit(FormalParameterRest n, MType argu) {
	      MType _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
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
	      _ret = n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "int"
	    * f1 -> "["
	    * f2 -> "]"
	    */
	   public MType visit(ArrayType n, MType argu) {
	      MType _ret=new MTypeName("int[]");
	      return _ret;
	   }

	   /**
	    * f0 -> "boolean"
	    */
	   public MType visit(BooleanType n, MType argu) {
	      MType _ret=new MTypeName("boolean");
	      return _ret;
	   }

	   /**
	    * f0 -> "int"
	    */
	   public MType visit(IntegerType n, MType argu) {
	      MType _ret=new MTypeName("int");
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
	      MTypeName expr_type = (MTypeName)n.f2.accept(this, argu);
	      MVariable m_var = all.find_var(i_name);
	      //检查类型匹配
	      if (m_var == null)
	    	  System.err.println("Line"+n.f0.f0.beginLine+": "+ i_name + " does not exist");
	      else {
	    	  if (expr_type.name.equals("") || !all.is_derived(m_var.type, expr_type.name))
	    		  System.err.println("Line"+n.f0.f0.beginLine+":" + " type mismatch");
	    	  m_var.safe = true;
	      }
	      
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
	      MTypeName expr1 = (MTypeName)n.f2.accept(this, argu);
	      MTypeName expr2 = (MTypeName)n.f5.accept(this, argu);
	      MVariable m_var = all.find_var(i_name);
	      //检查类型匹配
	      if (!m_var.type.equals("int[]"))
	    	  System.err.println("Line"+n.f0.f0.beginLine+": " + i_name + " is not an array of int");
	      else {
	    	  if (!expr1.name.equals("int"))
	    		  System.err.println("Line"+n.f0.f0.beginLine+":" + " the expression in \"[]\" is not an int");
	    	  else {  
	    		  if (!expr2.name.equals("int"))
	    			  System.err.println("Line"+n.f0.f0.beginLine+":" + " the right expression is not an int");
	    	  }
	      }

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
	      MTypeName expr = (MTypeName)n.f2.accept(this, argu);
	      //检查表示式是否为boolean
	      if (!expr.name.equals("boolean"))
	    	  System.err.println("Line"+n.f0.beginLine+":" + " the expression is not a boolean");
	      n.f4.accept(this, argu);
	      n.f6.accept(this, argu);
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
	      MTypeName expr = (MTypeName)n.f2.accept(this, argu);
	      //检查表示式是否为boolean
	      if (!expr.name.equals("boolean"))
	    	  System.err.println("Line"+n.f0.beginLine+":" + " the expression is not a boolean");
	      n.f4.accept(this, argu);
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
	      MTypeName expr = (MTypeName)n.f2.accept(this, argu);
	      //检查表示式是否为int
	      if (!expr.name.equals("int"))
	    	  System.err.println("Line"+n.f0.beginLine+":" + " the value of expression is not an int");
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
		  MTypeName _ret;
	      _ret = (MTypeName)n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "&&"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(AndExpression n, MType argu) {
		  MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  MTypeName expr2 =(MTypeName)n.f2.accept(this, argu);
		  _ret = expr1;
		  //检查两边是否为boolean
		  if (!expr1.name.equals("boolean") || !expr2.name.equals("boolean"))
			  System.err.println("Line"+n.f1.beginLine+":" + " the expressions \"&&\" linked are not boolean");
		  _ret.name = "boolean";
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "<"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(CompareExpression n, MType argu) {
		  MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  MTypeName expr2 =(MTypeName)n.f2.accept(this, argu);
		  _ret = expr1;
		  //检查两边是否为int
		  if (!expr1.name.equals("int") || !expr2.name.equals("int"))
			  System.err.println("Line"+n.f1.beginLine+":" + " the expressions \"<\" linked are not int");
		  _ret.name = "boolean";
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "+"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(PlusExpression n, MType argu) {
		  MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  MTypeName expr2 =(MTypeName)n.f2.accept(this, argu);
		  _ret = expr1;
		  //检查两边是否为int
		  if (!expr1.name.equals("int") || !expr2.name.equals("int"))
			  System.err.println("Line"+n.f1.beginLine+":" + " the expressions \"+\" linked are not int");
		  _ret.name = "int";
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "-"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(MinusExpression n, MType argu) {
		  MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  MTypeName expr2 =(MTypeName)n.f2.accept(this, argu);
		  _ret = expr1;
		  //检查两边是否为int
		  if (!expr1.name.equals("int") || !expr2.name.equals("int"))
			  System.err.println("Line"+n.f1.beginLine+":" + " the expressions \"-\" linked are not int");
		  _ret.name = "int";
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "*"
	    * f2 -> PrimaryExpression()
	    */
	   public MType visit(TimesExpression n, MType argu) {
		  MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  MTypeName expr2 =(MTypeName)n.f2.accept(this, argu);
		  _ret = expr1;
		  //检查两边是否为int
		  if (!expr1.name.equals("int") || !expr2.name.equals("int"))
			  System.err.println("Line"+n.f1.beginLine+":" + " the expressions \"*\" linked are not int");
		  _ret.name = "int";
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "["
	    * f2 -> PrimaryExpression()
	    * f3 -> "]"
	    */
	   public MType visit(ArrayLookup n, MType argu) {
		  MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  MTypeName expr2 =(MTypeName)n.f2.accept(this, argu);
		  _ret = expr1;
		  //检查类型匹配
		  if (!expr1.name.equals("int[]") || !expr2.name.equals("int"))
			  System.err.println("Line"+n.f1.beginLine+":" + " type dismatch");
		  _ret.name = "int";
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "."
	    * f2 -> "length"
	    */
	   public MType visit(ArrayLength n, MType argu) {
	      MTypeName _ret = null;
		  MTypeName expr1 =(MTypeName)n.f0.accept(this, argu);
		  _ret = expr1;
		  //检查类型匹配
		  if (!expr1.name.equals("int[]"))
			  System.err.println("Line"+n.f1.beginLine+":" + " type dismatch");
		  _ret.name = "int";
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
		  MTypeName _ret = new MTypeName("");
		  MTypeName expr = (MTypeName)n.f0.accept(this, argu);
		  
		  String m_name = n.f2.f0.toString();
		  MClasses all = (MClasses)argu;
		  //检查表达式是否合法
		  if (!expr.name.equals("")) {
			  MClass m_class = all.find_class(expr.name);
			  if (m_class != null) {
				  MMethod m_method = m_class.find_method(m_name);
				  //检查方法是否合法
				  if (m_method == null) {
					  System.err.println("Line"+n.f3.beginLine+": " + m_name + " does not exsit");
					  return _ret;
				  }
		  
				  Vector old_list = all.now_list;
				  Vector new_list = new Vector();
		  
				  Vector v1 = m_method.variables;
				  Vector v2 = new_list;
		  
				  all.now_list = new_list;
				  n.f4.accept(this, argu);
				  all.now_list = old_list;
		  
				  _ret.name = m_method.type;
				  //判断参数传递是否合法
				  if (m_method.para_num == v2.size())
					  for (int i = 0; i < v2.size(); ++i) {
						  String n1 = ((MVariable)v1.elementAt(i)).type;
						  String n2 = (String)v2.elementAt(i);
						  if (!all.is_derived(n1, n2)) {
							  System.err.println("Line"+n.f3.beginLine+":" + " parameter list dismatch");
							  break;
						  }
					  }
				  else System.err.println("Line"+n.f3.beginLine+":" + " parameter list dismatch");
			  }
		  }
	      return _ret;
	   }

	   /**
	    * f0 -> Expression()
	    * f1 -> ( ExpressionRest() )*
	    */
	   public MType visit(ExpressionList n, MType argu) {
	      MType _ret=null;
	      MClasses all = (MClasses)argu;
	      
	      //在当前参数传递表中添加一个值
	      MTypeName expr = (MTypeName)n.f0.accept(this, argu);
	      all.now_list.addElement(expr.name);
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
	      //在当前参数传递表中添加一个值
	      MTypeName expr = (MTypeName)n.f1.accept(this, argu);
	      all.now_list.addElement(expr.name);
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
		   MClasses all = (MClasses)argu;
		   boolean old_flag = all.now_flag;
		   all.now_flag = true;
		   MTypeName _ret = (MTypeName)n.f0.accept(this, argu);
		   all.now_flag = false;
	       return _ret;
	   }

	   /**
	    * f0 -> <INTEGER_LITERAL>
	    */
	   public MType visit(IntegerLiteral n, MType argu) {
		  MType _ret = new MTypeName("int"); 
	      return _ret;
	   }

	   /**
	    * f0 -> "true"
	    */
	   public MType visit(TrueLiteral n, MType argu) {
		  MType _ret = new MTypeName("boolean");
	      return _ret;
	   }

	   /**
	    * f0 -> "false"
	    */
	   public MType visit(FalseLiteral n, MType argu) {
		  MType _ret = new MTypeName("boolean");
	      return _ret;
	   }

	   /**
	    * f0 -> <IDENTIFIER>
	    */
	   public MType visit(Identifier n, MType argu) {		   
			MTypeName _ret = new MTypeName("");
			//返回值为id的类型
			String i_name = n.f0.toString();
			MClasses all = (MClasses)argu;
			MVariable m_var = all.find_var(i_name);
			if (m_var != null) {
				_ret.name = m_var.type;
				if (all.now_flag && !m_var.safe)
					System.err.println("Line"+n.f0.beginLine+": " + i_name + " is uninitialized");
			}
			else System.err.println("Line"+n.f0.beginLine+": " + i_name + " does not exist");
			return _ret;
	   }

	   /**
	    * f0 -> "this"
	    */
	   public MType visit(ThisExpression n, MType argu) {
		  MClasses all = (MClasses)argu; 
	      MType _ret = new MTypeName(all.PClass.name);
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
	      MTypeName _ret=null;
	      _ret = (MTypeName)n.f3.accept(this, argu);
	      //检查类型匹配
	      if (!_ret.name.equals("int"))
	    	  System.err.println("Line"+n.f2.beginLine+":" + " type dismatch");
	      _ret.name = "int[]";
	      return _ret;
	   }

	   /**
	    * f0 -> "new"
	    * f1 -> Identifier()
	    * f2 -> "("
	    * f3 -> ")"
	    */
	   public MType visit(AllocationExpression n, MType argu) {
	      MTypeName _ret= new MTypeName("");
	      MClasses all = (MClasses)argu;
	      String i_name = n.f1.f0.toString();
	      MClass m_class = all.find_class(i_name);
	      //检查id是否合法
		  if (m_class != null)
			  _ret.name = m_class.name;
	      else
	    	  System.err.println("Line"+n.f0.beginLine+": " + "class "+ i_name + " does not exsit");
	      return _ret;
	   }

	   /**
	    * f0 -> "!"
	    * f1 -> Expression()
	    */
	   public MType visit(NotExpression n, MType argu) {
	      MTypeName _ret=null;
	      _ret = (MTypeName)n.f1.accept(this, argu);
	      if (!_ret.name.equals("boolean"))
	    	  System.err.println("Line"+n.f0.beginLine+":" + " type dismatch");
	      _ret.name = "boolean";
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> Expression()
	    * f2 -> ")"
	    */
	   public MType visit(BracketExpression n, MType argu) {
	      MType _ret=n.f1.accept(this, argu);
	      return _ret;
	   }
}
