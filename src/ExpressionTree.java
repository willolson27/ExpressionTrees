import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions {

	private final String PLUS = "+";
	private final String MULT = "*";
	public String[] operators = {PLUS, MULT};
	
	/**
	 * constructor
	 */
	public ExpressionTree() {
		
		super(null);
		
	}
	
	/**
	 * constructor
	 */
	public ExpressionTree(Object initValue) {
		
		super(initValue);
		TreeNode t = buildTree((String[]) initValue);
		this.setValue(t.getValue());
		this.setLeft(t.getLeft());
		this.setRight(t.getRight());
		
	}
	
	/**
	 * creates an expression tree given postfix 
	 * @param exp
	 */
	public TreeNode buildTree(String[] exp) { 

		
		
		TreeNode root = new TreeNode(null);
		Stack<TreeNode> stk = new Stack<TreeNode>();

		for (int i = 0; i < exp.length; i++) {
			if (i == exp.length - 1)  {
				root.setValue(exp[i]);
				root.setRight(stk.pop());
				root.setLeft(stk.pop());
			}
			else {
				TreeNode t = new TreeNode(exp[i]);
				if (isOperator(exp[i])) {
					t.setRight(stk.pop());
					t.setLeft(stk.pop());
					stk.push(t);
				}
				else {
					stk.push(t);
				}			
			}			
		}
				
		
		return root; 
		
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
		
		if (node == null)
			return "n";
		if (isOperator(node.getValue())) {
			return (node.getValue().toString() + " " + toPrefixNotation(node.getRight()) +  " " +  toPrefixNotation(node.getLeft()) + " ");
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
		if (node == null)
			return "n";
		if (isOperator(node.getValue())) {
			return ("(" + toInfixNotation(node.getLeft()) +  " " + node.getValue().toString() + " " + toInfixNotation(node.getRight()) + " )"   );
		}
		else
			return (String) node.getValue();

	}
	
	/**
	 * converts a tree to postfix notation
	 * @param node - root node of the tree being evaluated
	 */
	public String toPostfixNotation(TreeNode node) {
		
		if (node == null)
			return "n";
		if (isOperator(node.getValue())) {
			return (toPostfixNotation(node.getLeft()) +  " " + toPostfixNotation(node.getRight()) + " " + node.getValue().toString() + " " );
		}
		else
			return (String) node.getValue();
		
	}
	
	/**
	 *evaluates a given postfix expression
	 * @param exp
	 */
	public int postfixEval(String[] exp) {
		
	
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < exp.length; i++) {
			exp[i].trim();
				if (isOperator(exp[i])) {
					if (exp[i].equals(PLUS))
						stk.push(stk.pop() + stk.pop());
					else if (exp[i].equals(MULT))
						stk.push(stk.pop() * stk.pop());
				}
				else {
					stk.push(Integer.parseInt(exp[i]));
				}	
			
		}			
		return stk.pop();
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
