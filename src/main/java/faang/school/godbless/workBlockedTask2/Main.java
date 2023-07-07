package faang.school.godbless.workBlockedTask2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> designFiles = List.of("picture.jpg", "somedesign.png");
        List<String> marketingFiles = List.of("report2022.pdf", "report2023.pdf");

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
