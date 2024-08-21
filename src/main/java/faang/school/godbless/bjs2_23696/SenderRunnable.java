package faang.school.godbless.bjs2_23696;

import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

public class SenderRunnable implements Runnable {
    @Getter
    private String name;
    private int startIndex;
    private int endIndex;
    List<String> emails;

    public SenderRunnable(int startIndex, int endIndex, List<String> emails, int i) {
        this.name = "Thread #" + i;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.emails = IntStream.rangeClosed(startIndex, endIndex)
                .mapToObj(emails::get)
                .toList();
    }

    @Override
    public void run() {
        emails.stream()
                .forEach(e -> System.out.println(e + " was sent by " + this.name));
    }
}
