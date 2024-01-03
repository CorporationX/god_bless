package faang.school.godbless.work_standings;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> designFiles = new ArrayList<>();
        designFiles.add("File 1");
        designFiles.add("File 2");
        designFiles.add("File 3");
        List<String> marketingFiles = new ArrayList<>();
        marketingFiles.add("File 1");
        marketingFiles.add("File 2");
        marketingFiles.add("File 3");

        DesignResources designResources = new DesignResources(designFiles);
        MarketingResources marketingResources = new MarketingResources(marketingFiles);
        new MarketingDepartment(marketingResources, designResources).start();
        new DesignDepartment(designResources, marketingResources).start();
    }
}
