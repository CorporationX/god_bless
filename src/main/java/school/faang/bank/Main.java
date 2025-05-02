package school.faang.bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Account acc1 = new Account(1, 1000.0);
        Account acc2 = new Account(2, 0.0);
        Account acc3 = new Account(3, 4000.0);
        Account acc4 = new Account(4, 4000.0);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.addAccount(acc4);

        ThreadPullProvider.executor.execute(() -> bank.transfer(1, 2, 1000));
        ThreadPullProvider.executor.execute(() -> bank.transfer(3, 2, 1000));
        ThreadPullProvider.executor.execute(() -> bank.transfer(4, 2, 1000));
        ThreadPullProvider.executor.execute(() -> bank.transfer(3, 1, 1000));
        ThreadPullProvider.executor.execute(() -> bank.transfer(4, 1, 1000));

        ThreadPullProvider.executor.shutdown();
        while (!ThreadPullProvider.executor.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("acc1 " + acc1.getBalance());
        System.out.println("acc2 " + acc2.getBalance());
        System.out.println("acc3 " + acc3.getBalance());
        System.out.println("acc4 " + acc4.getBalance());
        System.out.println("Общий баланс всех счетов: " + bank.getTotalBalance());
    }
}
