package school.faang.bjs2_92547;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Getter
@AllArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
