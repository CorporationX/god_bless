package school.faang.bjs2_72141;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class Army {
    private final List<Squad> squads;

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public Integer calculateTotalPower(List<Squad> squads) {
        squads.forEach(squad ->
                new PowerCounterThread(squad).start()
        );
    }
}
