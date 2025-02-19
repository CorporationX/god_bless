package school.faang.sprint.third.army;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Squad {
    @NonNull
    private final String name;
    @NonNull
    private final List<Warrior> warriors;

    public Squad(@NonNull String name, @NonNull List<Warrior> warriors) {
        validateSquad(name);
        this.name = name;
        this.warriors = warriors;
    }

    public int calculateSquadPower() {
        return warriors.stream().mapToInt(Warrior::getPower).sum();
    }

    private void validateSquad(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Squad name cannot be blank");
        }
    }
}
