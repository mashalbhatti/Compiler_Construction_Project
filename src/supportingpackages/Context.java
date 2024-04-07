package supportingpackages;

import expression.literal.*;
import statementparser.FunctionCall;
import statementparser.FunctionDeclaration;
import statementparser.Identifier;
import statementparser.*;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;




public class Context {
	
	HashMap<Identifier, IntegerLiteral> dataInteger = new HashMap<>();
	HashMap<Identifier, StringLiteral> dataString = new HashMap<>();
	HashMap<Identifier, FloatingPointLiteral> dataFloat = new HashMap<>();
	HashMap<Identifier, BooleanLiteral> dataBoolean = new HashMap<>();
	HashMap<Identifier, FunctionDeclaration> functions = new HashMap<>();
	HashMap<Identifier, ProcedureDeclaration> procedures = new HashMap<>();
	
	public static Stack<FunctionCall> callStack = new Stack<>();
	public static Stack<FunctionCallInteger> callStackInteger = new Stack<>();
	public static Stack<FunctionCallString> callStackString = new Stack<>();
	public static Stack<FunctionCallFloat> callStackFloat = new Stack<>();
	public static Stack<FunctionCallBoolean> callStackBoolean = new Stack<>();
	
	
	HashMap<Identifier, List<IntegerLiteral>> arrayInteger = new HashMap<>();
	HashMap<Identifier, List<StringLiteral>> arrayString = new HashMap<>();
	HashMap<Identifier, List<FloatingPointLiteral>> arrayFloat = new HashMap<>();
	HashMap<Identifier, List<BooleanLiteral>> arrayBoolean = new HashMap<>(); 
	
	
	
	Context parent;
	
	public String checkIdentifier(Identifier id)
	{
		
		if(dataInteger.containsKey(id)) {
			return "integer";
		}else if (dataString.containsKey(id))
			return "string";
		else if(dataFloat.containsKey(id))
			return "float";
		else if(dataBoolean.containsKey(id))
			return "boolean"; 
		

		else if (arrayInteger.containsKey(id))
			return "integerArray";
		else if(arrayString.containsKey(id))
			return "stringArray";
		else if(arrayFloat.containsKey(id))
			return "floatArray"; 
		else if(arrayBoolean.containsKey(id))
			return "booleanArray";  
		
		else
			return "No identifier found error";
		
	}
	
	//String
 
	public StringLiteral valueString(Identifier id)
	{
		if(parent == null)
			return dataString.get(id);
		
		if(dataString.containsKey(id))
			return dataString.get(id);
		
		return parent.valueString(id);
	}
	
	public void addNewString(Identifier i, StringLiteral l)
	{
//		if(dataString.containsKey(i))
//		{
//			return; 
//		}
		
		dataString.put(i, l);
	}
	
	public void assignString(Identifier i, StringLiteral l)
	{
		if(dataString.containsKey(i))
		{
			dataString.put(i, l);
			return;
		}
		
		if(parent != null)
		{
			parent.assignString(i, l);
			return;
		}
		
		return;
	}
	
	public void setStringArray(Identifier i, List<StringLiteral> l)
	{
//		if(dataString.containsKey(i))
//		{
//			return; 
//		}
		
		arrayString.put(i, l);
	}  
	
	
	public StringLiteral getStringArray(Identifier id)
	{
		if(parent == null)
			return new StringLiteral(arrayString.get(id).toString());
		
		if(dataString.containsKey(id))
			return new StringLiteral(arrayString.get(id).toString());
		
		return parent.getStringArray(id);
	}  
	
	//Integer
	
	public IntegerLiteral valueInteger(Identifier id)
	{
	
		if(parent == null)
			return dataInteger.get(id);
		
		if(dataInteger.containsKey(id))
			return dataInteger.get(id);
		
		return parent.valueInteger(id);
	}
	
	public void addNewInteger(Identifier i, IntegerLiteral l)
	{
		
//		if(dataInteger.containsKey(i))
//		{
//			return; 
//		}
		dataInteger.put(i, l);
	}
	
	public void assignInteger(Identifier i, IntegerLiteral l)
	{
		if(dataInteger.containsKey(i))
		{
			dataInteger.put(i, l);
			return;
		}
		
		if(parent != null)
		{
			parent.assignInteger(i, l);
			return;
		}
		
		return;
	}
	
	
	public void setIntegerArray(Identifier i, List<IntegerLiteral> l)
	{
//		if(dataInteger.containsKey(i))
//		{
//			return; 
//		}
		
		arrayInteger.put(i, l); 
	} 
	
