package expression;

import expression.literal.BooleanLiteral;
import expression.literal.FloatingPointLiteral;
import expression.literal.IntegerLiteral;
import expression.literal.StringLiteral;
import statementparser.*;
import supportingpackages.Context;

public class FunctionCallStringExpression extends Expression implements FunctionCallString{
	public StringLiteral returnValue;
	public Identifier id;
	public ActualParameter parameters;
	
	public FunctionCallStringExpression(Identifier i, ActualParameter p)
	{
		this.id = i;
		this.parameters = p;
	}
	@Override
	public StringLiteral evaluate(Context c)
	{
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
			if(fp.type.equals("integer"))
			{
				functionContext.addNewInteger(fp.i, (IntegerLiteral)ap.expr.evaluate(c));
			}
			else if(fp.type.equals("string"))
			{
				functionContext.addNewString(fp.i, (StringLiteral)ap.expr.evaluate(c));
			}
			else if(fp.type.equals("float"))
			{
				functionContext.addNewFloat(fp.i, (FloatingPointLiteral)ap.expr.evaluate(c));
			} else if(fp.type.equals("boolean"))
			{
				functionContext.addNewBoolean(fp.i, (BooleanLiteral)ap.expr.evaluate(c));
			}
			
			fp=fp.next;
			ap=ap.next;
		}
		
		Context.callStackString.push(this);
		fc.st.execute(functionContext);
		fc.r.execute(functionContext);
		Context.callStackString.pop();
		return returnValue;
		
	}

	@Override
	public void setReturnValue(StringLiteral a) {
		// TODO Auto-generated method stub
		returnValue = a;
		
	}

}
