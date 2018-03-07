
public class ExpressionTreesTest {

	/**
	 * 
	 * main method - tests out the program by calling other methods
	 * @param args - program arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//create local fields
		ArrayList<String> fileNames;
		Scanner keyboard = new Scanner(System.in);
		
		//get names of files to be extracted
		if (args.length != 0 && args[0] != null)
			fileNames = getFileNames(args[0]);
		else {
			System.out.println(PROMPT);
			fileNames = getFileNames(keyboard.nextLine());
		}
		
		//Create print writer and print results to file
		PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_TXT));
		for (String f : fileNames) {
			out.println(knapsackResult(f));
		} 

		//end
		out.close();
		System.out.println(DONE);
		
	}
	
}
