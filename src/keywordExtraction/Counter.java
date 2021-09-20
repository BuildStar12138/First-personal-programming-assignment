package keywordExtraction;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * FileName:Counter.java
 * 计数器：
 * 包含keyword，switchAndcase，ifElse，treeSet四个属性
 * keyword为int类型，用于统计出现的关键字个数
 * switchAndcase是类对象，用于统计switch和case的个数以及一组有几个case
 * ifElse是类对象，用于处理if-else，if-elseif-else的个数
 * @author wotm
 *
 */
public class Counter {
	private int keyword;
	private SwitchAndCase switchAndcase;
	private IfElse ifElse;
	/*树集，用于存储关键字*/
	private TreeSet<String> treeSet = new TreeSet<>();
	
	/**
	 * 因为不需要输入参数，所以构造无参数构造器
	 */
	public Counter() {
		keyword = 0;
		switchAndcase = new SwitchAndCase();
		ifElse = new IfElse();
	}
	
	/**
	 * 将关键字存入树集
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
	 * 通过正则表达式搜索一行中的单词，并测试是否在树集中
	 * 若存在，keyword统计个数加一
	 * @param line
	 */
	public void countKeyWord(String line) {
		/*
		 * 当字段为空时，将最后一个Switch—case组合中case的个数存入case数组
		 * 当字段为空时，退出方法，避免Matcher报错
		 */
		if (line == null ) {
			switchAndcase.addCaseNum();
			return ;
		}
		
		//利用正则表达式搜索一行中的单词
		String regex = "[a-zA-Z]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		while (m.find()) {
			//当单词是关键字时，执行计数操作
			if (treeSet.contains(m.group())) {
				keyword++;
				switchAndcase.findSwitchAndCase(m.group());
			}
		}
	}
	
	/**
	 * 使用搜索else if的正则表达式和搜索if，else的正则表达式
	 * 若搜索到，则进行出入栈操作，并进行计数
	 * @param line
	 */
	public void countIfElse(String line) {
		//当字段为空时，退出方法，避免Matcher报错
		if (line == null ) { return ;}
		
		//利用正则表达式搜索“else if”
		String regex_elseif = "else if";
		Pattern p_elseif = Pattern.compile(regex_elseif);
		Matcher m_elseif = p_elseif.matcher(line);
		
		//利用正则表达式搜索“if”，“else”
		String regex_ifOrElse = "if|else";
		Pattern p_ifOrElse = Pattern.compile(regex_ifOrElse);
		Matcher m_ifOrElse = p_ifOrElse.matcher(line);
		
		//利用flag判断本行是否读入“else if”，如果读入则不再读入“if”或“else”
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
	 * 输出所有需要输出的项目
	 */
	public void getOut() {
		System.out.println("total num: " + keyword);
		switchAndcase.getSwitchAndCase();
		ifElse.getIfElse();
	}

}
