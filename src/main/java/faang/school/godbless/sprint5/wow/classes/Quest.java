package faang.school.godbless.sprint5.wow.classes;

import faang.school.godbless.sprint5.wow.enums.Difficult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private Difficult difficult;
    private int reward;
}
