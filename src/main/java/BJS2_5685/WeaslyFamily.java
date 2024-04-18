package BJS2_5685;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeaslyFamily {
    public static void main(String[] args) {
        String[] chores = {"Что-то сделать1", "Что-то сделать2", "Что-то сделать3", "Что-то сделать4"};
        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.execute(new Chore(chore));
        }
        service.shutdown();
    }
}
