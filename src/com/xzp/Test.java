package com.xzp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "112233aaff11aabbcc";
		//System.out.println(RemoveRepeat.done(str)+"-====");
		//FourNumberRandom();
		NumberTwo();
		Change();
		BubbleSort();
		RandomRibbon();
	}
	
	//冒泡排序
	public static void BubbleSort(){
		int[] arr = {3,9,5,7,1};
		System.out.print("排序前数组为：");
		for (int num : arr) {
			System.out.print(num+" ");
		}
		//外层循环排序趟数
		for (int i = 0; i < arr.length; i++) {
			//内层循环控制每一趟排序多少次
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.print("排序后:");
		for (int i : arr) {
			System.out.print(i+ " ");
		}
		System.out.println(" ");
	}
	
	
	//生成一个随机四位数，每位数字不重复。
	//0-9，定义为数组，出现该数字后，修改相应下标为1
	public static void FourNumberRandom(){
		Random random = new Random();
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String str = "";
        int temp = 0;
        while (str.length() != 4) {
            temp = random.nextInt(10);//随机获取0~9的数字
            if (arr[temp] == 0) {
                str += temp;
                arr[temp] = 1;
            }
        }
        System.out.println(str);
	}
	
	//1万个数字中求第二大的数（不允许用算法排序）
	public static void NumberTwo(){
		List<Integer> list = new ArrayList(10000);
		for (int i = 0; i < 10000; i++) {
            int num = (int) ( Math.random() * (10000 - 0 + 1));
            list.add(num);
        }
        list.sort(Integer::compareTo);
        System.out.println(list.indexOf(9999));
	}
	
	//不使用中间变量，逆置字符串。
	public static void Change(){
		String str = "ABCDEF";
		for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
		System.out.println(" ");
	}
	
	//实现线程安全的轮询算法
	public static void RandomRibbon(){
		List<String> ips = new ArrayList<String>();
		ips.add("url1");
		ips.add("url2");
		ips.add("url3");
		System.out.println("now ip:" + doSelect(ips));
		System.out.println("now ip:" + doSelect(ips));
		System.out.println("now ip:" + doSelect(ips));
		System.out.println("now ip:" + doSelect(ips));
		System.out.println("now ip:" + doSelect(ips));
		System.out.println("now ip:" + doSelect(ips));
		char x = 'x';
		int i = 0;
		System.out.println(true?x:0);
		System.out.println(false?i:x);
	}
	private static Integer index = 0;	//定义为静态变量
	public static String doSelect(List<String> iplist){
		synchronized(index){
			if(index >= iplist.size()){
				index = 0;
			}
			String ip = iplist.get(index);
			index++;
			return ip;
		}
	}
	
	
}
