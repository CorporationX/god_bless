package faang.school.godbless.cleaningtheweasleyfamily;

public class Task implements Runnable {
    int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        System.out.println("Обработан запрос пользователя №" + taskNumber + " на потоке " + Thread.currentThread().getName());
    }
}