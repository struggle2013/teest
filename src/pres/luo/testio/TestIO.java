package pres.luo.testio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIO {

	public static void main(String[] args) {
		createFile("scoreAnalysis.txt");
		File fread = new File("score.txt");
		File fwrite = new File("scoreAnalysis.txt");
		try {
			FileWriter out = new FileWriter(fwrite,true);
			BufferedWriter bufferOut = new BufferedWriter(out);
			
			FileReader in = new FileReader(fread);
			BufferedReader bufferIN = new BufferedReader(in);
			String str=null;
			while((str=bufferIN.readLine()) != null) {
				System.out.println(str);
				double totalScore = getTotalScore(str);
				str = str+"总成绩:"+totalScore;
				System.out.println(str+"\n");
				bufferOut.write(str);
				bufferOut.newLine();
			}
			bufferIN.close();
			bufferOut.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static double getTotalScore(String s) {
		String regex="[：k]";
		//String digitMess = s.replace(regex,"*");
		String[] scores=s.split(regex);
		double totalScore = Integer.parseInt(scores[2])
				+Integer.parseInt(scores[4]);
		return totalScore;
	}
	public static void createFile(String fileName) {
		File file = new File(fileName);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
