import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom reciverKingdom, String message) {
        System.out.println("Сообщение " + message + " отправлено в королевство: " + reciverKingdom.getName());
    }
}
