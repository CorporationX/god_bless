package school.faang.BJS2_35955;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    public static AtomicInteger armyPower = new AtomicInteger(0);
    List<Warrior> army = new ArrayList<>();
    private final int armySize = 50;

    Army(){
        Random rand = new Random();

        for (int i=0; i<armySize; i++ ){
            int x = rand.nextInt(4);
            switch (x){
                case 1:
                    army.add(new Swordsman(armyPower));
                    break;
                case 2:
                    army.add(new Archer(armyPower));
                    break;
                case 3:
                    army.add(new Mage(armyPower));
                    break;
            }
        }
    }

    public int getArmyPower(){
        return armyPower.get();
    }

    public void calculateTotalPower(){
        List<Thread> threads = new ArrayList<>();
        for (Warrior w : army){
            Thread t = new Thread(w);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
