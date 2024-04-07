package statementparser;

public class FormalParameter {
	public Identifier i;
	public String type;
	public FormalParameter next;
	
	public FormalParameter(String t, Identifier i)
	{
		this.type = t;
		this.i=i;
	}
	
	public String toString()
	{
		String a = ""+type + i;
		if(next != null)
			a+=","+next;
		
		return a;
	}
}
