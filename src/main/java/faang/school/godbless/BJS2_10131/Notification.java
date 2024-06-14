package faang.school.godbless.BJS2_10131;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class Notification {
    private String type;
    private String message;
    public Notification(String type, String message) {
        if(type.isBlank()){
            System.out.println("Используй корректный тип сообщения");
            return;
        }
        this.type = type;
        if(message.isBlank()){
            System.out.println("Используй корректное сообщение");
            return;
        }
        this.message = message;
    }

}
