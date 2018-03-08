import java.io.IOException;

public class ExpressionTreesTest {

	/**
	 * 
	 * main method - tests out the program by calling other methods
	 * @param args - program arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
		String[] postFix = {"2", "3", "+", "4", "*"};
		ExpressionTrees e = new ExpressionTrees();
		TreeNode t = e.buildTree(postFix);
		System.out.println(e.toInfixNotation(t));
		
	}
	
}
