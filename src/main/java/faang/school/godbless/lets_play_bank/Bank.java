package faang.school.godbless.lets_play_bank;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void transfer(Account from, Account to, long money) {
        // это сделано по подсказке. Работает через раз,зависает.
//        Account min = from.getId() < to.getId() ? from : to;
//        Account max = from.getId() < to.getId() ? to : from;
//        synchronized (min) {
//            CompletableFuture.runAsync(() -> {
//                try {
//                    Thread.sleep(Math.round(Math.random() * 7000));
//                    if (from.getBalance() >= money) {
//                        from.withdraw(money);
//                        synchronized (max) {
//                            to.deposit(money);
//                            System.out.println("Transfer success");
//                        }
//                    } else {
//                        System.out.println("На счету аккаунта " + from.getId() + " недостаточно средств");
//                    }
//                } catch (Exception e) {
//                    System.err.println("Transfer failed");
//                }
//            }).join();
//        }
        // так не зависает. если мы берем объекты, которые в защищенной мапе, зачем еще блокировки?
        lock.writeLock().lock();    //  согласно подсказкам, еще на каждый метод объекта блокировки навешали, зачем тут еще на каждый отдельный объект?
        if (from.getBalance() >= money) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(Math.round(Math.random() * 7000));
                    from.withdraw(money);
                    to.deposit(money);
                    System.out.println("Transfer success");
                } catch (InterruptedException e) {
                    System.err.println("Transfer failed");
                }
            });
            future.join();
        } else {
            System.out.println("На счету аккаунта " + from.getId() + " недостаточно средств");
        }
        lock.writeLock().unlock();
    }

    // В условии не указано, общий баланс чего, но я решил, что он должен вычисляться по всем счетам, а не конкретного аккаунта
    // но тогда непонятно, зачем он вообще нужен, если все операции внутри одного банка и общее количество меняться не будет. Просто раз глянуть,
    // сколько есть или после каждой операции выводить одно и то же число?
    public void getTotalBalance(Map<Integer, Account> accounts) {
        //lock.readLock().lock();// не знаю,стоит ли в контексте данной задачи, но, как я понял, это нужно, если представить, что операции и между банками совершаются
//        try { // и нам нужно узнавать меняющийся баланс данного банка, но не мешать операциям перевода.
        long totalBalance = accounts.values().stream().mapToLong(Account::getBalance).sum();
        System.out.println("Total balance of the bank: " + totalBalance);
//        } finally {  // в итоге после подсказок все же понял, что все не так. Ничего не понимаю вообще.
//            lock.readLock().unlock();
//        }
    }
}
