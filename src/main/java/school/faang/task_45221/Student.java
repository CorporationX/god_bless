package school.faang.task_45221;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class Student {
    private int id;
    private String name;
    private static int indx;

    public Student(String name) {
        this.name = name;
        indx++;
        this.id = indx;
    }


}
