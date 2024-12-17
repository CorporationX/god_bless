package school.faang.workedin_microsoft;

import java.util.List;

public class SenderRunner implements Runnable {
    private final List<Letter> letters;
    private final int startIndex;
    private final int endIndex;

    public SenderRunner(List<Letter> letters, int startIndex, int endIndex) {
        this.letters = letters;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        if (!letters.isEmpty()) {
            for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
                System.out.println("Message " + letters.get(currentIndex).id() + " has been sent");
            }
        }
    }
}
