package school.faang.bjs2_91314;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Army {

    private final List<Squad> army;

    private void calculateTotalPower() {
        final List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < army.size(); i++) {
            Thread thread = new Thread();
            thread.start();
            threads.add(thread);
        }
    }
}
