
public class ExpressionTrees extends TreeNode implements Expressions {

	private final String PLUS = "+";
	private final String MULT = "*";
	public String[] operators = {PLUS, MULT};
	
	/**
	 * constructor
	 */
	public ExpressionTrees() {
		//TODO
		super(null);
	}
	
	/**
	 * creates an expression tree given postfix 
	 * @param exp
	 */
	public TreeNode buildTree(String[] exp) { 
		//TODO
		return null;
	}
	
	/**
	 * returns the result of an expression tree
	 */
	public int evalTree(TreeNode node) {
		
		String s = (String) node.getValue();
		if (isOperator(s)) {
			if (s.equals(MULT)) 
				return (evalTree(node.getLeft()) * evalTree(node.getRight()));
			else 
				return (evalTree(node.getLeft()) + evalTree(node.getRight()));
		}
		else 
			return Integer.parseInt(s);
		
	}
	
	/**
	 * converts a tree to prefix notation
	 * @param node - root node of the tree being evaluated
	 */
	public String toPrefixNotation(TreeNode node) {

		if (isOperator(node.getValue())) {
			return ((String) node.getValue() + toPrefixNotation(node.getLeft()) + toPrefixNotation(node.getRight()));
		}
		else
			return (String) node.getValue();

	}
	
	/**
	 * converts a tree to infix notation
	 * @param node - root node of the tree being evaluated
	 */
	public String toInfixNotation(TreeNode node) {
		//TODO - no parentheses
		if (isOperator(node.getValue())) {
			return (toInfixNotation(node.getLeft()) + (String) node.getValue() + toInfixNotation(node.getRight()));
		}
		else
			return (String) node.getValue();
	}
	
	/**
	 * converts a tree to postfix notation
	 * @param node - root node of the tree being evaluated
	 */
	public String toPostfixNotation(TreeNode node) {
		
		if (isOperator(node.getValue())) {
			return (toPostfixNotation(node.getLeft()) +  toPostfixNotation(node.getRight()) + (String) node.getValue() );
		}
		else
			return (String) node.getValue();
		
	}
	
	/**
	 *evaluates a given postfix expression
	 * @param exp
	 */
	public int postfixEval(String[] exp) {
		return evalTree(buildTree(exp));
	}
	
	/**
	 * checks if a given character is an operator (in this assignment, only * and +)
	 * @param o
	 * @return
	 */
	public boolean isOperator (Object o) {
		
		return (o.equals(MULT) || o.equals(PLUS));
		
	}
	
	/**
	 * 
	 * @param s
	 */
	public static void SOP(String s) {
		System.out.println(s);
	}
	
	/**
	 * tests the program
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	@Override
	public int evalTree() {
		return evalTree(this);
	}

	@Override
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}

	@Override
	public String toInfixNotation() {
		return toInfixNotation(this);
	}

	@Override
	public String toPostfixNotation() {
		return toPostfixNotation(this);
	}
	
}
