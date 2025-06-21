package school.faang.army_of_heroes_of_might_and_magic_bjs2_81149;

import java.util.List;

public class Army {
    private List<Squad> squadList;

    public int calculateTotalPower() {


        return squadList.stream()
                .mapToInt(Squad::calculateSquadPower)
                .sum();
    }

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }
}
