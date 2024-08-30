package faang.school.godbless.FacebookSpam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private static int lastFreeId = 1;
    private int id;
    private String title;

    public Notification(String title) {
        this.title = title;
        id = lastFreeId++;
    }
}
