package expression.relational;

import supportingpackages.Context;
import expression.*;
import expression.literal.*;
import expression.literal.Comparable;

public class GreaterEqual extends Binary {
	public GreaterEqual(Expression l, Expression r) {
		super(l, r);
	}

	@Override
	public Expression evaluate(Context c) {
		Comparable l = (Comparable)left.evaluate(c);
		Comparable r = (Comparable)right.evaluate(c);
	
		return new BooleanLiteral(l.compare(r) >= 0);
	}

	public String toString()
	{
		return "("+left + "||" + right+")";
	}
}
