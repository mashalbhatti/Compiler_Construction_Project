package expression;

import statementparser.Identifier;
import supportingpackages.Context;

public class Array extends Expression{
	Identifier id;
	
	public Array(Identifier id)
	{
		this.id = id;
	}
	
	@Override
	public Expression evaluate(Context c)
	{
		String type = c.checkIdentifier(id);
		 if(type.equals("integerArray"))
			return  c.getIntegerArray(id);
		else if(type.equals("stringArray"))
			return (Expression) c.getStringArray(id);
		else if(type.equals("floatArray"))
			return (Expression) c.getFloatArray(id);
		else if(type.equals("booleanArray"))
			return (Expression) c.getBooleanArray(id);
		else 
			throw new IllegalArgumentException("No array found!");

		
	}
	
	public String toString()
	{
		return ""+id;
	}

}
