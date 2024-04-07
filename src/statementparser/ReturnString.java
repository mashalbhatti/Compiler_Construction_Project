package statementparser;

import expression.Expression;
import expression.literal.StringLiteral;
import supportingpackages.Context;

public class ReturnString extends Statement {
	private Expression e;
	public ReturnString (Expression i)
	{
		this.e = i;
	}
	
	@Override
	public void execute(Context c)
	{
		
		FunctionCallString f = Context.callStackString.peek();
		f.setReturnValue((StringLiteral)e.evaluate(c));
		
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
