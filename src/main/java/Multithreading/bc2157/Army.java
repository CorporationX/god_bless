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
                archers.add(new HeroThread(hero));
            } else if (hero.isMage()) {
                mages.add(new HeroThread(hero));
            } else if (hero.isSwordsman()) {
                swordsmans.add(new HeroThread(hero));
            }
        }
        int archersPowers = powerHeroes(archers);
        int magesPowers = powerHeroes(mages);
        int swordsmanPowers = powerHeroes(swordsmans);

        return archersPowers + magesPowers + swordsmanPowers;
    }

    private int powerHeroes(List<HeroThread> heroes) throws InterruptedException {
        int result = 0;
        for (HeroThread hero : heroes) {
            hero.start();
            hero.join();
            result += hero.getPower();
        }
        return result;
    }
}
