package com.multithreading.family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {

        String[] chores = {"Стирка", "Уборка", "Готовка"};

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (String chore : chores) {
            if (!chore.isEmpty() && !chore.isBlank()) {
                service.execute(new Chore(chore));
            }
        }
        service.shutdown();
    }
}
