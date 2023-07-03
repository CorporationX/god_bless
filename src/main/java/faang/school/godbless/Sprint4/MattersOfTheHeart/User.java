package faang.school.godbless.Sprint4.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class User {
    private long id;
    private String name;
    private boolean isOnline = false;

    public void isOnlineOn() {
        isOnline = true;
    }

    public void isOnlineOff() {
        isOnline = false;
    }

    User(String name, long id) {
        this.name = name;
        this.id = id;
    }
}
