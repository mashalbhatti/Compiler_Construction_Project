package expression.logical;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;

public class Xor extends Binary{
	public Xor(Expression l, Expression r) {
		super(l, r);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression evaluate(Context c) {
		
		BooleanLiteral l = (BooleanLiteral)left.evaluate(c);
		BooleanLiteral r = (BooleanLiteral)right.evaluate(c);
	
		return new BooleanLiteral(l.value == true ^ r.value == true);
	}

	public String toString()
	{
		return "("+left + "^" + right+")";
	}
}
