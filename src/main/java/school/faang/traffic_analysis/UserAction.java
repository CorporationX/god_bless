package school.faang.traffic_analysis;

import java.time.LocalDate;

public record UserAction(int id, String name, Enum actionType, LocalDate actionDate, String content) {}

/*@AllArgsConstructor
public class UserAction {
    id юзера (целое число);
    name юзера (строка);
    actionType (перечисление, возможные значения: POST, COMMENT, LIKE, SHARE);
    actionDate — дата действия (LocalDate);
    content — текст поста или комментария (строка).

    private ;
    private String name;
    private Enum actionType;
    private LocalDate actionDate;
    private String content;
}*/
