package faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class Army {
    private final List<HeroesSquad> heroesSquads = new ArrayList<>();

    public void addSquad(HeroesSquad heroesSquad) {
        heroesSquads.add(heroesSquad);
    }

    public int calculateArmyPower()
    {
        List<Integer> squadPowers = Collections.synchronizedList(new ArrayList<>());
        List<Thread> calculationThreads = new ArrayList<>();

        for (HeroesSquad squad : heroesSquads) {
            calculationThreads.add(new Thread(() -> squadPowers.add(squad.getSquadPower())));
        }

        for (Thread thread : calculationThreads) {
            thread.start();
        }

        for (Thread thread : calculationThreads) {
            try {
                thread.join();
                System.out.println("done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return squadPowers.stream()
                .reduce(0, Integer::sum);
    }
}
