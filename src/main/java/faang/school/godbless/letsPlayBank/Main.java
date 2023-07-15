package faang.school.godbless.letsPlayBank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 18000);
        Account account3 = new Account(3, 200);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                long threadId = Thread.currentThread().getId();

                int fromAccountId = (int) (Math.random() * 3) + 1;
                int toAccountId = (int) (Math.random() * 3) + 1;
                double amount = Math.random() * 500;

                boolean success = bank.transfer(fromAccountId, toAccountId, amount);

                if (success) {
                    System.out.println("ID " + threadId + ": перевод успешно выполнен");
                } else {
                    System.out.println("ID " + threadId + ": недостаточно средств на счете");
                }
            }).start();
        }
    }

}
