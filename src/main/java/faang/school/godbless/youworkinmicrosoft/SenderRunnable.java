package faang.school.godbless.youworkinmicrosoft;

import java.util.List;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private final List<String> mails;

    public SenderRunnable(final int startIndex, final int endIndex, final List<String> mails) {
        this.mails = mails.subList(startIndex, endIndex);
    }

    @Override
    public void run() {
        mails.forEach(System.out::println);
    }
}
