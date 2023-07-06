package faang.school.godbless.Sprint4.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Chat {
    private User first;
    private User second;
    private String chatName;

}
