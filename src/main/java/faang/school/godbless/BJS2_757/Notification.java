package faang.school.godbless.BJS2_757;

import lombok.Getter;

@Getter
class Notification{
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}