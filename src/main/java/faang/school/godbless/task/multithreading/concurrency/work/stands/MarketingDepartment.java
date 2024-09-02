package faang.school.godbless.task.multithreading.concurrency.work.stands;

public class MarketingDepartment extends Thread {

    public MarketingDepartment(Runnable runnable) {
        super(runnable);
    }
}
