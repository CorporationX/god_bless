package faang.school.godbless.pigs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private final String pigName;
    private final String material;
}
