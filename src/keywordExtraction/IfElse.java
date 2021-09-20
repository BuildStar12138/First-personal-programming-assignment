package keywordExtraction;

import java.util.Stack;
/**
 * FileName:IfElse.java
 * ͨ��stack��if,else,else-if���д���
 * ������if��else-ifʱѹ�룬����elseʱ����
 * ����else-ifʱ������һ��if-else-if�ṹ
 * ��������if-else�ṹ
 * @author wotm
 *
 */
public class IfElse {
	private int ifElseNum;
	private int ifElseIfNum;
	//�ж��Ƿ񵯳�else-if
	private boolean isElseIf;
	private Stack<String> stack = new Stack<>();
	/**
	 * �޲�������������ʼ��
	 */
	public IfElse() {
		ifElseNum = 0;
		ifElseIfNum = 0;
		isElseIf = false;
		stack.clear();
	}
	/**
	 * �ж�word���ͣ��Ӷ����г���ջ����
	 * ÿ����һ��elseʱ������һ��if-else��if-else-if�ṹ
	 * �Ӷ�ͳ�Ƹ���
	 * @param word
	 */
	public void findIfElse(String word) {
		//��if��else if������ջ
		if (word.equals("if") || word.equals("else if")) {
			stack.push(word);
			//��else���г�ջ
		}else if (word.equals("else")) {
			//��ջ�е�һ��ifǰ��else ifȫ�������������ı�־
			while (stack.peek().equals("else if")) {
				isElseIf = true;
				stack.pop();
				}
			//��else��Ӧ��if����
			stack.pop();
			//�жϱ�־������
			if (isElseIf) {
				ifElseIfNum ++ ;
				} else {
				ifElseNum ++ ;
				}
			//���ñ�־
			isElseIf = false;
			}
	}
	/**
	 * ���
	 */
	public void getIfElse() {
		System.out.println("if-else num: " + ifElseNum);
		System.out.println("if-elseif-else num: " + ifElseIfNum);
	}
}
