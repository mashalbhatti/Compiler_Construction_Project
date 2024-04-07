package expression.relational;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;
public class NotEqual extends Binary {
	public NotEqual(Expression l, Expression r) {
		super(l, r);
	}

	@Override
	public Expression evaluate(Context c) {
		Equatable l = (Equatable)left.evaluate(c);
		Equatable r = (Equatable)right.evaluate(c);
	
		return new BooleanLiteral(!l.equal(r));
	}

	public String toString()
	{
		return "("+left + "!=" + right+")";
	} 
}
