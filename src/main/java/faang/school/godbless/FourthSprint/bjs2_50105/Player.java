package faang.school.godbless.FourthSprint.bjs2_50105;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Builder
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

}
