package faang.school.godbless.lets_play_bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
public class Account {
    private int id;
    private volatile long balance;
    //private final ReentrantLock lock = new ReentrantLock(true);

    public void deposit(long money) {
       // lock.lock();// вот не понимаю. работает и с блокировкой и нет. Гуглил,пишут,что если объекты в ConcurrentHashMap, то вроде как она все делает,
       // try { // но если поля у объектов изменяются их методами, то может быть и нужна блокировка. В общем не знаю, надеюсь на комментарий
            System.out.println("Выполнено пополнение счета аккаунта " + id + " на сумму " + money);
            balance += money;
            System.out.println("Balance: " + balance);
       // } finally {
      //      lock.unlock();
       // }
    }

    public void withdraw(long money) {
        //lock.lock();
       // try {
            System.out.println("Выполнено списание со счета аккаунта " + id + " на сумму " + money);
            balance -= money;
            System.out.println("Balance: " + balance);
       // } finally {
       //     lock.unlock();
       // }
    }
}
