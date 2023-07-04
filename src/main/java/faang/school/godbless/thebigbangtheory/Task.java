import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнение задания " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(name + " не смог выполнить задание " + task + " из-за ошибки");
            throw new RuntimeException(e);
        }
        System.out.println(name + " выполненил задание " + task);
    }
}
