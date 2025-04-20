package school.faang.heroes;

import java.util.List;

public class Squad<T extends Fighter> {
    private final List<T> squad;

    public Squad(List<T> squad) {
        if (squad == null || squad.isEmpty()) {
            throw new IllegalArgumentException("Список бойцов не может быть пустым");
        }
        this.squad = squad;
    }

    public int calculateSquadPower() {
        return squad.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
