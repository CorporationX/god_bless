package ru.kraiush.threads.BJS2_25657.deadlock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DesignResources {

    List<String> listDesigns = new ArrayList<>();
    MarketingResources resource2;

    public DesignResources(List<String> listDesigns) {
        this.listDesigns = listDesigns;
    }

    private void addFile(File file) {
        listDesigns.add(file.getName());
    }

    public void thread1Work(MarketingResources resource2) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    synchronized (resource2) {
                        System.out.println("resource1: " + listDesigns.get(0) + " - " + resource2.getListMarketing().get(0));
                    }
                }
            }
        });
        t1.start();
    }
}
