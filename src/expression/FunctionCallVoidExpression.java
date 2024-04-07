package expression;

import expression.literal.BooleanLiteral;
import expression.literal.FloatingPointLiteral;
import expression.literal.IntegerLiteral;
import expression.literal.StringLiteral;
import statementparser.*;
import supportingpackages.Context;

public class FunctionCallVoidExpression extends Expression implements FunctionCall {
	public  Identifier id;
	public  ActualParameter parameters;
	public  Expression returnValue;
	
	public FunctionCallVoidExpression(Identifier i, ActualParameter p)
	{
		this.id = i;
		this.parameters = p;
	}

	@Override
	public Expression evaluate(Context c) {
		// TODO Auto-generated method stub
		FunctionDeclaration fc = c.getFunction(id);
		if(fc == null)
		{
			try {
				throw new Exception("Function declaration not found: " + id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Context functionContext = new Context(c);
		FormalParameter fp = fc.pt;
		ActualParameter ap = parameters;
		while (fp != null )
		{
			if(fp.type == "integer")
			{
				functionContext.addNewInteger(fp.i, (IntegerLiteral)ap.expr.evaluate(c));
			}
			else if(fp.type == "string")
			{
				functionContext.addNewString(fp.i, (StringLiteral)ap.expr.evaluate(c));
			}
			else if(fp.type == "float")
			{
				functionContext.addNewFloat(fp.i, (FloatingPointLiteral)ap.expr.evaluate(c));
			} else if(fp.type == "boolean")
			{
				functionContext.addNewBoolean(fp.i, (BooleanLiteral)ap.expr.evaluate(c));
			}
			
			fp=fp.next;
			ap=ap.next;
		}
		Context.callStack.push(this);
		fc.st.execute(functionContext);
		Context.callStack.pop();
		return returnValue;
	}
	
	@Override
	public void setReturnValue(Expression l) {
		// TODO Auto-generated method stub
		returnValue = l;
	}

}
