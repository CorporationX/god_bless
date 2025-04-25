package school.faang.army.army;

import school.faang.army.model.Division;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Division> divisions;

    public Squad(List<Division> divisions) {
        this.divisions = divisions != null ? divisions : new ArrayList<>();
    }

    public int calculateSquadPower() {
        return divisions.stream().mapToInt(Division::getPower).sum();
    }
}