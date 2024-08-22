package Meta_Universe;

import lombok.Getter;
import lombok.Setter;

public class Notification {
    //Уведомления
    @Getter
    @Setter
    private String type; // тип
    @Getter
    @Setter
    private String message; // сообщение

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
