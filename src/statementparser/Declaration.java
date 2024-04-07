package statementparser;

import supportingpackages.Context;
import expression.Expression;
import expression.literal.*;

public class Declaration extends Statement{
	
	Identifier identifier;
	Expression value;
	String ty;
	
	public Declaration(String t, Identifier id, Expression expr)
	{
		this.identifier = id;
		this.ty = t;
		this.value = expr;
	}
	
	@Override
	public void execute(Context c)
	{
		Expression e = value.evaluate(c);
		
		if(ty.equals("integer")) {
			c.addNewInteger(identifier, (IntegerLiteral)e);
		}else if(ty.equals("string")) {
			c.addNewString(identifier, (StringLiteral)e);
		}else if(ty.equals("float")) {
			c.addNewFloat(identifier, (FloatingPointLiteral)e);
		}else if(ty.equals("boolean")) {
			c.addNewBoolean(identifier, (BooleanLiteral)e); 
		}
		
		if(next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = ty +" "+ identifier + " := " + value + ";\n";
		
		if(next!=null)
			a+=next;
		return a;
	}
}
