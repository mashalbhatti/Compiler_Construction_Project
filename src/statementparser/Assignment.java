package statementparser;

import supportingpackages.Context;
import expression.Expression;
import expression.literal.*;

public class Assignment extends Statement{
	
	Identifier identifier;
	Expression expression;
	
	public Assignment(Identifier id, Expression expr)
	{
		this.identifier = id;
		this.expression = expr;
	}
	
	public void execute(Context c)
	{
		Expression e = expression.evaluate(c);
		String type = c.checkIdentifier(identifier);
		if(type == "integer")
			c.assignInteger(identifier, (IntegerLiteral)e);
		else if(type == "string")
			c.assignString(identifier, (StringLiteral)e);
		else if(type == "float")
			c.assignFloat(identifier, (FloatingPointLiteral)e);
		else if(type == "boolean")
			c.assignBoolean(identifier, (BooleanLiteral)e);
		else if(type == "No identifier found error")
			throw new IllegalArgumentException("no variable found "+ identifier);
		//c.assignFloat(identifier, (FloatingPointLiteral)e);
		//c.assignInteger(identifier, (IntegerLiteral)e);
		
		if (next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = identifier + "=" + expression + ";";
		if(next != null)
			a+=next;
		return a;
	}

}
