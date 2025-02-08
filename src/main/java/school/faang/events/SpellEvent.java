package school.faang.events;

import lombok.Data;

@Data
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
//Не знаю, после "ОШЫБКИ" нужно повторно все файлы коммитить?
//Если да, то как в них задать изменение, специально добавляю комментарий, чтобы можно было закоммитить