package school.faang.task61218.army;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class Army {
    private List<Squad> allSquads = new ArrayList<>();
    private List<Thread> threadList = new ArrayList<>();
    private List<Integer> totalPower = new ArrayList<>();

    public void addSquad(Squad squad) {
        allSquads.add(squad);
    }

    public int calculateTotalPower() {
        for (Squad squad : allSquads) {
            Thread thread = new Thread(() -> totalPower.add(squad.calculateSquadPower()));
            threadList.add(thread);
            thread.start();
        }
        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("Произошла ошибка при ожидании завершения потока: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        return totalPower.stream()
                .mapToInt(power -> power).sum();
    }
}
