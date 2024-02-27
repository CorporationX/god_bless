package faang.school.godbless.BJS2_3136;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class SenderRunnable implements Runnable {
    @NonNull Integer startIndex;
    @NonNull Integer endIndex;
    @NonNull List<Message> messageList;

    @Override
    public void run() {
        for (int k = startIndex; k < endIndex; ++k) {
            messageList.get(k).send();
        }
    }
}
