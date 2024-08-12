package faang.school.godbless.BJS2_19882;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Subject {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Subject id:" + id + ", name:" + name;
    }
}
