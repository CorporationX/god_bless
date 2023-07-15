package faang.school.godbless.workBlockedTask1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> designFiles = List.of("design1.jpg", "design2.jpg");
        List<String> marketingFiles = List.of("report1.pdf", "report2.pdf");

        DesignResources designResources = new DesignResources(designFiles);
        MarketingResources marketingResources = new MarketingResources(marketingFiles);

        List<String> designFilesList = designResources.readFiles();
        System.out.println("Design files: " + designFilesList);
        List<String> marketingFilesList = marketingResources.readFiles();
        System.out.println("Marketing files: " + marketingFilesList);

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        marketingDepartment.start();
        designDepartment.start();
    }

}
