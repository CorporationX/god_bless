package faang.school.godbless.sprint_3.multithreading.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Character> departments = new ArrayList<>();

    public int calculateTotalPower() {
        List<NumberHolder> threads = new ArrayList<>();
        int result = 0;
        for (Character character : departments) {
            NumberHolder holder = new NumberHolder(character);
            threads.add(holder);
            holder.start();
            try {
                holder.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (NumberHolder holder : threads) {
            result += holder.getPower();
        }
        return result;
    }

    public void addUnit(Character character) {
        departments.add(character);
    }
}
