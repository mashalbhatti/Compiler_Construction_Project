package statementparser;

import supportingpackages.Context;
import expression.Expression;
import expression.literal.BooleanLiteral;

public class WhileExpression extends Statement {
	Expression condition;
	Statement statement;
	
	public WhileExpression(Expression condition, Statement statement)
	{
		this.condition = condition;
		this.statement = statement;
	}
	
	@Override
	public void execute(Context c)
	{
		while (((BooleanLiteral)condition.evaluate(c)).value() )
		{
			//Context localContext = new Context(c);
			statement.execute(c);
		}
		
		if(next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = "while" + "(" + condition + ")\n{\n" + statement + "\n}\n";
		if(next != null)
			a += next;
		return a;
	}
}
