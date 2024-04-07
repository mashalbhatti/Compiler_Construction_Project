package statementparser;

import supportingpackages.Context;

public class FunctionDeclaration extends Statement {
	
	public Identifier id;
	public FormalParameter pt;
	public Statement st;
	public String type;
	public Return r;
	
	public FunctionDeclaration(String type, Identifier id, FormalParameter p, Statement s, Return r)
	{
		this.type = type;
		this.id = id;
		this.pt = p;
		this.st= s;
		this.r=r;
	}
	
	@Override
	public void execute(Context c) {
		
		c.addFunction(this);
		
		if(next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = type + "function" + id + "(" + pt + ") {\n" +st + "\n" +r +"\n}\n";
		
		if(next != null)
			a+=next;
		return a;
	}
}
