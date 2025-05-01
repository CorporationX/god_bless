package school.faang.bjs2_75935;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Comment {
    private String text; // текст комментария
    private final Author author; // автор комментария,
    private final LocalDateTime timestamp; // дата и время создания комментария (тип LocalDateTime).
    //Создайте конструктор и методы getters для этих полей.
}
