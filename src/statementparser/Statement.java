package statementparser;

import supportingpackages.Context;

public abstract class Statement extends ASTNode {
	public Statement next;
	
	public abstract void execute( Context c);
	
}
