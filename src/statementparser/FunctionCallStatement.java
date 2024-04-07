package statementparser;

import supportingpackages.Context;
import expression.Expression;
import expression.literal.BooleanLiteral;
import expression.literal.FloatingPointLiteral;
import expression.literal.IntegerLiteral;
import expression.literal.StringLiteral;

public class FunctionCallStatement extends Statement implements FunctionCall{
	public Identifier id;
	public ActualParameter parameters;
	public FunctionCallStatement(Identifier i, ActualParameter p)
	{
		this.id = i;
		this.parameters = p;
	}
	
	public String toString()
	{
		return id + "(" +parameters+ ")\n";
	}
	@Override
	public void execute(Context c)
	{
		ProcedureDeclaration fc = c.getProcedure(id);
		if(fc == null)
		{
			try {
				throw new Exception("Procedure declaration not found: " + id);
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
		Context.callStack.push(this);
		fc.st.execute(functionContext);
		Context.callStack.pop();
		if(next != null)
			next.execute(c);
	}
	
	@Override
	public void setReturnValue(Expression l) {
		//no return value procedures
	}
}
