package school.faang.harryPotter;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.naming.Name;

@Data
@RequiredArgsConstructor
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
