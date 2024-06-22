package faang.school.godbless.microsoft;

import java.util.List;

public class SenderRunnable implements Runnable {

    final int startIndex;
    final int endIndex;
    final List<String> messages;

    public SenderRunnable(int startIndex, int endIndex, List<String> messages) {
        if(startIndex > endIndex) {
            throw new IllegalArgumentException("startIndex must be less than endIndex");
        }

        if(startIndex < 0) {
            throw new IllegalArgumentException("startIndex must be greater than 0");
        }

        if(endIndex > messages.size()) {
            throw new IllegalArgumentException("endIndex must be less than messages.size: " + endIndex + " " + messages.size());
        }


        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.messages = messages;
    }

    @Override
    public void run() {
        for(int i = startIndex; i <= endIndex; i++) {
            System.out.println(Thread.currentThread().getName() + " " + messages.get(i));
        }
    }
}
