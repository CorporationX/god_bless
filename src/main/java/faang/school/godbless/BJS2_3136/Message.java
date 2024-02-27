package faang.school.godbless.BJS2_3136;

import lombok.Data;
import lombok.NonNull;

@Data
public class Message {
    @NonNull Integer id;

    void send() {
        System.out.println("Message " + id + " sent!");
    }
}
