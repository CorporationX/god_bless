package faang.school.godbless.sprint3.mattersOfTheHeart;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class User {
    private long id;
    private String name;
    @Setter
    private boolean isOnline;
}
