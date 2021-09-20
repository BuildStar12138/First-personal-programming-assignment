package keywordExtraction;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
	private int keyword;
	private SwitchAndCase switchAndcase;
	private IfElse ifElse;
	private TreeSet<String> treeSet = new TreeSet<>();
	public Counter() {
		keyword = 0;
		switchAndcase = new SwitchAndCase();
		ifElse = new IfElse();
	}
	public void buildSet() {
		String[] keywords = {"auto","break","case","char","const",
			"continue","default","do","double","else","enum","extern",
			"for","goto","if","int","long","register","return","short",
			"signed","sizeof","static","struct","switch","typedef",
			"union","unsigned","void","volatile","float","while"};
		for(String e:keywords) {
			treeSet.add(e);
		}
	}
	public void count(String line) {
		if(line == null) {
			switchAndcase.addCaseNum();
			return ;
		}
		String regex = "[a-zA-Z]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		while (m.find()) {
			if(treeSet.contains(m.group())) {
				keyword++;
				switchAndcase.find(m.group());
			}
		}
	}
	public void countIfElse(String line) {
		String regex_elseif = "else if";
		String regex_ifOrElse = "if|else";
		if(line == null) {return ;}
		Pattern p_elseif = Pattern.compile(regex_elseif);
		Matcher m_elseif = p_elseif.matcher(line);
		
		Pattern p_ifOrElse = Pattern.compile(regex_ifOrElse);
		Matcher m_ifOrElse = p_ifOrElse.matcher(line);
		boolean flag = false;
		//System.out.println(line);
		while(m_elseif.find()) {
			flag = true;
			ifElse.find(m_elseif.group());
		}
		if (flag) {}
		else {
			while(m_ifOrElse.find()) {
				ifElse.find(m_ifOrElse.group());
			}
		}
	}
	
	public void getOut() {
		System.out.println("total num: "+keyword);
		switchAndcase.getSwitchAndCase();
		ifElse.getIfElse();
	}

}
