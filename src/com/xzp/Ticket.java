package com.xzp;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
	// ��ǰӵ�е�Ʊ��
    private int num = 100;
    
    //ʹ��synchronized�ؼ��ֱ�֤�߳�ͬ��
	public void sychronizedTest(){
		synchronized (this) {
            // �����Ʊ��Ϣ
            if(num>0){
                System.out.println(Thread.currentThread().getName() + ".....sale...." + num--);
            }
            
        }
	}
	
	//ʹ��lock��֤�߳�ͬ��
	public void lockTest(){
		ReentrantLock lock = new ReentrantLock();//����Ĭ��false������ƽ��
		//private static ReentrantLock lock=new ReentrantLock(true);  //����trueʱ��Ϊ��ƽ��
		lock.lock(); //�����������Դ���������ڴ˵ȴ����ͷţ��ﵽ��ͣ��Ч��  
        // �����Ʊ��Ϣ
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + ".....sale1...." + num--);
        }
        lock.unlock();  //�ͷ���  
	}

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            sychronizedTest();
            lockTest();
        }
    }
}
