package faang.school.godbless.lets_play_bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
public class Account {
    @Getter
    private int id;
    private volatile long balance;
    private final ReentrantLock lock = new ReentrantLock(true);

    public void deposit(long money) {
        lock.lock();// вот не понимаю. работает и с блокировкой и нет. Гуглил,пишут,что если объекты в ConcurrentHashMap, то вроде как она все делает,
        try { // но если поля у объектов изменяются их методами, то может быть и нужна блокировка. В общем не знаю, надеюсь на комментарий на эту тему. Если каждый бакет представляет
            System.out.println("Выполнено пополнение счета аккаунта " + id + " на сумму " + money);// свою собственную независимую блокировку, то какая опасность может быть для методов
            balance += money; // объекта, который весь заблокирован для других потоков?
            System.out.println("Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(long money) {
        lock.lock();// сначала написал, после гуглежа убрал. А как посмотрел подсказки после решения задачи, оказалось, что все это надо,
        try { // но так и не понятно ничего
            System.out.println("Выполнено списание со счета аккаунта " + id + " на сумму " + money);
            balance -= money;
            System.out.println("Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

}
