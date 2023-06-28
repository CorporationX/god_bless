package faang.school.godbless.armyOfHOMM;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class Army {
    List<Character> characters;

    public int calculatePower() {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threadList = new ArrayList<>();

        for (Character character : characters) {
            Thread thread = new Thread(() -> {
                totalPower.addAndGet(character.getPower());
            });
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

         return totalPower.get();
    }
}
