package faang.school.godbless.Metaverse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}

