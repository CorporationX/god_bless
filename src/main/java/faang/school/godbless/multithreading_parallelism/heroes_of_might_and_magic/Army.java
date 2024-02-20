package faang.school.godbless.multithreading_parallelism.heroes_of_might_and_magic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    public List<Character> listCharacter = new ArrayList<>();

    public void addUnit(Character character) {
        listCharacter.add(character);
    }

    public int calculateTotalPower() {
        List<ThreadForHeroes> threadList = new ArrayList<>();
        int sumPower = 0;
        for (int i = 0; i < listCharacter.size(); i++) {
            ThreadForHeroes thread = new ThreadForHeroes(listCharacter.get(i));
            thread.start();
            threadList.add(thread);
        }
        for (ThreadForHeroes thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sumPower += thread.getPower();
        }
        return sumPower;
    }

}
