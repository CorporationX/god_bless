package Sprint_4.BJS2_38935;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private int id;
    private String message;

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
