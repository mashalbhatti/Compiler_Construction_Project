package statementparser;

import supportingpackages.Context;


public class Return extends Statement{
	private Identifier id;
	public Return (Identifier i)
	{
		this.id = i;
	}
	
	@Override
	public void execute(Context c)
	{
		
		String type = c.checkIdentifier(id);
		//System.out.println(type);
		if(type.equals("integer"))
		{
			FunctionCallInteger fi =  Context.callStackInteger.peek();
			fi.setReturnValue(c.valueInteger(id));
		}
		else if(type.equals("string"))
		{
			FunctionCallString fs= Context.callStackString.peek();
			fs.setReturnValue( c.valueString(id));
		}
		else if(type.equals("float"))
		{
			FunctionCallFloat ff = Context.callStackFloat.peek();
			ff.setReturnValue(c.valueFloatingPoint(id));
		}
		else if(type.equals("boolean"))
		{
			FunctionCallBoolean fb= Context.callStackBoolean.peek();
			fb.setReturnValue(c.valueBoolean(id));
		} 
		
		return;
	}
	
	public String toString()
	{
		String a = ""+"return " + id +";\n";
		if(next!=null)
			a+=next;
		
		return a;
	}

}
