package TheWorkIsWorth;

public class DesignDepartment extends Thread {
    DesignResources design;
    MarketingResources marketing;

    public DesignDepartment(DesignResources design, MarketingResources marketing) {
        this.design = design;
        this.marketing = marketing;
    }

    public void run() {
        design.readDesignList();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        marketing.addMarketing("Маркетинг");
        System.out.println("Добавлен маркетинг");

    }
}
