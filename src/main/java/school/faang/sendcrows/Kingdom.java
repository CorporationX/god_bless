package school.faang.sendcrows;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Kingdom {

    private String name;

    public void sendMessage(Kingdom receiver){
        System.out.println("Сообщение отправлено из " + this.name + " в " + receiver.getName());
    }
}
