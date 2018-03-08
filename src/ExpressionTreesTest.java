import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionTreesTest {

	private static final String DONE = "Done.";
	private static final String OUTPUT_TXT = "myAnswers.txt";
	private static final String DEFAULT_INPUT = "postFixExpressions.txt";
	private static final String PROMPT = "Please input a filename";
	private static final String ERROR = "File not found";

	public static String[][] readFile(String filename) throws IOException {
		
		String[][] postFix;
		String[] lines = null;
		BufferedReader inputReader = null;
	    try {
	    	inputReader = new BufferedReader(new FileReader(filename), 1024);
	    }
	    catch (FileNotFoundException e) {
	    	System.out.println(ERROR);
	    	System.exit(0);
	    }
	    
	    String line;
	    int i = 0;
	    while ((line = inputReader.readLine()) != null) {
	    	lines[i] = (line.trim());
	    	i++;
	    }
	    for (int j = 0; j < lines.length; j++) {
	    	postFix
	    }
	    	
		
	}
	
	public static String runTests(String[] arr) {
		
	}
	
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
		
		
		BufferedReader inputReader = null;
		Scanner keyboard = new Scanner(System.in);
		String filename = "";
		String[][] postFix;
		if ((args.length != 0 && args[0] != null) && (new File(args[0]).exists())) {
			postFix = readFile(args[0]);
		}
		else if ((new File(DEFAULT_INPUT).exists()))
			postFix = readFile(DEFAULT_INPUT);
		else {
			System.out.println(PROMPT);
			postFix = readFile(keyboard.nextLine());
		}
		
	
		ArrayList<String> result = new ArrayList<String>();
		for (String[] s : postFix)
			result.add(runTests(s));
		writeFile(result);
		
		
		
	}
	
}
