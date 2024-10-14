package school.BJS2_35851;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Character> characters = new ArrayList<Character>();

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;

        List<PowerArmy> powerArmyList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();

        for (Character character : characters) {
            PowerArmy powerArmy = new PowerArmy(character);
            powerArmyList.add(powerArmy);
            Thread thread = new Thread(powerArmy);
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        for (PowerArmy powerArmy : powerArmyList) {
            totalPower += powerArmy.getPower();
        }
        return totalPower;
        }
}


