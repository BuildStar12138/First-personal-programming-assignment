package keywordExtraction;

import java.util.ArrayList;
import java.util.Stack;
/**
 * FileName:SwitchAndCase.java
 * 对Switch和case进行处理
 * 创建一个case的Integer集合，用来存储每一个Switch对应的case个数
 * 通过stack来储存一个Switch下的case，当下一个Switch读入时
 * 将stack中的个数存入case集合并清空stack
 * @author wotm
 *
 */
public class SwitchAndCase {
	private int SwitchNum;
	private ArrayList<Integer> CaseNum = new ArrayList<>();
	private Stack<String> stack = new Stack<>();
	/**
	 * 无参数构造器，初始化
	 */
	public SwitchAndCase() {
		SwitchNum = 0;
		CaseNum.clear();
		stack.clear();
	}
	/**
	 * 判断读入的word是不是switch或case
	 * 如果是，则进行相应操作
	 * @param word
	 */
	public void findSwitchAndCase(String word) {
		if (word.equals("switch")) {
			SwitchNum ++ ;
			//当switch不是第一个时，每出现一个就把之前出现的case个数存入case集合
			if (SwitchNum != 1) {
				CaseNum.add(stack.size());
				stack.clear();
			}
		}
		//case出现时，压入stack
		if (word.equals("case")) {
			stack.add(word);
		}
	}
	/**
	 * 最后一组的case个数需要自己存入数组
	 */
	public void addCaseNum() {
		CaseNum.add(stack.size());
		stack.clear();
	}
	/**
	 * 输出
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
