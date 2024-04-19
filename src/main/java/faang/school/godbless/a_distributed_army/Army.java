package faang.school.godbless.a_distributed_army;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {

    public Army() {
        this.allArmy = new ArrayList<>();
    }

    private List<Fighters> allArmy;


    public int calculateTotalPower(){
        int[] totalPower = {0};

        for (Fighters fighters:allArmy){
            Thread thread = new Thread(() ->
                    totalPower[0] += fighters.getPower());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower[0];
    }

    public void addUnit(Fighters fighters){
        allArmy.add(fighters);
    }
}
