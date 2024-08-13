package faang.school.godbless.doubleCash;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
