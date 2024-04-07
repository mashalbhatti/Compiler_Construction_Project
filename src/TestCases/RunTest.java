package TestCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import statementparser.Statement;
import statements.ParseException;
import statements.statements;
import supportingpackages.Context;

public class RunTest {  
	public void runFile(String path) throws FileNotFoundException, ParseException
	{
		String filePath = new File("").getAbsolutePath();
		statements rmParser;
		rmParser = new statements(new FileReader(filePath+path));
		Statement stat = rmParser.Start();
		stat.execute(new Context());
		
	};
}
