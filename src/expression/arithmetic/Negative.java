package expression.arithmetic;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;
public class Negative extends Unary {
	
	public Negative(Expression p)
	{
		param = p;
	}
	@Override
	public Expression evaluate(Context c) {

		if(((Object)param.evaluate(c)).getClass().getSimpleName().equals("IntegerLiteral")) {
		
			IntegerLiteral l = (IntegerLiteral)param.evaluate(c);
			
			return new IntegerLiteral(-l.value); 
		} 
		else {
			FloatingPointLiteral l = (FloatingPointLiteral)param.evaluate(c);
			
			return new FloatingPointLiteral(-l.value); 	
		}
	}
	
	public String toString()
	{
		return "-(" + param +")";
	} 
	

}

