package school.faang.bjs2_72141;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class Army {
    private List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    @SneakyThrows
    public Integer calculateTotalPower() {
        List<PowerCounterThread> threads = new ArrayList<>();
        this.squads.forEach(squad -> {
            var thread = new PowerCounterThread(squad);
            thread.start();
            threads.add(thread);
        });

        return threads.stream()
                .mapToInt(thread -> thread.handleJoin()
                        .getSquad()
                        .getTotalSquadPower())
                .sum();
    }
}
