package school.faang.send_a_raven.main_code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() > 0.5) {
            throw new Exception("не удалось доставить сообщение из " + name + " в " + receiver.getName());
        }
        return "Сообщение успешно доставлено из " + name + " в " + receiver.getName();
    }
}
