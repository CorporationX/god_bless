package BJS2_25265_PlayBank;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Setter
@AllArgsConstructor
@Slf4j
public class Account {
    private volatile double balance;
    private static final ReentrantLock lock = new ReentrantLock();

    public void deposit(double cash){
        lock.lock();
        try {
            this.setBalance(this.getBalance() + cash);

            log.info("deposit Total balance of receiver after transfer is : {}", this.getBalance());
        }
        finally {
            lock.unlock();
        }
    }

    public void withDraw(double cash){
        lock.lock();
        try {
            this.setBalance(this.getBalance() - cash);
            log.info("withdraw Total balance of sender after transfer is: {}", this.getBalance());
        }
        finally {
            lock.unlock();
        }
    }

    public double getBalance(){
        lock.lock();
        try {
            return balance;
        }
        finally {
            lock.unlock();
        }
    }
}
