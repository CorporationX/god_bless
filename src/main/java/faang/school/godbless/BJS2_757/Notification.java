package faang.school.godbless.BJS2_757;

import lombok.Getter;

@Getter
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
    public String toString(){
        return getType()+getMessage();
    }
}
