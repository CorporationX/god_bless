package faang.school.godbless.BJS2_23580;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Material {
    STRAW(4000L), STICKS(6000L), BRICKS(8000L);

    private long timeBuild;
}
