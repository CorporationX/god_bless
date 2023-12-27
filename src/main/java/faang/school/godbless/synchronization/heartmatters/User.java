package faang.school.godbless.synchronization.heartmatters;

import lombok.*;

@Getter
@EqualsAndHashCode(exclude = {"isOnline", "isAvailable"})
@ToString
public class User {

    private final int id;
    private final String name;
    @Setter
    private boolean isOnline;
    @Setter
    private boolean isAvailable;

    public User(int id, String name, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.isOnline = isOnline;
        this.isAvailable = true;
    }

}
