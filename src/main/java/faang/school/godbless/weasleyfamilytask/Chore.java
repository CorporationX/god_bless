import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String name;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " задача " + name + " выполняется");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " задача " + name + " выполнена");
    }
}
