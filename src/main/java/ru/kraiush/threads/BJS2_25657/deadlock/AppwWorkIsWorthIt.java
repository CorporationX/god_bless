package ru.kraiush.threads.BJS2_25657.deadlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppwWorkIsWorthIt {

    public static void main(String[] args) {

        String[] arr1= {"pizza", "apple", "pineapple", "pear", "beer"};
        String[] arr2= {"banana", "grape", "candy", "chocolate", "durian"};
        List<String> listDesignFiles = new ArrayList<>();
        List<String> listMarketingFiles = new ArrayList<>();

        listDesignFiles.addAll(Arrays.asList(arr1));
        listMarketingFiles.addAll(Arrays.asList(arr2));

        AppwWorkIsWorthIt app= new AppwWorkIsWorthIt();
        DesignResources resource1 = new DesignResources(listDesignFiles);
        MarketingResources resource2 = new MarketingResources(listMarketingFiles);

        resource1.thread1Work(resource2);
        resource2.thread2Work(resource1);
    }
}
