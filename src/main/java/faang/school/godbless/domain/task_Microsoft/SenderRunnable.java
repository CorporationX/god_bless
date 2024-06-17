package faang.school.godbless.domain.task_Microsoft;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {


    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("письмо " + i + " оправлено");
        }
    }
}
