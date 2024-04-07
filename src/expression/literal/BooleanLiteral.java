package expression.literal;

import supportingpackages.Context;
import expression.Expression;

public class BooleanLiteral extends Equatable{
	
	public boolean value;
	public BooleanLiteral next;
	public BooleanLiteral(boolean value)
	{
		this.value = value;
	}
	
	@Override
	public Expression evaluate(Context c)
	{
		return this;
	}
	
	public boolean value()
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
	public boolean equal(Equatable e) {
		return value == ((BooleanLiteral)e).value;
	}
}
