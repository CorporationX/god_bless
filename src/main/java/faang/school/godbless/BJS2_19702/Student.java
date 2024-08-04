package faang.school.godbless.BJS2_19702;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Student {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Student" +
                "id: " + id +
                ", name:" + name;
    }
}
