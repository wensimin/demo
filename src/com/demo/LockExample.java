package com.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    /**
     * 转账
     *
     * @param from  来源账户
     * @param to    目标账户
     * @param money 转账金额
     */
    public static void transfer(Account from, Account to, int money) {
        // 手动通过目标集的固定数值进行排序，保证进入锁的顺序一致
        boolean fromFirst = from.id < to.id;
        try {
            if (fromFirst) {
                from.lock.lock();
                to.lock.lock();
            } else {
                to.lock.lock();
                from.lock.lock();
            }
            from.money -= money;
            to.money += money;
        } finally {
            from.lock.unlock();
            to.lock.unlock();
        }
    }


    public static void main(String[] arg) throws InterruptedException {
        Account a = new Account(1);
        Account b = new Account(2);
        int count = 10000000;
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                transfer(a, b, 1);
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                transfer(b, a, 1);
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(String.format("a=%s,b=%s", a.money, b.money));
        if (!(a.money == 0 && b.money == 0)) throw new AssertionError();
    }
}

class Account {
    public int id;
    public int money;
    public Lock lock;

    public Account(int id) {
        this.id = id;
        this.money = 0;
        this.lock = new ReentrantLock();
    }
}
