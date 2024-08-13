package faang.school.godbless.doubleCash;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
