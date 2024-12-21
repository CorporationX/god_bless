package derschrank.sprint03.task01.bjstwo_48423;

import java.util.List;

public class SenderRunnable implements Runnable {
    private final List<Mail> mails;
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(List<Mail> mails, int startIndex, int endIndex) {
        this.mails = mails;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String colorBegin = getColorMarkerBeginner(threadName);
        String colorEnd = getColorMarkerEnd();

        Mail mail;
        for (int i = startIndex; i < endIndex; i++) {
            try {
                mail = mails.get(i);
                if (mail != null) {
                    System.out.print(colorBegin);
                    System.out.printf("Mail was sent in %s: %s%n", threadName, mail);
                    System.out.print(colorEnd);
                }
            } catch (Exception e) {
                System.out.println("Error during email sending.\n" + e.getMessage());
            }
        }
    }


    private String getColorMarkerBeginner(String name) {
        int numbers = Integer.parseInt(("0" + name).replaceAll("[^0-9]", ""));
        int color = numbers % 7 + 1;
        return String.format("\u001B[3%dm", color);
    }

    private String getColorMarkerEnd() {
        return "\u001B[0m";
    }
}
