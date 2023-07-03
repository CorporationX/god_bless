package faang.school.godbless.pathOfFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Monster {
    @NonNull
    private String name;
    @NonNull
    private String location;
}
