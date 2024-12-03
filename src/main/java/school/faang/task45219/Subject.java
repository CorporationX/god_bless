package school.faang.task45219;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Subject {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Предмет: "
                + "id=" + id
                + ", name='" + name + '\'';
    }
}
