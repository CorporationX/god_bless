package school.faang.future_completable_future.bjs2_92579;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private long level;
    private long experience;

    public synchronized <T extends Number> void addExperience(T experience) {
        this.experience += experience.longValue();
    }
}