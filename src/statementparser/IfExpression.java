package statementparser;

import supportingpackages.Context;
import expression.Expression;
import expression.literal.BooleanLiteral;

public class IfExpression extends Statement{
	public Expression condition;
	public Statement thenStatement;
	public Statement elseStatement;
	
	public IfExpression(Expression condition, Statement thenStatement, Statement elseStatement)
	{
		this.condition = condition;
		this.thenStatement = thenStatement;
		this.elseStatement = elseStatement;
	}
	
	
	public void execute(Context c) {
		Expression e = condition.evaluate(c);
		
		BooleanLiteral i = (BooleanLiteral) e;
		//Context localContext;
		if(i.value)
		{
			//localContext = new Context(c);
			thenStatement.execute(c);
		} else
		{
			//localContext = new Context(c);
			elseStatement.execute(c);
		}
		if(next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = "If" + "(" + condition + ")\n" + thenStatement + "else\n" + elseStatement;
		if(next != null)
			a+=next;
		return a;
		
	}
	
	
}
