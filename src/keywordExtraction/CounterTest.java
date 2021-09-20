package keywordExtraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CounterTest {
	public static void main(String[] args) throws IOException {
		//������������
		Scanner in = new Scanner(System.in);
        String fileName1 = in.nextLine();
        
        //ʹ��BufferedReaderͨ�������·����ȡ�ļ�
        String fileName = fileName1.substring(0, fileName1.length() - 1);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        
        //�Զ���ĵ�һ�н��в���
        Counter counter = new Counter();
        counter.buildSet();
        counter.countKeyWord(line);;
        counter.countIfElse(line);
        
        //�Զ����ÿһ��ͨ��counter������м���
        while (line != null ){
        	counter.countKeyWord(line);
        	counter.countIfElse(line);
            line = bufferedReader.readLine();
        }
        counter.countKeyWord(line);
        //���
        counter.getOut();
        //�ر�
        in.close();
        bufferedReader.close();
        fileReader.close();
    }

}
