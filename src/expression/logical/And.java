package expression.logical;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;

public class And extends Binary{
	public And(Expression l, Expression r) {
		super(l, r);
	}

	@Override
	public Expression evaluate(Context c) {
		
		BooleanLiteral l = (BooleanLiteral)left.evaluate(c);
		BooleanLiteral r = (BooleanLiteral)right.evaluate(c);
	
		return new BooleanLiteral(l.value && r.value );
	}

	public String toString()
	{
		return "("+left + "&&" + right+")";
	}
}
