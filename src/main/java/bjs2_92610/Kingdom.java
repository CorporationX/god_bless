package bjs2_92610;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Kingdom {
    private final String name;
    private static final double PROBABILITY_OF_ERROR = 0.3;

    public String sendMessage(Kingdom receiver) {
        if (Math.random() < PROBABILITY_OF_ERROR) {
            throw new RuntimeException("Ворон не смог доставить сообщение из "
                    + name + " в " + receiver.getName());
        }
        return "Сообщение успешно доставлено из " + name + " в " + receiver.getName();
    }
}