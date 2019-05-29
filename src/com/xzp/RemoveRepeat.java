package com.xzp;

import java.util.Random;

public class RemoveRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "112233aabbcc";
		System.out.println(done(str)+"-====");
		System.out.println(Random(6,10));
		Ticket ticket = new Ticket();
		ticket.run();
	}
	
	public static String done(String str){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			int first = str.indexOf(letter);
			int last = str.lastIndexOf(letter);
			if(first == last || first == i){
				buffer.append(letter);
			}
		}
		
		return buffer.toString();
	}
	
	//生成字母和数字组成的随机字符串数组
	public static String[] Random(int count,int length){
		String[] arrs = new String[count];
		for (int i = 0; i < count; i++) {
			arrs[i] = getRandomCharacterAndNumber(length);
			System.out.println(arrs[i]);
		}
		return arrs;
	}
	
	//生成字母和数字组成的随机字符串
	public static String getRandomCharacterAndNumber(int length) {  
       String val = "";  
       Random random = new Random();  
       for (int i = 0; i < length; i++) {  
           String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字  
  
           if ("char".equalsIgnoreCase(charOrNum)) // 字符串  
           {  
               int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母  
               val += (char) (choice + random.nextInt(26));  
               // int choice = 97; // 指定字符串为小写字母  
               val += (char) (choice + random.nextInt(26));  
           } else if ("num".equalsIgnoreCase(charOrNum)) // 数字  
           {  
               val += String.valueOf(random.nextInt(10));  
           }  
       }  
       return val;  
   }  

}
