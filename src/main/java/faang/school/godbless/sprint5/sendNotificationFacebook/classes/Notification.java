package faang.school.godbless.sprint5.sendNotificationFacebook.classes;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class Notification {
    private static int id = 0;
    private String message;

    public Notification(String message){
        this.message = message;
        ++id;
    }
}