package faang.school.godbless.multi_con.task4work.subtask1;

public class MarketingDepartment extends Thread {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public MarketingDepartment(DesignResources design, MarketingResources marketing) {
        this.designResources = design;
        this.marketingResources = marketing;
    }

    public void run() {
        synchronized (marketingResources) {
            System.out.println("Маркетинг работает со своими ресурсами");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Маркетингу нужны ресурсы дизайна");
            synchronized (designResources) {
                System.out.println("Маркетинг получил доступ к ресурсам дизайна");
            }
        }
    }
}
