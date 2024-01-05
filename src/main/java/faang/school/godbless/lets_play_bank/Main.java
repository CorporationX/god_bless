package faang.school.godbless.lets_play_bank;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {
        Bank bank = new Bank();
        fillingTheBank(bank);
        try {
            for (int i = 0; i < 3; i++) {
                startTransfer(bank);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void fillingTheBank(Bank bank) {
        Account account = new Account(1, 1542432L);
        Account account2 = new Account(2, 40000L);
        Account account3 = new Account(3, 445900L);
        Account account4 = new Account(4, 3456123L);
        Account account5 = new Account(5, 187984L);
        Account account6 = new Account(6, 354189L);
        bank.getAccounts().put(account.getId(), account);
        bank.getAccounts().put(account2.getId(), account2);
        bank.getAccounts().put(account3.getId(), account3);
        bank.getAccounts().put(account4.getId(), account4);
        bank.getAccounts().put(account5.getId(), account5);
        bank.getAccounts().put(account6.getId(), account6);
    }

    private static void startTransfer(Bank bank) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Account sourceAccount = bank.getAccounts().get(random.nextInt(1, bank.getAccounts().size()));
            Account targetAccount = bank.getAccounts().get(random.nextInt(1, bank.getAccounts().size()));
            long transferAmount = random.nextLong(1500000L);
            bank.transfer(sourceAccount, targetAccount, transferAmount);
            bank.getTotalBalance(bank.getAccounts());// вот не знаю, нужен ли он после каждой операции, пока так
        });
        thread.start();
        thread.join();
    }
}
