package faang.school.godbless.distributedArmy;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Army {
    private List<Warrior> listOfAllWarriors = new ArrayList<>();

    public int calculateTotalPower(){
        List<Integer> amountOfWarriors = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (Warrior warrior : listOfAllWarriors){
            synchronized (this) {
                service.submit(() -> amountOfWarriors.add(warrior.getPower()));
            }
        }
        return amountOfWarriors.stream().reduce(0, Integer::sum);
    }

    public void addUnit(Warrior warrior){
        listOfAllWarriors.add(warrior);
    }
}
