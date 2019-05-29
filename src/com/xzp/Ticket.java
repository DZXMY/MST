package com.xzp;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
	// 当前拥有的票数
    private int num = 100;
    
    //使用synchronized关键字保证线程同步
	public void sychronizedTest(){
		synchronized (this) {
            // 输出卖票信息
            if(num>0){
                System.out.println(Thread.currentThread().getName() + ".....sale...." + num--);
            }
            
        }
	}
	
	//使用lock保证线程同步
	public void lockTest(){
		ReentrantLock lock = new ReentrantLock();//参数默认false，不公平锁
		//private static ReentrantLock lock=new ReentrantLock(true);  //传入true时，为公平锁
		lock.lock(); //如果被其它资源锁定，会在此等待锁释放，达到暂停的效果  
        // 输出卖票信息
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + ".....sale1...." + num--);
        }
        lock.unlock();  //释放锁  
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
