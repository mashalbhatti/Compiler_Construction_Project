package expression;

import statementparser.ASTNode;
import supportingpackages.Context;

public abstract class Expression extends ASTNode {
	
	public abstract Expression evaluate(Context c);
}
