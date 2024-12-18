package school.faang.task_46491;

import lombok.Data;

@Data
public class Image {
    private String name; // (имя файла),

    private String description; // (описание, которое обновляется с каждым применённым фильтром).

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
