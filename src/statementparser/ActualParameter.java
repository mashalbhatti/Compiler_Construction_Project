package statementparser;

import expression.Expression;

public class ActualParameter {
	public Expression expr;
	public ActualParameter next;
	
	public ActualParameter(Expression e)
	{
		this.expr = e;
	}
	
	public String toString()
	{
		String a = ""+expr;
		if(next != null)
			a+="," + next;
		return a;
	}
}
