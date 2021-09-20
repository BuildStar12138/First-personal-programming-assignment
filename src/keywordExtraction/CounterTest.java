package keywordExtraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CounterTest {
	public static void main(String[] args) throws IOException {
		//读入输入内容
		Scanner in = new Scanner(System.in);
        String fileName1 = in.nextLine();
        
        //使用BufferedReader通过读入的路径读取文件
        String fileName = fileName1.substring(0, fileName1.length() - 1);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        
        //对读入的第一行进行操作
        Counter counter = new Counter();
        counter.buildSet();
        counter.countKeyWord(line);;
        counter.countIfElse(line);
        
        //对读入的每一行通过counter对象进行计数
        while (line != null ){
        	counter.countKeyWord(line);
        	counter.countIfElse(line);
            line = bufferedReader.readLine();
        }
        counter.countKeyWord(line);
        //输出
        counter.getOut();
        //关闭
        in.close();
        bufferedReader.close();
        fileReader.close();
    }

}
