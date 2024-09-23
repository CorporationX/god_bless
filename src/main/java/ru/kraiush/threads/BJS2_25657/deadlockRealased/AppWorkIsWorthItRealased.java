package ru.kraiush.threads.BJS2_25657.deadlockRealased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppWorkIsWorthItRealased {

    public static void main(String[] args) {

        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        String[] arr1= {"pizza", "apple", "pineapple", "pear", "beer", "banana", "grape", "candy", "chocolate", "durian"};
        String[] arr2= {"shovel", "hammer", "rake", "pliers", "scissors", "glue", "saw", "file", "hacksaw", "sickle"};;
        List<String> listDesignFiles = new ArrayList<>();
        List<String> listMarketingFiles = new ArrayList<>();

        listDesignFiles.addAll(Arrays.asList(arr1));
        listMarketingFiles.addAll(Arrays.asList(arr2));

        Thread thread1= new Thread(new DesignResources(lock1, lock2, listDesignFiles, listMarketingFiles));
        Thread thread2= new Thread(new MarketingResources(lock1, lock2, listMarketingFiles, listDesignFiles));

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();
        listDesignFiles.forEach(System.out::println);
        System.out.println();
        listMarketingFiles.forEach(System.out::println);
    }
}
