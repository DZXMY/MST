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
		palindrome(98);
		System.out.println(isPalindrome(343));
	}
	
	//����һ���ַ������ַ�ת��ΪСд�������Ӧ��ASCIIֵ��5����������

	//  ����Ҫ������ֵ��5����ַ�ֵ����'z',����ת���ɴ�a��ʼ���ַ���   ���룺��A�� �������f��
	public static void question1(String loay){
		int index = loay.charAt(0);		//ȡ����ǰ��ĸASCII��
		int num = index + 5;			
		if(num > 'Z'){
			int a = 'a';			// a ��ASCII��97    AΪ65
			int z = 'z';			// z ��ASCII��122		ZΪ90
			System.out.println((char) Character.toLowerCase(num + a - z - 1));
		}else{
			System.out.println((char) Character.toLowerCase(num));
		}
	}
	
	//��������������һ���ַ��������ַ�����
	//  ���룺abab   �����a b ab ba aba bab
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
 
	//�ж��Ƿ�Ϊ������
	public static boolean palindrome(int num) {
        String str = String.valueOf(num);
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println(str.equals(reverse));
        return str.equals(reverse);
    }
	public static boolean isPalindrome(int x) {
        int t = 0;
        while (x > t) {
            t = t * 10 + x % 10; // �Ӻ���ǰȡ��
            if (t == 0) return false; // ĩβΪ 0 �϶�����
            x /= 10; // �Ӻ���ǰȥ��
        }
        return (x == t || x == t / 10); // żλ��Ⱥ���λ���
    }
	
	
	
}
