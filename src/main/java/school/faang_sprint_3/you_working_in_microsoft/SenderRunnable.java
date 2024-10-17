package school.faang_sprint_3.you_working_in_microsoft;

public record SenderRunnable(int begin, int end) implements Runnable {

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            System.out.println(i + " The letter has been sent");
        }
    }
}
