package faang.school.godbless.sprint4.bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Account account1 = new Account(1, 100);
        Account account2 = new Account(2, 200);
        bank.addAccount(account1);
        bank.addAccount(account2);

        Runnable transferTask = () -> {
            int fromId = 1;
            int toId = 2;
            int amount = 50;
            boolean success = bank.transfer(fromId, toId, amount);
            if (success) {
                System.out.println("Transfer from account " + fromId + " to account " + toId + " was successful: " + amount);
            } else {
                System.out.println("Transfer from account " + fromId + " to account " + toId + " failed: not enough balance");
            }
        };

        Thread thread1 = new Thread(transferTask);
        Thread thread2 = new Thread(transferTask);
        Thread thread3 = new Thread(transferTask);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Total balance: " + bank.getTotalBalance());
    }
}
