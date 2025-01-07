package derschrank.sprint04.task17.bjstwo_51287;

import java.util.List;

public class DesignDepartment implements Department, Runnable {
    private final Resources marketingRes;
    private final Resources designRes;

    public DesignDepartment(Resources marketing, Resources design) {
        marketingRes = marketing;
        designRes = design;
    }

    @Override
    public void run() {
        System.out.println("DesignDepartment is reading MarketingResources in Thread: "
                + Thread.currentThread().getName());
        List<File> files = marketingRes.getFiles();


        System.out.println("DesignDepartment is adding files in DesignDepartment in Thread: "
                + Thread.currentThread().getName());
        designRes.addFile(new File("Marketing Analisis 1.txt"));
        designRes.addFile(new File("Marketing Analisis 2.txt"));
    }
}
