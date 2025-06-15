package school.faang.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter // Lombok аннотация - автоматически генерирует getter методы для всех полей
@AllArgsConstructor  // Lombok аннотация - автоматически генерирует конструктор со всеми параметрами
public class Subject {
    // Поле для хранения имени студента
    private String name;
}
