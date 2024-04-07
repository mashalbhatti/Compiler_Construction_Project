package expression.literal;

import supportingpackages.Context;
import expression.Expression;

public class StringLiteral extends Comparable{
	public StringLiteral next;
	String data;
	public StringLiteral(String data)
	{
		this.data = data;
	}
	
	public String value()
	{
		return data;
	}
	
	@Override
	public int compare(Comparable c)
	{
		StringLiteral s = (StringLiteral) c;
		return this.data.compareTo(s.data);
	}
	
	@Override
	public boolean equal(Equatable e)
	{
		StringLiteral s = (StringLiteral) e;
		return this.data.equals(s.data);
	}
	
	@Override
	public Expression evaluate(Context c)
	{
		return this;
	}
	public String toString()
	{
		String a = data;
		if(next != null)
		{
			a += ","+next;
		}
		return a;
	}
}
