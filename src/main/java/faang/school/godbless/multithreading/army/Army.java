package faang.school.godbless.multithreading.army;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Army {
    List<HeroThread> mageThreads = new ArrayList<>();
    List<HeroThread> swordsmanThreads = new ArrayList<>();
    List<HeroThread> archerThreads = new ArrayList<>();

    private List<Hero> heroes = new ArrayList<>();

    public int calculateTotalPower() {
        for (Hero hero : heroes) {
            if (hero.isArcher()) {
                HeroThread heroThread = new HeroThread(hero);
                mageThreads.add(heroThread);
                heroThread.start();
            } else if (hero.isSwordsman()) {
                HeroThread heroThread = new HeroThread(hero);
                swordsmanThreads.add(heroThread);
                heroThread.start();
            } else if (hero.isMage()) {
                HeroThread heroThread = new HeroThread(hero);
                archerThreads.add(heroThread);
                heroThread.start();
            }
        }
        int totalMagePower = 0;
        for (HeroThread thread : mageThreads) {
            try {
                thread.join();
                totalMagePower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int totalSwordsmanPower = 0;
        for (HeroThread thread : swordsmanThreads) {
            try {
                thread.join();
                totalSwordsmanPower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int totalArcherPower = 0;
        for (HeroThread thread : archerThreads) {
            try {
                thread.join();
                totalArcherPower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        return totalMagePower + totalSwordsmanPower + totalArcherPower;
    }
}