	public StringLiteral getIntegerArray(Identifier id)
	{
		if(parent == null)
			return new StringLiteral(arrayInteger.get(id).toString());
		
		if(dataString.containsKey(id))
			return new StringLiteral(arrayInteger.get(id).toString());
		
		return parent.getIntegerArray(id);
	}   
	
	//Float
	public FloatingPointLiteral valueFloatingPoint(Identifier id)
	{ 
		
		if(parent == null)
			return dataFloat.get(id);
		
		if(dataFloat.containsKey(id)) 
			return dataFloat.get(id);
		
		
		return parent.valueFloatingPoint(id);
	}
	
	//public HashMap<Identifier, FloatingPointLiteral> addNewFloat(Identifier i, FloatingPointLiteral l)
	public void addNewFloat(Identifier i, FloatingPointLiteral l)
	{
//		if(dataFloat.containsKey(i))
//		{
//			//return dataFloat; 
//			return; 
//		}

		dataFloat.put(i, l); 
		
		return;
	}
	
	public void assignFloat(Identifier i, FloatingPointLiteral l)
	{
		if(dataFloat.containsKey(i))
		{
			dataFloat.put(i, l);
			return;
		}
		
		if(parent != null)
		{
			parent.assignFloat(i, l);
			return;
		}
		
		return;
	}
	
	
	public void setFloatArray(Identifier i, List<FloatingPointLiteral> l)
	{
//		if(dataFloat.containsKey(i))
//		{
//			return; 
//		}
		arrayFloat.put(i, l); 

		return;
	}
	
	public StringLiteral getFloatArray(Identifier id)
	{
		if(parent == null)
			return new StringLiteral(arrayFloat.get(id).toString());
		
		if(dataString.containsKey(id))
			return new StringLiteral(arrayFloat.get(id).toString());
		
		return parent.getFloatArray(id);
	}    
	
	//Boolean
	
	public BooleanLiteral valueBoolean(Identifier id)
	{
		if(parent == null)
			return dataBoolean.get(id);
		
		if(dataBoolean.containsKey(id))
			return dataBoolean.get(id);
		
		return parent.valueBoolean(id);
	}
	
	public void addNewBoolean(Identifier i, BooleanLiteral l)
	{
//		if(dataBoolean.containsKey(i))
//		{
//			return; 
//		}
		
		dataBoolean.put(i, l);
	}
	
	public void assignBoolean(Identifier i, BooleanLiteral l)
	{
		if(dataBoolean.containsKey(i))
		{
			dataBoolean.put(i, l);
			return;
		}
		
		if(parent != null)
		{
			parent.assignBoolean(i, l);
			return;
		}
		
		return;
	}
	
	
	public void setBooleanArray(Identifier i, List<BooleanLiteral> l)
	{
//		if(dataBoolean.containsKey(i))
//		{
//			return; 
//		}
//		
		arrayBoolean.put(i, l);
	} 
	
	public StringLiteral getBooleanArray(Identifier id)
	{
		if(parent == null)
			return new StringLiteral(arrayBoolean.get(id).toString());
		
		if(dataString.containsKey(id))
			return new StringLiteral(arrayBoolean.get(id).toString());
		
		return parent.getBooleanArray(id);
	}    
	
	
	
	public Context() {
		
	}
	public Context(Context parent)
	{
		this.parent = parent;
	}
	
	public void addFunction(FunctionDeclaration functionDeclaration)
	{
		if(functions.containsKey(functionDeclaration.id))
		{
			return;
		}
		functions.put(functionDeclaration.id, functionDeclaration);
		
	}
	
	public FunctionDeclaration getFunction(Identifier identifier) {
		if(parent == null)
			return functions.get(identifier);
		if(functions.containsKey(identifier))
			return functions.get(identifier);
		return parent.getFunction(identifier);
	}
//Procedures
	public void addProcedure(ProcedureDeclaration procedureDeclaration)
	{
		if(procedures.containsKey(procedureDeclaration.id))
		{
			return;
		}
		procedures.put(procedureDeclaration.id, procedureDeclaration);
		
	}
	
	public ProcedureDeclaration getProcedure(Identifier identifier) {
		if(parent == null)
			return procedures.get(identifier);
		if(procedures.containsKey(identifier))
			return procedures.get(identifier);
		return parent.getProcedure(identifier);
	}
}
