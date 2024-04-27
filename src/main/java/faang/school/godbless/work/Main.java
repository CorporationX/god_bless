package faang.school.godbless.work;

public class Main {

    public static void main(String[] args){

        System.out.println("Without deadlock");
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        designResources.writeNameOfDocument("design");
        marketingResources.writeNameOfDocument("marketing");

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, false);
        DesignDepartment designDepartment = new DesignDepartment(designResources, false);

        marketingDepartment.callDesignDeportment(designDepartment);
        designDepartment.callMarketingDeportment(marketingDepartment);

        marketingDepartment.start();
        designDepartment.start();

        try {
            marketingDepartment.join();
            designDepartment.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("Deadlock!");

        MarketingDepartment marketingDepartment1 = new MarketingDepartment(marketingResources, true);
        DesignDepartment designDepartment1 = new DesignDepartment(designResources, true);

        marketingDepartment1.callDesignDeportment(designDepartment1);
        designDepartment1.callMarketingDeportment(marketingDepartment1);

        marketingDepartment1.start();
        designDepartment1.start();

    }
}
