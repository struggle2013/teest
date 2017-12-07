package pres.luo.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=3234;
		printNum(num);
	}
	static void printNum(int num) {
		List<Integer> temp = new ArrayList<Integer>();
		int t;
		while(num>0) {
			t=num%10;
			temp.add(t);
			num=num/10;
		}
		Collections.reverse(temp);
		for (Integer integer : temp) {
			System.out.print(integer+" ");
		}
	}

}
