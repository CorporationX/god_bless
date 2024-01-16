package faang.school.godbless.multi_con.task4work.subtask1;

public class DesignDepartment extends Thread {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public DesignDepartment(DesignResources design, MarketingResources marketing) {
        this.designResources = design;
        this.marketingResources = marketing;
    }

    public void run() {
        synchronized (designResources) {
            System.out.println("Дизайн работает со своими ресурсами");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Дизайну нужны ресурсы маркетинга");
            synchronized (marketingResources) {
                System.out.println("Дизайн получил доступ к ресурсам маркетинга");
            }
        }
    }
}
