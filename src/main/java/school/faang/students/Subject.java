package school.faang.students;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private String name;

    @Override
    public String toString() {
        return "Предмет " + this.getName();
    }
}

