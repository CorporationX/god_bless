package school.faang.sprint.fourth.mages;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Task {
    @NonNull
    private String name;
    private int difficult;
    private int reward;

    public Task(@NonNull String name, int difficult, int reward) {
        validateData(name, difficult, reward);
        this.name = name;
        this.difficult = difficult;
        this.reward = reward;
    }

    private void validateData(@NonNull String name, int year, int points) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be greater than zero");
        }
        if (points < 0) {
            throw new IllegalArgumentException("Points must be greater than zero");
        }
    }
}