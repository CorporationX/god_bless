package faang.school.godbless.MattersOfTheHeart;

import lombok.Data;

@Data
public class User {
    private String name;
    private boolean isOnline;

    public User(String name) {
        this.name = name;
        isOnline = true;
    }
}
