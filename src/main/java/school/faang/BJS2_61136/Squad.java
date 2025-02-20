package school.faang.BJS2_61136;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Squad<T extends Warrior> {

    private final List<T> warriors;

    public Squad(@NonNull List<T> warriors) {
        this.warriors = warriors;
    }

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
