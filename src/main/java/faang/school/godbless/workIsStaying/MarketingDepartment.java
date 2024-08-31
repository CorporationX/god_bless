package faang.school.godbless.workIsStaying;

public class MarketingDepartment extends Thread {
    @Override
    public void run() {
        System.out.println("начало работы отдела маркетинга");
        MarketingResources.write();
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DesignResources.read();
    }
}
