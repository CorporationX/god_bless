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
public class MarketingResources {

    List<String> listMarketing = new ArrayList<>();
    DesignResources resource1;

    public MarketingResources(List<String> listMarketing) {
        this.listMarketing = listMarketing;
    }

    private void addFile(File file) {
        listMarketing.add(file.getName());
    }

    public void thread2Work(DesignResources resource1) {
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    synchronized (resource1) {
                        System.out.println("resource2: " + resource1.getListDesigns().get(0) +  " - " + listMarketing.get(0));
                    }
                }
            }
        });
        t2.start();
    }
}
