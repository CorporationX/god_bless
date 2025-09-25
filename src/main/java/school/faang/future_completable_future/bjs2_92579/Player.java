package school.faang.future_completable_future.bjs2_92579;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    @Setter
    private long level;
    @Setter
    private long experience;

    public  <T extends Number> void addExperience(T experience) {
        this.experience += experience.longValue();
    }
}