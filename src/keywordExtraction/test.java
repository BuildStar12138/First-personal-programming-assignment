package keywordExtraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        String fileName1 = in.nextLine();
        //char level = fileName1.charAt(fileName1.length()-1);
        String fileName = fileName1.substring(0, fileName1.length()-1);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line =bufferedReader.readLine();
        Counter counter = new Counter();
        counter.buildSet();
        counter.count(line);
        counter.countIfElse(line);
        
        //System.out.println(level);

        while (line!=null){
        	counter.count(line);
        	counter.countIfElse(line);
            line = bufferedReader.readLine();
        }
        counter.count(line);
        counter.getOut();
        in.close();
        bufferedReader.close();
        fileReader.close();
    }

}
