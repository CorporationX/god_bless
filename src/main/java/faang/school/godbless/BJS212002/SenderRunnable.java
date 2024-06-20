package faang.school.godbless.BJS212002;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    List<String> messages;
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("The " + messages.get(i) + " sent successfully");
        }
    }
}
