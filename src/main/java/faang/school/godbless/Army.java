package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Hero> heroes = new ArrayList<>();

    public void addUnit(Hero hero){
        heroes.add(hero);
    }

    public int calculateTotalPower(){
        int totalPower = 0;
        List<PowerCalculatorThread> threads = new ArrayList<>();
        for (Hero hero : heroes){
            PowerCalculatorThread thread = new PowerCalculatorThread(hero);
            thread.start();
            threads.add(thread);
        }
        for (PowerCalculatorThread thread : threads){
            try {
                thread.join();
                totalPower += thread.getHeroPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }

    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
