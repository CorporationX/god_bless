package school.faang.work_stopped_BJS2_39304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> fileList = new ArrayList<>(Arrays.asList("design1.png", "design2.jpg", "logo.svg"));
        List<String> marketingFiles = new ArrayList<>(Arrays.asList("brochure.pdf", "flyer.docx", "poster.psd"));

        DesignResources designResources = new DesignResources(fileList);
        MarketingResources marketingResources = new MarketingResources(marketingFiles);

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);

        Thread thread1 = new Thread(marketingDepartment);
        Thread thread2 = new Thread(designDepartment);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution finished");
    }
}