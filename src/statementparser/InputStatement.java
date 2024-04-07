package statementparser;

import java.util.List;
import java.util.Scanner;

import expression.literal.BooleanLiteral;
import expression.literal.FloatingPointLiteral;
import expression.literal.IntegerLiteral;
import expression.literal.StringLiteral;
import supportingpackages.Context;

public class InputStatement extends Statement{
	public String type;
	public Identifier id;
	public String msg;
	
	public InputStatement(String ty, Identifier i, StringLiteral m)
	{
		this.id = i;
		this.type = ty;
		this.msg = m.value();
	}
	
	@SuppressWarnings("resource")
	@Override
	public void execute(Context c) {
		
		if(type.equals("integer")) 
		{
			Scanner myObj = new Scanner(System.in);
			System.out.print(msg);
			int varName = myObj.nextInt();	
			new Declaration(type, id, new IntegerLiteral(varName)).execute(c);
		}
		else if(type.equals("string")) {
			Scanner myObj = new Scanner(System.in);
			System.out.print(msg + ":");
			String varName = myObj.nextLine();	
			new Declaration(type, id, new StringLiteral(varName)).execute(c);
		}
		else if(type.equals("float")) {
			Scanner myObj = new Scanner(System.in);
			System.out.print(msg + ":");
			double varName = myObj.nextDouble();	
			new Declaration(type, id, new FloatingPointLiteral(varName)).execute(c);
		}
		else if(type.equals("boolean")) {
			Scanner myObj = new Scanner(System.in);
			System.out.print(msg + ":");
			boolean varName = myObj.nextBoolean();	
			new Declaration(type, id, new BooleanLiteral(varName)).execute(c);
		}
		
		if(next!=null)
			next.execute(c);
		
	}
	
	public String toString()
	{
		String a = type + id + "= input(" +msg+");/n"; 
		if(next!=null)
			a+=next;
		return a;
	}
	

}
