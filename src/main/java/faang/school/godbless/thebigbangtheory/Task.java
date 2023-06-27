import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнение задания " + task);
        try {
            Thread.sleep(10);
            System.out.println(name + " выполненил задание " + task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
