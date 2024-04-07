package expression.literal;

import supportingpackages.Context;
import expression.Expression;

public class FloatingPointLiteral extends Comparable {
	
	public double value;
	public FloatingPointLiteral next;
	
	public FloatingPointLiteral (double value)
	{
		this.value = value;
	}
	@Override
	public Expression evaluate(Context c)
	{
		return this;
	}
	
	public double value()
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
	public int compare(Comparable c)
	{
		if(((Object)c).getClass().getSimpleName().equals("IntegerLiteral")) { 
			
			return (value - ((IntegerLiteral) c).value) > 0? 1: -1;
			
		}
		else {
			
			return (value - ((FloatingPointLiteral) c).value) > 0? 1: -1;
			
		} 
	}
	
	
	@Override
	public boolean equal(Equatable e)
	{
		if(((Object)e).getClass().getSimpleName().equals("IntegerLiteral")) { 
			
			return value == ((IntegerLiteral) e).value; 
			
		}
		else {
			
			return value == ((FloatingPointLiteral) e).value; 
			
		}
	}

}
