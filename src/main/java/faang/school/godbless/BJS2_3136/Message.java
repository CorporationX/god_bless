package faang.school.godbless.BJS2_3136;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Message {
    @NonNull Integer id;

    void send() {
        System.out.println("Message " + id + " sent!");
    }

    static List<Message> getList(int n) {
        var messageList = new ArrayList<Message>(n);
        for (int i = 0; i < n; ++i) {
            messageList.add(new Message(i));
        }
        return messageList;
    }
}
