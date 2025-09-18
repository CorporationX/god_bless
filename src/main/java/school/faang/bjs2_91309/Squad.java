package school.faang.bjs2_91309;

import java.util.ArrayList;
import java.util.List;

public class Squad {

    List<Warrior> warriors = new ArrayList<>();

    public Squad(String warrior, List<Warrior> warriorsList) {
        warriors.addAll(warriorsList);
    }

    public int calculateSquadPower() {

        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
