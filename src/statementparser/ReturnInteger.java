package statementparser;

import expression.Expression;
import expression.literal.IntegerLiteral;
import supportingpackages.Context;

public class ReturnInteger extends Statement{
	private Expression e;
	public ReturnInteger (Expression i)
	{
		this.e = i;
	}
	
	@Override
	public void execute(Context c)
	{
		
		FunctionCallInteger f = Context.callStackInteger.peek();
		f.setReturnValue((IntegerLiteral)e.evaluate(c));
		
		return;
	}
	
	public String toString()
	{
		String a = ""+"return " + e +";\n";
		if(next!=null)
			a+=next;
		
		return a;
	}
}
