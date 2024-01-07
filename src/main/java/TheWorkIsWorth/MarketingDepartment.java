package TheWorkIsWorth;

public class MarketingDepartment extends Thread {
    DesignResources design;
    MarketingResources marketing;

    public MarketingDepartment(DesignResources design, MarketingResources marketing) {
        this.design = design;
        this.marketing = marketing;
    }

    public void run() {
        marketing.readMarketingList();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        design.addDesign("Design");
        System.out.println("Добавлен дизайн");

    }
}
