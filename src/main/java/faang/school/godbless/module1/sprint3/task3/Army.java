package faang.school.godbless.module1.sprint3.task3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Characters> army;
    private final List<ArmyThread> armyThreads;

    public Army(){
        this.army = new ArrayList<>();
        this.armyThreads = new ArrayList<>();
    }


    public int calculateTotalPower() throws InterruptedException {


        for (Characters characters : army) {
            ArmyThread armyThread = new ArmyThread(characters);
            armyThread.start();
            armyThreads.add(armyThread);
            armyThread.join();
            System.out.println(armyThread.isAlive());
        }


        return armyThreads.stream()
                .mapToInt(ArmyThread::getPower)
                .sum();
    }
    public void addUnit(Characters characters){
        army.add(characters);
    }


}

