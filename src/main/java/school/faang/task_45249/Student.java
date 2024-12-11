package school.faang.task_45249;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name; // Выводим только имя студента
    }
}
