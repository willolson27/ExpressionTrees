import java.util.Stack;
/**
 * 
 * @author will olson (git: willolson27)
 *
 */
public class ExpressionTree extends TreeNode implements Expressions {

	//create global Constants
	private final String PLUS = "+";
	private final String MULT = "*";
	public final String[] operators = {PLUS, MULT};
	
	/**
	 * default constructor
	 * @return a default ExpressionTree
	 */
	public ExpressionTree() {
		
		super(null);
		
	}
	
	/**
	 * constructor that uses buildTree and has an initial value
	 * @return the new ExpressionTree
	 */
	public ExpressionTree(Object initValue) {
		
		super(initValue);
		
		//initialize a separate treenode with the amazing build tree method
		TreeNode t = buildTree((String[]) initValue);
		
		//set this effectively equivalent to the other treenode
		this.setValue(t.getValue());
		this.setLeft(t.getLeft());
		this.setRight(t.getRight());
		
	}
	
	/**
	 * creates an expression tree given postfix 
	 * @param exp
	 * @return root node of the Expression Tree created
	 */
	public TreeNode buildTree(String[] exp) { 

		TreeNode root = new TreeNode(null);
		Stack<TreeNode> stk = new Stack<TreeNode>();

		for (int i = 0; i < exp.length; i++) {
			//get the root
			if (i == exp.length - 1)  {
				root.setValue(exp[i]);
				root.setRight(stk.pop());
				root.setLeft(stk.pop());
			}
			else {
				TreeNode t = new TreeNode(exp[i]);
				//if the char is an operator, add the top two from the stack the right and left 
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
	 * evaluates the result of an expression tree with recursion
	 * @return result of a given expression tree
	 */
	public int evalTree(TreeNode node) {
		
		String s = (String) node.getValue();
		
		//if node is an operator, combine the recursive results of left and right 
		if (isOperator(s)) {
			if (s.equals(MULT)) 
				return (evalTree(node.getLeft()) * evalTree(node.getRight()));
			else 
				return (evalTree(node.getLeft()) + evalTree(node.getRight()));
		}
		//if node is number return the number
		else 
			return Integer.parseInt(s);
		
	}
	
	/**
	 * converts a tree to prefix notation
	 * @param node - root node of the tree being evaluated
	 * @return conversion of this tree to prefix notation
	 */
	public String toPrefixNotation(TreeNode node) {
		
		if (node == null)
			return "n";
		
		//if node is operator - recurse through the rest of the tree to get the result
		if (isOperator(node.getValue())) {
			return (node.getValue().toString() + " " + toPrefixNotation(node.getRight()) +  " " +  toPrefixNotation(node.getLeft()));
		}
		//if node is number return the number
		else
			return (String) node.getValue();

	}
	
	/**
	 * converts a tree to infix notation
	 * @param node - root node of the tree being evaluated
	 * @return conversion of this tree to infix notation
	 */
	public String toInfixNotation(TreeNode node) {
		
		if (node == null)
			return "n";
		
		//if node is operator - recurse through the rest of the tree to get the result
		if (isOperator(node.getValue())) {
			return ("(" + toInfixNotation(node.getLeft()) +  " " + node.getValue().toString() + " " + toInfixNotation(node.getRight()) + ")");
		}
		//if node is number return the number
		else
			return node.getValue().toString();

	}
	
	/**
	 * converts a tree to postfix notation
	 * @param node - root node of the tree being evaluated
	 * @return conversion of this tree to postfix notation
	 */
	public String toPostfixNotation(TreeNode node) {
		
		if (node == null)
			return "n";
		
		//if node is operator - recurse through the rest of the tree to get the result
		if (isOperator(node.getValue())) {
			return (toPostfixNotation(node.getLeft()) +  " " + toPostfixNotation(node.getRight()) + " " + node.getValue().toString());
		}
		//if node is number return the number
		else
			return (String) node.getValue();
		
	}
	
	/**
	 * evaluates a given postfix expression
	 * @param exp - array that represents a postFix expression to be evaluated
	 */
	public int postfixEval(String[] exp) {
		
		//create local stack
		Stack<Integer> stk = new Stack<Integer>();
		
		//traverse the expression and find the mathematical result
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
	 * @param o - object to be checked equal to one of the operators
	 * @return true is object is an operator, false otherwise
	 */
	public boolean isOperator (Object o) {
		
		return (o.equals(MULT) || o.equals(PLUS));
		
	}

	/**
	 * method from Expressions, evaluates the tree by calling a better method
	 * @return result of this expression tree
	 */
	@Override
	public int evalTree() {
		return evalTree(this);
	}

	/**
	 * method from Expressions, converts this tree to prefix by calling a better method
	 * @return conversion of this tree to prefix notation
	 */
	@Override
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}

	/**
	 * method from Expressions, converts this tree to infix by calling a better method
	 * @return conversion of this tree to infix notation
	 */
	@Override
	public String toInfixNotation() {
		return toInfixNotation(this);
	}

	/**
	 * method from Expressions, converts this tree to postfix by calling a better method
	 * @return conversion of this tree to postfix notation
	 */
	@Override
	public String toPostfixNotation() {
		return toPostfixNotation(this);
	}
	
}
