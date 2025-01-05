package school.faang.task_48496;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Army {
    private List<Hero> heroes = new ArrayList<>();

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (Hero hero : heroes) {
            Thread thread = new Thread(() -> {
                synchronized (results) {
                    results.add(hero.getPower());
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }

}