package school.faang.sprint3.mightandmagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Integer> powers = new ArrayList<>();
    Integer totalPower = 0;

    public <T> void addUnit(T obj) {
        int power = 0;
        if (obj instanceof Archer) {
            powers.add(((Archer)obj).getPower());
        } else if (obj instanceof Mage) {
            powers.add(((Mage)obj).getPower());
        } else if (obj instanceof Swordsman) {
            powers.add(((Swordsman)obj).getPower());
        }
    }

    public int calculateTotalPower() throws InterruptedException {

        for (int i = 0; i < powers.size(); i++) {
            try {
                final int a = i;
                Thread thread = new Thread(() -> totalPower += powers.get(a));
                thread.start();
                thread.join();
            } catch (Exception e) {
                System.out.println("Invalid process");
            }
        }
        return totalPower;
    }
}
