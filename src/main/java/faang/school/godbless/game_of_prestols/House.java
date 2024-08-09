package faang.school.godbless.game_of_prestols;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class House {
    @NonNull private String name;
    @NonNull private String sigil;
}
