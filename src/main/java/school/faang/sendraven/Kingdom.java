package school.faang.sendraven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private static final double CHANCE_ERROR = 0.3;
    private String name;

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < CHANCE_ERROR) {
            throw new Exception("Ворон не смог доставить сообщение из " + name + " в " + receiver.getName());
        }
        return "Сообщение успешно доставлено из " + name + " в " + receiver.getName();
    }
}
