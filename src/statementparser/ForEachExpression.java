package statementparser;

import expression.literal.*;
import supportingpackages.Context;
import expression.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import expression.Expression;

public class ForEachExpression extends Statement{

	Statement statement; 
	Identifier variablename; 
	Identifier arrayname; 
	String type;
	
	public ForEachExpression(String t, Identifier vname, Identifier aname, Statement statement)
	{
		this.statement = statement; 
		this.variablename = vname; 
		this.arrayname = aname; 
		this.type = t;
	}

//	public <T> List<T> parseStringToArray(String s) { 
//		  List<T> output = new ArrayList<T>(); 
//		  String listString = s.substring(1, s.length() - 1); 
//		  StringTokenizer st = new StringTokenizer(listString, ","); 
//		  while(st.hasMoreTokens()) {			  
//			  output.add((T) st.nextToken().trim());
//	        }
//		  return output;
//		} 	
	
	
	@Override
	public void execute(Context c) { 
		
		Expression e = new Variable(arrayname); 
		 
		if(type.equals("integer")) { 
			List<Integer> output = new ArrayList<Integer>(); 
			String s = e.evaluate(c).toString(); 
			String listString = s.substring(1, s.length() - 1); 
			StringTokenizer st = new StringTokenizer(listString, ","); 
			  while(st.hasMoreTokens()) {			  
				  output.add(Integer.parseInt(st.nextToken().trim()));
		        } 
			  
			for (int element : output) { 
				new Declaration(type, variablename, new IntegerLiteral(element)).execute(c); 
				//new Assignment(variablename, new IntegerLiteral(element)).execute(c);; 
				statement.execute(c); 

				
			} 
			//element = new Integer(0); 
		} else if(type.equals("string")){ 
			List<String> output = new ArrayList<String>(); 
			String s = e.evaluate(c).toString(); 
			String listString = s.substring(1, s.length() - 1); 
			StringTokenizer st = new StringTokenizer(listString, ","); 
			  while(st.hasMoreTokens()) {			  
				  output.add(st.nextToken().trim());
		        } 
			for (String element : output) {
				//Assignment a = new Assignment(variablename, new StringLiteral(element));
				new Declaration(type, variablename, new StringLiteral(element)).execute(c); 
				statement.execute(c); 
				
			}
			//element = new String(); 
		} else if(type.equals("float")){ 
			List<Double> output = new ArrayList<Double>(); 
			String s = e.evaluate(c).toString(); 
			String listString = s.substring(1, s.length() - 1); 
			StringTokenizer st = new StringTokenizer(listString, ","); 
			  while(st.hasMoreTokens()) {			  
				  output.add(Double.parseDouble(st.nextToken().trim()));
		        }  
			for (double element : output) {
				//Assignment a = new Assignment(variablename, new FloatingPointLiteral(element)); 
				new Declaration(type, variablename, new FloatingPointLiteral(element)).execute(c);  
				statement.execute(c); 
				
			}
			//element = new Float(0); 
		} else if(type.equals("boolean")){
			List<Boolean> output = new ArrayList<Boolean>(); 
			String s = e.evaluate(c).toString(); 
			String listString = s.substring(1, s.length() - 1); 
			StringTokenizer st = new StringTokenizer(listString, ","); 
			  while(st.hasMoreTokens()) {			  
				  output.add(Boolean.parseBoolean(st.nextToken().trim()));
		        }  
			for (boolean element : output) {
				//Assignment a = new Assignment(variablename, new BooleanLiteral(element)); 
				new Declaration(type, variablename, new BooleanLiteral(element)).execute(c); 
				statement.execute(c); 
				
			}
			//element = new Boolean(true); 
		}
		else { 
			throw new IllegalArgumentException("Type cannot be identified!"); 
		}
		
		
		if(next != null)
			next.execute(c); 
	}
	
	
	public String toString()
	{
		String a = "foreach" + "(" + variablename + " in "+ arrayname +")\n{\n" + statement + "\n}\n";
		if(next != null)
			a += next;
		return a;
	} 

}