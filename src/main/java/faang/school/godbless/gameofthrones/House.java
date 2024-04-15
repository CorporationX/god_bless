package faang.school.godbless.gameofthrones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class House {
    private final String name;
    private final String sigil;
}
