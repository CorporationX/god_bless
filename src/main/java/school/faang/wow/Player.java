package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;
}
