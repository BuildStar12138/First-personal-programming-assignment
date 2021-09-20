package keywordExtraction;

import java.util.ArrayList;
import java.util.Stack;

public class SwitchAndCase {
	private int SwitchNum;
	private ArrayList<Integer> CaseNum = new ArrayList<>();
	private Stack<String> stack = new Stack<>();
	public SwitchAndCase() {
		SwitchNum = 0;
		CaseNum.clear();
		stack.clear();
	}
	public void find(String word) {
		if(word.equals("switch")) {
			SwitchNum++;
			if(SwitchNum != 1) {
				CaseNum.add(stack.size());
				stack.clear();
			}
		}
		if(word.equals("case")) {
			stack.add(word);
		}
	}
	public void addCaseNum() {
		CaseNum.add(stack.size());
		stack.clear();
	}
	public void getSwitchAndCase() {
		System.out.println("switch num: "+SwitchNum);
		System.out.print("case num:");
		for(Object e:CaseNum) {
			System.out.print(" "+e.toString());
		}
		System.out.println();
	}
}
