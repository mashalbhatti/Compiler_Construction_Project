package expression.arithmetic;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;

public class Power extends Binary{
	public Power(Expression l, Expression r) {
		super(l, r);
	}

	@Override
	public Expression evaluate(Context c) { 
		
		if(((Object)left.evaluate(c)).getClass().getSimpleName().equals("IntegerLiteral")
				&& ((Object)right.evaluate(c)).getClass().getSimpleName().equals("IntegerLiteral")) { 
			
			IntegerLiteral l = (IntegerLiteral)left.evaluate(c);
			IntegerLiteral r = (IntegerLiteral)right.evaluate(c); 
			
			return new IntegerLiteral((int)Math.pow(l.value(), r.value())); 	
		}  
		
		else if (((Object)left.evaluate(c)).getClass().getSimpleName().equals("FloatingPointLiteral") 
				&& ((Object)right.evaluate(c)).getClass().getSimpleName().equals("FloatingPointLiteral")) {
		
			FloatingPointLiteral l = (FloatingPointLiteral)left.evaluate(c);
			FloatingPointLiteral r = (FloatingPointLiteral)right.evaluate(c);
			
			return new FloatingPointLiteral(Math.pow(l.value(), r.value()));  
		} 
		
		else if (((Object)left.evaluate(c)).getClass().getSimpleName().equals("FloatingPointLiteral") 
				&& ((Object)right.evaluate(c)).getClass().getSimpleName().equals("IntegerLiteral")) {
		
			FloatingPointLiteral l = (FloatingPointLiteral)left.evaluate(c);
			IntegerLiteral r = (IntegerLiteral)right.evaluate(c);
			
			return new FloatingPointLiteral(Math.pow(l.value(), r.value()));  
		}  
		
		else if (((Object)left.evaluate(c)).getClass().getSimpleName().equals("IntegerLiteral") 
				&& ((Object)right.evaluate(c)).getClass().getSimpleName().equals("FloatingPointLiteral")) {
		
			IntegerLiteral l = (IntegerLiteral)left.evaluate(c);
			FloatingPointLiteral r = (FloatingPointLiteral)right.evaluate(c);
			
			return new FloatingPointLiteral(Math.pow(l.value(), r.value()));  
		}  
		else {   

				FloatingPointLiteral l = (FloatingPointLiteral)left.evaluate(c);
				FloatingPointLiteral r = (FloatingPointLiteral)right.evaluate(c);

			return new FloatingPointLiteral(Math.pow(l.value(), r.value()));   
		} 
	}
	
	public String toString()
	{
		return "("+left + "**" + right+")";
	}
}
