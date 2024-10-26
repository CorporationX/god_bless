package mod1sp4.bjs2_37919_sendRaven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < 0.3) {
            throw new Exception("Ворон не смог доставить сообщение из " + this.name + " в " + receiver.getName());
        }
        return "Сообщение успешно доставлено из " + this.name + " в " + receiver.getName();
    }
}
