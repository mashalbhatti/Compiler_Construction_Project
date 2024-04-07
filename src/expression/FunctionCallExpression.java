package expression;

import supportingpackages.Context;
import expression.literal.*;
import statementparser.*;

public class FunctionCallExpression extends Expression{
	public Identifier id;
	public ActualParameter parameters;
	public Literal e;
	
	public FunctionCallExpression (Identifier i, ActualParameter p)
	{
		this.id = i;
		this.parameters = p;
	}
	
	@Override
	public Literal evaluate(Context c)
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
		
		//int i =10;
		//if(fc.type.equals("int"))
		//	System.out.println(fc.type);
			
		if(fc.type.equals("integer"))
		{
			FunctionCallIntegerExpression fi = new FunctionCallIntegerExpression(id, parameters);
			e = fi.evaluate(c);
		} else if(fc.type.equals("string")) {
			FunctionCallStringExpression fs = new FunctionCallStringExpression(id, parameters);
			e = fs.evaluate(c);
		} else if(fc.type.equals("float")) {
			FunctionCallFloatExpression ff = new FunctionCallFloatExpression(id, parameters);
			e = ff.evaluate(c);
		} else if(fc.type.equals("boolean")) {
			FunctionCallBooleanExpression fb = new FunctionCallBooleanExpression(id, parameters);
			e= fb.evaluate(c);
		} /*else if(fc.type == "void") {
			FunctionCallVoidExpression fv = new FunctionCallVoidExpression(id, parameters);
			e = fv.evaluate(c);
		} */
		return e;
		
	}
	
	public String toString()
	{
		return ""+id + "(" + parameters + ")";
	}
	
}
