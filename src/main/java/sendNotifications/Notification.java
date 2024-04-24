package sendNotifications;

import lombok.Data;

@Data
public class Notification {
    private int id;
    private String message;
    private static int countID = 1;

    public Notification(String message) {
        this.id = countID;
        this.message = message;
        countID++;
    }
}
