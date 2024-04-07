package expression;

import supportingpackages.Context;
import expression.literal.IntegerLiteral;
import statementparser.Identifier;

public class Variable extends Expression{
	Identifier id;
	
	public Variable(Identifier id)
	{
		this.id = id;
	}
	
	@Override
	public Expression evaluate(Context c)
	{
		String type = c.checkIdentifier(id);
		//System.out.println(id);
		//System.out.println(type);
		if(type.equals("integer"))
			return c.valueInteger(id);
		else if(type.equals("string"))
			return c.valueString(id);
		else if(type.equals("float"))
			return c.valueFloatingPoint(id);
		else if(type.equals("boolean"))
			return c.valueBoolean(id);
		else if(type.equals("integerArray"))
			return c.getIntegerArray(id);
		else if(type.equals("stringArray"))
			return c.getStringArray(id);
		else if(type.equals("floatArray"))
			return c.getFloatArray(id);
		else if(type.equals("booleanArray"))
			return c.getBooleanArray(id);
		else 
			throw new IllegalArgumentException("no variable found"); 

	}
	
	public String toString()
	{
		return ""+id;
	}
}
