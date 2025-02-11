package university;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Student {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
