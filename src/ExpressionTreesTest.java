import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Will Olson (git: willolson27)
 * Date Due: March 9, 2018
 *
 */
public class ExpressionTreesTest {

	//create global string constants
	private static final String DONE = "Done.";
	private static final String OUTPUT_TXT = "myAnswers.txt";
	private static final String DEFAULT_INPUT = "postFixExpressions.txt";
	private static final String PROMPT = "Please input a filename";
	private static final String ERROR = "File not found";
	private static final String PREFIX = "Prefix:";
	private static final String INFIX = "Infix:";
	private static final String POSTFIX = "Postfix:";
	private static final String EVAL = "Tree Evaluated:";
	private static final String PFEVAL = "Postfix Evaluated:";


	/**
	 * Create a an 2D array (array of String[]s, each of which is a postfix expression) from an input file
	 * @param filename - name of file to be read in
	 * @return
	 * @throws IOException
	 */
	public static String[][] readFile(String filename) throws IOException {
		
		//create local variables
		String[][] postFix;
		String line;
		int max = 0;
		ArrayList<String> lines = new ArrayList<String>();
		
		//create an input file with the given filename
		BufferedReader inputReader = null;
	    try {
	    	inputReader = new BufferedReader(new FileReader(filename), 1024);
	    }
	    catch (FileNotFoundException e) {
	    	System.out.println(ERROR);
	    	System.exit(0);
	    }
	    
	   //read through the file and add each line to an ArrayList
	    while ((line = inputReader.readLine()) != null) {
	    	lines.add(line.trim());
	    	if (line.length() > max)
	    		max = line.length();
	    }
	    
	    //add each of the lines to the 2D array of postfix expressions
	    postFix = new String[lines.size()][max];
	    for (int j = 0; j < lines.size(); j++) {
	    	String[] arr = lines.get(j).split("\\s+");
	    	postFix[j] = arr;
	    }
	    	
	    return postFix;
	    
		
	}
	
	/**
	 * run various tests on a postfix expression 
	 * @param arr - postFix expression to be tested
	 * @return
	 */
	public static String runTests(String[] arr) {
		
		//create local variables
		String toReturn = "";
		ExpressionTree tester = new ExpressionTree(arr);
		
		//run various tests on the ExpressionTree
		toReturn += EVAL + "\t" + tester.evalTree() + "\n";
		toReturn += PREFIX + "\t" + tester.toPrefixNotation() + "\n";
		toReturn += INFIX + "\t" + tester.toInfixNotation() + "\n"; 
		toReturn += POSTFIX + "\t" +tester.toPostfixNotation()+ "\n";
		toReturn += PFEVAL + "\t" + tester.postfixEval(arr) + "\n\n";
		
		return toReturn;
		
	}
	
	/**
	 * writes the results of the tests to the output file
	 * @param arr - String arraylist of results
	 * @throws IOException
	 */
	public static void writeFile(ArrayList<String> arr) throws IOException {
		
		//Create print writer and print results to file
		PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_TXT));
		for (String s : arr)
			out.println(s);
		
		//end
		out.close();
		System.out.println(DONE);
		
	}
	
	/**
	 * 
	 * main method - tests out the program by calling other methods
	 * @param args - program arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//Create local variables
		String filename = "";
		String[][] postFix;
		ArrayList<String> result = new ArrayList<String>();
		
		
		//create a reader for reading in the input file
		BufferedReader inputReader = null;
		Scanner keyboard = new Scanner(System.in);
		
		if ((args.length != 0 && args[0] != null) && (new File(args[0]).exists())) {
			postFix = readFile(args[0]);
		}
		else if ((new File(DEFAULT_INPUT).exists()))
			postFix = readFile(DEFAULT_INPUT);
		else {
			System.out.println(PROMPT);
			postFix = readFile(keyboard.nextLine());
		}
		
	
		//traverse the array of postfix expressions run tests on them
		for (String[] s : postFix) {	
			for (String c : s)
				System.out.print(c + " ");
			System.out.println();
			result.add(runTests(s));
		}
				
		//print the results of the tests
		writeFile(result);
		
		
		
	}
	
}
