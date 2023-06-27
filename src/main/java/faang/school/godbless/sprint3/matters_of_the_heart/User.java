package faang.school.godbless.sprint3.matters_of_the_heart;

import lombok.Data;

@Data
public class User {
    private String name;
    private boolean isOnline;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }
}
