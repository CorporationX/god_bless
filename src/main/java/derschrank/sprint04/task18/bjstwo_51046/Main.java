package derschrank.sprint04.task18.bjstwo_51046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNT_OF_ACCOUNTS = 1000;
    private static final int DEFAULT_DEPOSIT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank();

        List<Account> listOne = new ArrayList<>();
        List<Account> listTwo = new ArrayList<>();
        generateTwoListOfAccounts(listOne, listTwo, bank);

        System.out.println("ORIGINAL ACCOUNTS");
        bank.printAllAccounts();
        System.out.println("Total Balance in Bank: " + bank.getTotalBalance());

        processAccounts(listOne, listTwo, bank);

        System.out.println("PROCESSED ACCOUNTS");
        bank.printAllAccounts();
        System.out.println("Total Balance in Bank: " + bank.getTotalBalance());


    }

    private static void generateTwoListOfAccounts(List<Account> listOne, List<Account> listTwo, Bank bank) {
        List<CompletableFuture<Void>> futures = new LinkedList<>();

        for (int i = 0; i < COUNT_OF_ACCOUNTS; i++) {
            final int id = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                                    () -> new Account(id * 2)
                            )
                            .thenCompose(account ->
                                    CompletableFuture.runAsync(
                                            () -> {
                                                addAccountToList(account, listOne);
                                                account.deposit(DEFAULT_DEPOSIT);
                                                bank.addAccount(account);
                                            }
                                    ))
            );

            futures.add(
                    CompletableFuture.supplyAsync(
                                    () -> new Account(id * 2 + 1)
                            )
                            .thenCompose(account ->
                                    CompletableFuture.runAsync(
                                            () -> {
                                                addAccountToList(account, listTwo);
                                                bank.addAccount(account);
                                            }
                                    ))
            );
        }

        futures.forEach(CompletableFuture::join);
    }

    private static void processAccounts(List<Account> listOne, List<Account> listTwo, Bank bank) {
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (int i = 0; i < listOne.size(); i++) {
            final int n = i;
            futures.add(CompletableFuture.runAsync(
                    () -> bank.transfer(listOne.get(n).id(), listTwo.get(n).id(), 200)));
            futures.add(CompletableFuture.runAsync(
                    () -> bank.transfer(listTwo.get(n).id(), listOne.get(n).id(), 100)));
            futures.add(CompletableFuture.runAsync(
                    () -> bank.transfer(listOne.get(n).id(), listTwo.get(n).id(), 250)));
            futures.add(CompletableFuture.runAsync(
                    () -> bank.transfer(listTwo.get(n).id(), listOne.get(n).id(), 150)));
            futures.add(CompletableFuture.runAsync(
                    () -> bank.transfer(listOne.get(n).id(), listTwo.get(n).id(), 350)));
            futures.add(CompletableFuture.runAsync(
                    () -> bank.transfer(listTwo.get(n).id(), listOne.get(n).id(), 250)));
        }
        futures.forEach(CompletableFuture::join);
    }

    private static void addAccountToList(Account account, List<Account> list) {
        synchronized (list) {
            list.add(account);
        }
    }
}
