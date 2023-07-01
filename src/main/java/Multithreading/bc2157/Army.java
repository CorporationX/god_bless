package Multithreading.bc2157;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {

    List<HeroThread> archers = new ArrayList<>();
    List<HeroThread> mages = new ArrayList<>();
    List<HeroThread> swordsmans = new ArrayList<>();
    private final List<Hero> heroes;

    public Army(List<Hero> heroes) {
        this.heroes = heroes;
    }


    public int calculateTotalPower() throws InterruptedException {
        for (Hero hero : heroes) {
            if (hero.isArcher()) {
                startThreads(hero, archers);

            } else if (hero.isMage()) {
                startThreads(hero, mages);
            } else if (hero.isSwordsman()) {
                startThreads(hero, swordsmans);
            }
        }
        int archersPowers = powerHeroes(archers);
        int magesPowers = powerHeroes(mages);
        int swordsmanPowers = powerHeroes(swordsmans);

        System.out.println("Archers have power = " + archersPowers);
        System.out.println("Mages have power = " + magesPowers);
        System.out.println("Swordsmans have power = " + swordsmanPowers);

        return archersPowers + magesPowers + swordsmanPowers;
    }

    private void startThreads(Hero hero, List<HeroThread> heroes) {
        HeroThread heroThread = new HeroThread(hero);
        heroes.add(heroThread);
        heroThread.start();
    }

    private int powerHeroes(List<HeroThread> heroes) throws InterruptedException {
        int result = 0;
        for (HeroThread hero : heroes) {
            hero.join();
            result += hero.getPower();
        }
        return result;
    }
}
