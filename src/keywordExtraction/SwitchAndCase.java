package keywordExtraction;

import java.util.ArrayList;
import java.util.Stack;
/**
 * FileName:SwitchAndCase.java
 * ��Switch��case���д���
 * ����һ��case��Integer���ϣ������洢ÿһ��Switch��Ӧ��case����
 * ͨ��stack������һ��Switch�µ�case������һ��Switch����ʱ
 * ��stack�еĸ�������case���ϲ����stack
 * @author wotm
 *
 */
public class SwitchAndCase {
	private int SwitchNum;
	private ArrayList<Integer> CaseNum = new ArrayList<>();
	private Stack<String> stack = new Stack<>();
	/**
	 * �޲�������������ʼ��
	 */
	public SwitchAndCase() {
		SwitchNum = 0;
		CaseNum.clear();
		stack.clear();
	}
	/**
	 * �ж϶����word�ǲ���switch��case
	 * ����ǣ��������Ӧ����
	 * @param word
	 */
	public void findSwitchAndCase(String word) {
		if (word.equals("switch")) {
			SwitchNum ++ ;
			//��switch���ǵ�һ��ʱ��ÿ����һ���Ͱ�֮ǰ���ֵ�case��������case����
			if (SwitchNum != 1) {
				CaseNum.add(stack.size());
				stack.clear();
			}
		}
		//case����ʱ��ѹ��stack
		if (word.equals("case")) {
			stack.add(word);
		}
	}
	/**
	 * ���һ���case������Ҫ�Լ���������
	 */
	public void addCaseNum() {
		CaseNum.add(stack.size());
		stack.clear();
	}
	/**
	 * ���
	 */
	public void getSwitchAndCase() {
		System.out.println("switch num: " + SwitchNum);
		System.out.print("case num:");
		for (Object e:CaseNum) {
			System.out.print(" " + e.toString());
		}
		System.out.println();
	}
}
