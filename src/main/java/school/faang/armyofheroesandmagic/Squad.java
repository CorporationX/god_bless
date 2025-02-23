package school.faang.armyofheroesandmagic;

import java.util.List;

public class Squad {
    private final String name;
    private final List<Soldier> soldiers;

    public Squad(String name, List<Soldier> soldiers) {
        this.name = name;
        this.soldiers = soldiers;
    }

    public int calculateSquadPower() {
        return soldiers.stream()
                .mapToInt(Soldier::getPower).sum();
    }

}
