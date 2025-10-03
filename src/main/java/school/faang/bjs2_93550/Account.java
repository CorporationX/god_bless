package school.faang.bjs2_93550;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@EqualsAndHashCode
@Getter
@Slf4j
public class Account {
    private static long accountId = 0;
    private long id;
    private double balance;

    public Account(double balance) {
        ++accountId;
        id = accountId;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        log.info("На счет {} зачислены {} рублей", id, amount);
    }

    public synchronized boolean withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            log.info("Со счета {} списаны {} рублей", id, amount);
            return true;
        } else {
            log.info("На счету {} недостаточно средств. Остаток: {} рублей", id, balance);
            return false;
        }
    }
}
