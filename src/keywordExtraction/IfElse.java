package keywordExtraction;

import java.util.Stack;

public class IfElse {
	private int ifElseNum;
	private int ifElseIfNum;
	private boolean isElseIf;
	private Stack<String> stack = new Stack<>();
	public IfElse() {
		ifElseNum = 0;
		ifElseIfNum = 0;
		isElseIf = false;
		stack.clear();
	}
	public void find(String word) {
		if( word.equals("if") || word.equals("else if")) {
			stack.push(word);
		}
		else if(word.equals("else")) {
			while(stack.peek().equals("else if")) {
				isElseIf = true;
				stack.pop();
			}
			stack.pop();
			if(isElseIf) {
				ifElseIfNum ++;
			}
			else {
				ifElseNum ++;
			}
			isElseIf = false;
		    }
	}
	public void getIfElse() {
		System.out.println("if-else num: "+ifElseNum);
		System.out.println("if-elseif-else num: "+ifElseIfNum);
	}
}
