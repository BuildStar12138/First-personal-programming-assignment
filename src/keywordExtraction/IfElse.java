package keywordExtraction;

import java.util.Stack;
/**
 * FileName:IfElse.java
 * 通过stack对if,else,else-if进行处理
 * 当出现if，else-if时压入，出现else时弹出
 * 弹出else-if时，则是一个if-else-if结构
 * 否则则是if-else结构
 * @author wotm
 *
 */
public class IfElse {
	private int ifElseNum;
	private int ifElseIfNum;
	//判断是否弹出else-if
	private boolean isElseIf;
	private Stack<String> stack = new Stack<>();
	/**
	 * 无参数构造器，初始化
	 */
	public IfElse() {
		ifElseNum = 0;
		ifElseIfNum = 0;
		isElseIf = false;
		stack.clear();
	}
	/**
	 * 判断word类型，从而进行出入栈操作
	 * 每出现一个else时，则有一个if-else或if-else-if结构
	 * 从而统计个数
	 * @param word
	 */
	public void findIfElse(String word) {
		//对if，else if进行入栈
		if (word.equals("if") || word.equals("else if")) {
			stack.push(word);
			//对else进行出栈
		}else if (word.equals("else")) {
			//将栈中第一个if前的else if全部弹出，并更改标志
			while (stack.peek().equals("else if")) {
				isElseIf = true;
				stack.pop();
				}
			//将else对应的if弹出
			stack.pop();
			//判断标志并计数
			if (isElseIf) {
				ifElseIfNum ++ ;
				} else {
				ifElseNum ++ ;
				}
			//重置标志
			isElseIf = false;
			}
	}
	/**
	 * 输出
	 */
	public void getIfElse() {
		System.out.println("if-else num: " + ifElseNum);
		System.out.println("if-elseif-else num: " + ifElseIfNum);
	}
}
