package statementparser;

import supportingpackages.Context;

import java.util.ArrayList;
import java.util.List;

import expression.Expression;

public class PrintStatement extends Statement {
	List<Expression> expr; 
	
	public PrintStatement(List<Expression> e) {
		this.expr = e;
	}

	@Override
	public void execute(Context c) { 
		
		List<Expression> outputList = new ArrayList<Expression>(); 
		
		for (Expression ex : expr) 
		{ 
			
			outputList.add(ex.evaluate(c));
			System.out.print(ex.evaluate(c)); 
		} 
		
		

		//String outputString = String.join("  ", outputList);  
		//System.out.println(outputString);   
		
		
		if(next != null)
			next.execute(c);
		return;		
	}
	public String toString()
	{
		String a = "print " + "(" + expr + ");\n";
		if(next != null)
			a+=next;
		return a;
	}

}
