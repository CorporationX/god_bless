package faang.school.godbless.multithreading_async.task_1;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
