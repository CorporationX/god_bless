package school.faang.task_47726;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Fighter> army = new ArrayList<>();

    public void addFighter(Fighter fighter) {
        army.add(fighter);
    }

    public int calculateTotalPower() {
        List<Calculate> threadList = new ArrayList<>();
        army.stream().forEach((fighter) -> {
            Calculate calculate = new Calculate(fighter, fighter.power);
            threadList.add(calculate);
            calculate.thread.start();
        });
        threadList.stream().forEach((thread) -> {
            try {
                thread.join();
                System.out.println(String.format("Thread %s has finished work", thread.getThread()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return threadList.stream().map(thread -> thread.getPower()).reduce(Integer::sum).orElse(0);
    }
}
