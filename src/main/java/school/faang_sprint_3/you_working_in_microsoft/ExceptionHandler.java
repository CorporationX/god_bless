package school.faang_sprint_3.you_working_in_microsoft;

public class ExceptionHandler {

    public static void handleInterruptException(InterruptedException e) {
        throw new ThreadInterruptException(Thread.currentThread().getName() + " interrupted, " + e.getMessage());
    }

    public static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            handleInterruptException(e);
        }
    }
}
