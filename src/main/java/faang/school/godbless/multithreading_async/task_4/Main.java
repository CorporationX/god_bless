package faang.school.godbless.multithreading_async.task_4;

public class Main {
    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        resultConsumer.launch();
        resultConsumer.shutdownExecutor();
    }
}
