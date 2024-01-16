package faang.school.godbless.play_pot;

import lombok.*;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Random random = new Random();
        Bank mts = new Bank();

        Account account1 = new Account(1, 2000);
        Account account2 = new Account(2, 23000);
        Account account3 = new Account(3, 42000);
        Account account4 = new Account(4, 42100);
        Account account5 = new Account(5, 131000);
        Account account6 = new Account(6, 21120);
        Account account7 = new Account(7, 200);
        Account account8 = new Account(8, 42630);
        Account account9 = new Account(9, 4241);
        Account account10 = new Account(10, 1000);

        mts.getAccounts().put(account1.getId(), account1);
        mts.getAccounts().put(account2.getId(), account2);
        mts.getAccounts().put(account3.getId(), account3);
        mts.getAccounts().put(account4.getId(), account4);
        mts.getAccounts().put(account5.getId(), account5);
        mts.getAccounts().put(account6.getId(), account6);
        mts.getAccounts().put(account7.getId(), account7);
        mts.getAccounts().put(account8.getId(), account8);
        mts.getAccounts().put(account9.getId(), account9);
        mts.getAccounts().put(account10.getId(), account10);

        for (int i = 0; i < 40; i++) {
            Account accountFrom = mts.getAccounts().get(random.nextInt(1, mts.getAccounts().size()));
            Account accountTo = mts.getAccounts().get(random.nextInt(1, mts.getAccounts().size()));
            int amound = random.nextInt(1, 10_000);
            executorService.submit(() -> mts.transfer(accountFrom, accountTo, amound));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        mts.getTotalBalance();

//        mts.getTotalBalance();
//        System.out.println("Средств в банке " + mts.getTotalBalance());
    }
}


@Data
@AllArgsConstructor
class Account {
    private final ReentrantLock lock = new ReentrantLock();
    private final int id;
    private int balance;

    public void deposit(int amountOfMany) {
        lock.lock();
        try {
            balance += amountOfMany;
            System.out.println("Пополнение на сумму: " + amountOfMany + " выполнено аккаунту: " + id + " в потоке " + Thread.currentThread().getName() + "\n");
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amountOfMany) {
        lock.lock();
        try {
            balance -= amountOfMany;
            System.out.println(Thread.currentThread().getName() + " Начал работу" + "\n Списание у аккаунта " + id + " на сумму: " + amountOfMany + " выполнено! \n");
        } finally {
            lock.unlock();
        }
    }
}

@Getter
@Setter
@EqualsAndHashCode
@ToString
class Bank {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void transfer(Account from, Account to, int money) {
        if (from.getBalance() >= money && (from.getBalance() - money) >= 0) {
            try {
                Thread.sleep(new Random().nextInt(2, 5) * 1000L);
                from.withdraw(money);
                to.deposit(money);
                System.out.println(Thread.currentThread().getName() + " Начал работу" + "\n Перевод от аккаунта " + from.getId() + " выполнен успешно! Аккаунт "
                        + to.getId() + " получил перевод!\n" + " На сумму " + money + "." + "Баланс аккаунта " + to.getId() + " = " + to.getBalance() + "\n");
            } catch (InterruptedException e) {
                System.err.println("Перевод не выполнен" + " возврат аккаунту " + from.getId() + " суммы " + money + "\n");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " Начал работу" + "\n" + "У аккаунта " + from.getId() + "  не достаточно средств! Баланс = "
                    + from.getBalance() + ". Запрос перевода на сумму " + money + " отклонен.\n");
        }
    }

//    public int getTotalBalance() {
//        return accounts.values().stream()
//                .mapToInt(Account::getBalance)
//                .sum();
//    }

    public void getTotalBalance() {
        int reduce = accounts.values().stream()
                .mapToInt(Account::getBalance)
                .reduce(0, Integer::sum);
        System.out.println("Кэш банка =  " + reduce);
    }
// какой из методов лучше применять: Тот который Void и сразу выводит на экран? Или тот который возвращает int, и вызывать метод через sout?
}
// методы по блокам Lock.lock нужны ли вообще? если используем канкаред Хеш Мап?
//"... Методы deposit, withdraw и getBalance класса Account должны быть защищены блокировкой lock, что обеспечит синхронизацию доступа к изменяемым полям класса...." ----
//  --- насколько я понял, это для того чтобы из ВНЕ не поменяли поля класса? Не в мапе, а напрямую например аккаун1.сетБаланс; а в самом объекте?
// Тогда и объект в мапе тоже изменит свое состояние тк хранит ссылку на объект.
//    Вообщем не совсем понятно!
