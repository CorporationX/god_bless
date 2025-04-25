package school.faang.bjs2_72588;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Army {
    private List<Squad> squads = new ArrayList<>();

    public void setSquads(List<Squad> squads) {
        if (squads != null) {
            this.squads = squads;
        } else {
            this.squads = new ArrayList<>();
        }
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> sqadsPowers = Collections.synchronizedList(new ArrayList<>());
        
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                sqadsPowers.add(squad.calculateSquadPower());
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("The thread was interrupted. {}.", e.getMessage());
            }
        }

        return sqadsPowers.stream().mapToInt(Integer::intValue).sum();
    }
}
