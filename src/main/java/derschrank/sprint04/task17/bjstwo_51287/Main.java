package derschrank.sprint04.task17.bjstwo_51287;

public class Main {
    public static void main(String[] args) {
        Resources marketingRes = new MarketingResources();
        Resources designRes = new DesignResources();

        Department marketingDep = new MarketingDepartment(marketingRes, designRes);
        Department designDep = new DesignDepartment(marketingRes, designRes);

        Thread marketingThr = new Thread(marketingDep);
        Thread designThr = new Thread(designDep);

        marketingThr.start();
        designThr.start();
    }
}
