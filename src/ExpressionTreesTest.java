import java.io.*;
import java.util.ArrayList;

public class ExpressionTreesTest {

	private static final String DONE = "Done.";
	private static final String OUTPUT_TXT = "myAnswers.txt";
	private static final char[] ERROR = null;

	public static String[][] readFile(String filename) {
		
		
		
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
		
		String filename;
		if (args.length != 0 && args[0] != null)
			filename = args[0];
		else {
			System.out.println(PROMPT);
			fileNames = getFileNames(keyboard.nextLine());
		}
		
	    try {
	    	inputReader = new BufferedReader(new FileReader(filename), 1024);
	    }
	    catch (FileNotFoundException e) {
			try {
				inputReader = new BufferedReader(new FileReader("urmom"), 1024);
				
			}
			catch {
				
			}
	    }
		
		
		ArrayList<String> result = new ArrayList<String>();
		for (String[] s : postFix)
			result.add(runTests(s));
		writeFile(result);
		
		
		
	}
	
}
