package faang.school;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Student {
    @NonNull
    private String name;
    @NonNull
    private Integer year;
    private int points = 0;
    public void updatePoints(int reward) {
        points+=reward;
    }
}
