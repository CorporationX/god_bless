package school.faang.m1s3.bjs2_35867_homm;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Calculator implements Runnable{
    private Creature creature;
    private Map<Creature, Integer> unitsPower;


    @Override
    public void run() {
        unitsPower.put(creature, creature.getPower());
        System.out.println("Thread #: " + Thread.currentThread().getId());

    }
}
