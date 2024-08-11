package faang.school.godbless.game_of_thrones;

import lombok.Data;
import lombok.NonNull;

@Data
public class House {
    @NonNull
    private final String name;
    private final String sigil;
}
