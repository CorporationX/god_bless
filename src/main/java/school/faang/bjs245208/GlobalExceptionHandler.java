package school.faang.bjs245208;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (e instanceof IllegalArgumentException) {
            System.err.println("IllegalArgumentException in thread '" + t.getName() + "': " + e.getMessage());
        } else {
            System.err.println("Uncaught exception in thread '" + t.getName() + "': " + e.getMessage());
        }
        //e.printStackTrace();
    }
}
