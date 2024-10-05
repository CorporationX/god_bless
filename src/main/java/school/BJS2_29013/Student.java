package school.BJS2_29013;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {

    private String name;
    private String facultat;
    private int year;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", facultat='" + facultat + '\'' +
                ", year=" + year +
                '}';
    }
}
