package test;

import statementparser.Statement;
import statements.statements;
import supportingpackages.Context;
import statements.ParseException;
import supportingpackages.SupportContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainTest {
	public static void main(String[] args) throws Exception
	{		
		runFile("/src/test/test.rm");
	} 
	
	public static void runFile(String path) throws FileNotFoundException, ParseException
	{
		String filePath = new File("").getAbsolutePath();
		//System.out.println(filePath);
		statements rmParser;
		rmParser = new statements(new FileReader(filePath+path));
		Statement stat = rmParser.Start();
		//System.out.println(stat);
		stat.execute(new Context());
		
	};
}
