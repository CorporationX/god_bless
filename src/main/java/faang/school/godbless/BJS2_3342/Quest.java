package faang.school.godbless.BJS2_3342;

import lombok.Data;
import lombok.NonNull;

@Data
public class Quest {
    @NonNull
    private String name;
    @NonNull
    private Integer difficulty;
    @NonNull
    private Integer reward;
}
