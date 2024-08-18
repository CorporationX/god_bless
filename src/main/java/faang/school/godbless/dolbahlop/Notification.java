package faang.school.godbless.dolbahlop;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Notification {

    private String type;
    private String message;
    private CensorshipManager censorshipManager;

    public Notification(String type, String message, CensorshipManager censorshipManager) {
        this.type = type;
        this.message = censorshipManager.censorBadWords(message.split(" "));
        this.censorshipManager = censorshipManager;
    }
}
