package school.faang.task_45221;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subject {
    private int id;
    private String name;
    private static int indx;

    public Subject(String name) {
        this.name = name;
        indx++;
        this.id = indx;
    }

}
