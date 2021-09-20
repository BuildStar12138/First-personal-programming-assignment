package keywordExtraction;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * FileName:Counter.java
 * ��������
 * ����keyword��switchAndcase��ifElse��treeSet�ĸ�����
 * keywordΪint���ͣ�����ͳ�Ƴ��ֵĹؼ��ָ���
 * switchAndcase�����������ͳ��switch��case�ĸ����Լ�һ���м���case
 * ifElse����������ڴ���if-else��if-elseif-else�ĸ���
 * @author wotm
 *
 */
public class Counter {
	private int keyword;
	private SwitchAndCase switchAndcase;
	private IfElse ifElse;
	/*���������ڴ洢�ؼ���*/
	private TreeSet<String> treeSet = new TreeSet<>();
	
	/**
	 * ��Ϊ����Ҫ������������Թ����޲���������
	 */
	public Counter() {
		keyword = 0;
		switchAndcase = new SwitchAndCase();
		ifElse = new IfElse();
	}
	
	/**
	 * ���ؼ��ִ�������
	 */
	public void buildSet() {
		String[] keywords = {
			"auto","break","case","char","const",
			"continue","default","do","double","else","enum","extern",
			"for","goto","if","int","long","register","return","short",
			"signed","sizeof","static","struct","switch","typedef",
			"union","unsigned","void","volatile","float","while"
			};
		for (String e:keywords) {
			treeSet.add(e);
		}
	}
	
	/**
	 * ͨ��������ʽ����һ���еĵ��ʣ��������Ƿ���������
	 * �����ڣ�keywordͳ�Ƹ�����һ
	 * @param line
	 */
	public void countKeyWord(String line) {
		/*
		 * ���ֶ�Ϊ��ʱ�������һ��Switch��case�����case�ĸ�������case����
		 * ���ֶ�Ϊ��ʱ���˳�����������Matcher����
		 */
		if (line == null ) {
			switchAndcase.addCaseNum();
			return ;
		}
		
		//����������ʽ����һ���еĵ���
		String regex = "[a-zA-Z]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		while (m.find()) {
			//�������ǹؼ���ʱ��ִ�м�������
			if (treeSet.contains(m.group())) {
				keyword++;
				switchAndcase.findSwitchAndCase(m.group());
			}
		}
	}
	
	/**
	 * ʹ������else if��������ʽ������if��else��������ʽ
	 * ��������������г���ջ�����������м���
	 * @param line
	 */
	public void countIfElse(String line) {
		//���ֶ�Ϊ��ʱ���˳�����������Matcher����
		if (line == null ) { return ;}
		
		//����������ʽ������else if��
		String regex_elseif = "else if";
		Pattern p_elseif = Pattern.compile(regex_elseif);
		Matcher m_elseif = p_elseif.matcher(line);
		
		//����������ʽ������if������else��
		String regex_ifOrElse = "if|else";
		Pattern p_ifOrElse = Pattern.compile(regex_ifOrElse);
		Matcher m_ifOrElse = p_ifOrElse.matcher(line);
		
		//����flag�жϱ����Ƿ���롰else if��������������ٶ��롰if����else��
		boolean flag = false;
		while (m_elseif.find()) {
			flag = true;
			ifElse.findIfElse(m_elseif.group());
		}
		if (flag) {}
		else {
			while(m_ifOrElse.find()) {
				ifElse.findIfElse(m_ifOrElse.group());
			}
		}
	}
	/**
	 * ���������Ҫ�������Ŀ
	 */
	public void getOut() {
		System.out.println("total num: " + keyword);
		switchAndcase.getSwitchAndCase();
		ifElse.getIfElse();
	}

}
