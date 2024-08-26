package faang.school.godbless.MattersOfHeart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Chat {
    private int id;
    @EqualsAndHashCode.Exclude
    private User user1;
    @EqualsAndHashCode.Exclude
    private User user2;
}
