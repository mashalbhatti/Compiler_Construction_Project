package supportingpackages;

import statementparser.*;
import expression.literal.*;
public class SupportContext extends Context {
	public SupportContext()
	{
		super();
		
		//ADD PRINTLN
		Identifier i = new Identifier("println");
		Identifier p =  new Identifier("literal");
		FormalParameter fp = new FormalParameter("string",p);
		Statement s = new Statement() {

			@Override
			public void execute(Context c) {
				Literal l = c.valueString(p);
				System.out.print(l+ "\n");
			}
				
		};
		
		this.addProcedure(new ProcedureDeclaration("void", i, fp, s));
		
	}
}
