package statementparser;

import supportingpackages.Context;

public class ProcedureDeclaration extends Statement{
	public Identifier id;
	public FormalParameter pt;
	public Statement st;
	public String type;
	public ProcedureDeclaration(String type, Identifier id, FormalParameter p, Statement s)
	{
		this.type = type;
		this.id = id;
		this.pt = p;
		this.st= s;
	}
	@Override
	public void execute(Context c) {
		
		c.addProcedure(this);
		
		if(next != null)
			next.execute(c);
	}
	
	public String toString()
	{
		String a = type + "function" + id + "(" + pt + ") {\n" +st +"\n}\n";
		
		if(next != null)
			a+=next;
		return a;
	}

}
