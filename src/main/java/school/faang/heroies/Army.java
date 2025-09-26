package school.faang.heroies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SuppressWarnings("checkstyle:CommentsIndentation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Army {
    private List<Squad> squads = new ArrayList<>();
    private int totalPower;

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }

/*
   public int calculateTotalPower() {

   squads.forEach(squad -> totalPower += squad.getTotalSquadPower());
        return totalPower;
    }
*/

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
