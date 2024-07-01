package faang.school.godbless.multithreading.async.wow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Player {
    @NonNull
    private String name;
    private int level;
    private int experience;
}
