package com.xzp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		question1("z");
		getChildren("abab");
	}
	
	//输入一个字符，将字符转换为小写，将其对应的ASCII值加5后，输出结果。

	//  程序要求：若其值加5后的字符值大于'z',将其转换成从a开始的字符。   输入：‘A’ 输出：‘f’
	public static void question1(String loay){
		int index = loay.charAt(0);		//取出当前字母ASCII码
		int num = index + 5;			
		if(num > 'Z'){
			int a = 'a';			// a 的ASCII码97    A为65
			int z = 'z';			// z 的ASCII码122		Z为90
			System.out.println((char) Character.toLowerCase(num + a - z - 1));
		}else{
			System.out.println((char) Character.toLowerCase(num));
		}
	}
	
	//功能描述：查找一个字符串的子字符串集
	//  输入：abab   输出：a b ab ba aba bab
	public static List<String> getChildren(String str){
		Set<String> set = new TreeSet<String>();
		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (j + i <= str.length()) {
					set.add(str.substring(j, j + i));
				}
			}
		}
		List<String> list = new ArrayList<String>();
        list.addAll(set);
        System.out.println(list);
        return list;
	}
 
	
	
	
}
