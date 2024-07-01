package faang.school.godbless.multithreading.async.wow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Quest {
    @NonNull
    private String name;
    private int difficulty;
    private int reward;
}
