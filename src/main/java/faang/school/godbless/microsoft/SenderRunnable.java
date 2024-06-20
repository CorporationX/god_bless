package faang.school.godbless.microsoft;

import java.util.List;

public class SenderRunnable implements Runnable {
    private List<String> emails;

    public SenderRunnable(List<String> emails) {
        if (emails.isEmpty() || emails == null) {
            throw new IllegalArgumentException(
                    "A puta or non-existent List was entered into the constructor of the SenderRunnable class");
        }
        this.emails = emails;
    }

    @Override
    public void run() {
        emails.forEach(System.out::println);
    }
}
