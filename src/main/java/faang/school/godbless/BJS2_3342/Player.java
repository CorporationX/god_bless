package faang.school.godbless.BJS2_3342;

import lombok.Data;
import lombok.NonNull;

@Data
public class Player {
    @NonNull
    private String name;
    @NonNull
    private Integer level;
    @NonNull
    private Integer experience;
}
