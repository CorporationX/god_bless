package faang.school.godbless.javaHashMap.gameOfTrones;

import lombok.Data;
import lombok.NonNull;

@Data
public class House {
    @NonNull
    private String name;
    @NonNull
    private String sigil;
}