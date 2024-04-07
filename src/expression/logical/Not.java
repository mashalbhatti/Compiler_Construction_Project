package expression.logical;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;

public class Not extends Unary{
	public Not(Expression p)
	{
		param = p;
	}
	
	public Expression evaluate(Context c) {

		BooleanLiteral l = (BooleanLiteral)param.evaluate(c);
		
		return new BooleanLiteral(!l.value);
	}


	public String toString()
	{
		return "!(" + param +")";
	} 

}
