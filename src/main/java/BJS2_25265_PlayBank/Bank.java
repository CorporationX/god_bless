package BJS2_25265_PlayBank;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(Account accountFrom, Account accountTo, double sumToSend) {
        log.info("Transferring...");
        if (accountFrom.getBalance() < sumToSend) {
            log.error("Not enough money to transfer! {} < {}", accountFrom.getBalance(), sumToSend);
            return false;
        }
        log.info("Operation successful! {} > {}", accountFrom.getBalance(), sumToSend);
        accountFrom.withDraw(sumToSend);
        accountTo.deposit(sumToSend);
        return true;
    }
}
