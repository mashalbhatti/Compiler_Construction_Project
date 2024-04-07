package statementparser;

import supportingpackages.Context;
import expression.Expression;
import expression.literal.*;

public class Initialization extends Statement{
	Identifier identifier;
	String type;
	
	public Initialization(String t, Identifier id)
	{
		this.identifier = id;
		this.type = t;
	}

	@Override
	public void execute(Context c) {
		if(type.equals("integer")) {
			c.addNewInteger(identifier, (IntegerLiteral)null);
		}else if(type.equals("string")) {
			c.addNewString(identifier, (StringLiteral)null);
		}else if(type.equals("float")) {
			c.addNewFloat(identifier, (FloatingPointLiteral)null);
		}else if(type.equals("boolean")) {
			c.addNewBoolean(identifier, (BooleanLiteral)null); 
		}
		
		if(next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = type +" "+ identifier + ";\n";
		
		if(next!=null)
			a+=next;
		return a;
	}
	

}
