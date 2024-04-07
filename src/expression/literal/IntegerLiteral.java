package expression.literal;

import supportingpackages.Context;
import expression.Expression;

public class IntegerLiteral extends Comparable {
	
	public int value;
	public IntegerLiteral next;
	public IntegerLiteral (int value)
	{
		this.value = value;
	}
	
	@Override
	public Expression evaluate(Context c)
	{
		return this;
	}
	
	public int value()
	{
		return value;
	}
	
	public String toString()
	{
		String a = ""+ value;
		if(next != null)
		{
			a += ","+next;
		}
		return a;
		
	}
	
	@Override
	public int compare (Comparable c)
	{
		if(((Object)c).getClass().getSimpleName().equals("FloatingPointLiteral")) { 
			
			return (int) (value - ((FloatingPointLiteral) c).value);
		
		}
		else {
		
			return value - ((IntegerLiteral) c).value;
		
		} 
	}
	
	@Override
	public boolean equal(Equatable e) 
	{ 		
		if(((Object)e).getClass().getSimpleName().equals("FloatingPointLiteral")) { 
		
			return value == ((FloatingPointLiteral) e).value; 
		
		}
		else {
		
			return value == ((IntegerLiteral) e).value;
		
		}
	}

}
