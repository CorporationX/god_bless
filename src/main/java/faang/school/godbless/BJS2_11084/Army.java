package faang.school.godbless.BJS2_11084;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Fighter> fighters;

    public Army(){
        fighters = new ArrayList<>();
    }

    public void addFighters(Fighter fighter){
        fighters.add(fighter);
    }

    public int calculateTotalPower(){
        AtomicInteger totalPower = new AtomicInteger();

        List<Thread> threads = new ArrayList<>();

        for(Fighter fighter : fighters){
            threads.add(new Thread(() ->
                    totalPower.getAndAdd(fighter.getPower())));
        }

        for(Thread thread : threads){
            thread.start();
        }

        for(Thread thread : threads){
            try{
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        return totalPower.get();
    }
}
