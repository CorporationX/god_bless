package com.multitheading.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Knight ludwig =  new Knight("Ludwig");
        Knight richard = new Knight("Richard");

        ludwig.addTrial(new Trial("Сражение на мечах", ludwig.getName()));
        ludwig.addTrial(new Trial("Сражение на копьях", ludwig.getName()));

        richard.addTrial(new Trial("Сразиться со львом", richard.getName()));
        richard.addTrial(new Trial("Пройти через крокодилов", richard.getName()));


        ExecutorService service = Executors.newFixedThreadPool(2);
        richard.startTrial(service);
        ludwig.startTrial(service);
        service.shutdown();


    }
}
