package Army_of_heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Hero> heroes;

    public Army() {
        heroes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public int calculateTotalPower(){
        int totalPower = 0;
        List<PowerCalculatorThread> threads = new ArrayList<>();
        for (Hero hero: heroes){
            PowerCalculatorThread thread = new PowerCalculatorThread(hero);
            thread.start();
            threads.add(thread);
        }
        for (PowerCalculatorThread thread:threads){
            try {
                thread.join();
                totalPower += thread.getHeroPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
