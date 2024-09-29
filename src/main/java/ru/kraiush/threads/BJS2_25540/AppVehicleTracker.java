package ru.kraiush.threads.BJS2_25540;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.*;
import java.util.List;

public class AppVehicleTracker {

    public static void main(String[] args) {

        List<Vehicle> listVehicles= new ArrayList<>();
        TransportManagementSystem manager= new TransportManagementSystem(listVehicles);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        System.out.print(String.join("", Collections.nCopies(115, "-")));
        System.out.println();
        manager.add(listVehicles);
        manager.add(listVehicles);
        manager.add(listVehicles);

        for(int i=0; i< listVehicles.size(); i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Vehicle worker = listVehicles.get(i);
            scheduledThreadPool.schedule(worker, 1, TimeUnit.SECONDS);
        }
        scheduledThreadPool.schedule(manager, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
    }
}
