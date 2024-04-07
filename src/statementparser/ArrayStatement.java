package statementparser;

import java.util.List;

import expression.Expression;
import expression.literal.*;
import supportingpackages.Context;



public class ArrayStatement extends Statement {

	List<Expression> literal; 
	Identifier identifier;
	String type; 
	
	public ArrayStatement(String t, Identifier id, List<Expression> lit)
	{
		this.identifier = id;
		this.type = t; 
		this.literal = lit; 
	} 
	
	@Override
	public void execute(Context c) { 
		
		if(type.equals("integer")) 
		{
			List<IntegerLiteral> integerList = (List<IntegerLiteral>)(List<?>) literal; 
			c.setIntegerArray(identifier, integerList); 	
		}
		else if(type.equals("string")) {
			List<StringLiteral> stringList = (List<StringLiteral>)(List<?>) literal; 
			c.setStringArray(identifier, stringList); 
		}
		else if(type.equals("float")) {
			List<FloatingPointLiteral> floatList = (List<FloatingPointLiteral>)(List<?>) literal; 
			c.setFloatArray(identifier, floatList);
		}
		else if(type.equals("boolean")) {
			List<BooleanLiteral> booleanList = (List<BooleanLiteral>)(List<?>) literal; 
			c.setBooleanArray(identifier, booleanList);
		}
		
		if(next != null)
			next.execute(c); 
	}

	
	public String toString()
	{
		String a = type + identifier + " = " + literal.toString() + ";\n";
		
		if(next!=null)
			a+=next;
		return a;
	} 
	
}
