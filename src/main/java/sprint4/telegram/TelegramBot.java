package sprint4.telegram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TelegramBot {
    private final int requestLimit;
    private Date lastRequestTime;
    private int requestCounter;

    public TelegramBot(int requestLimit, Date lastRequestTime) {
        this.requestLimit = requestLimit;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(String message) {

    }
}
