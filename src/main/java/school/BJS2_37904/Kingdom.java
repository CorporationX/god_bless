package school.BJS2_37904;

import lombok.Getter;
import java.util.Random;

@Getter
public class Kingdom {

    private String name;
    private Random rand = new Random();

    public Kingdom(String name) {
        this.name = name;
    }

    public String sendMessage(Kingdom receiver, String message) throws Exception {
        if (rand.nextBoolean()) {
            return "Сообщение \"" + message + "\" было отправлено из королевства: " + name;
        } else {
            throw new Exception("Произошла ошибка при отправке сообщения");
        }
    }

}
