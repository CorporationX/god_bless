package derschrank.sprint04.task17.bjstwo_51287;

import java.util.List;

public class MarketingDepartment implements Department, Runnable {
    private final Resources marketingRes;
    private final Resources designRes;

    public MarketingDepartment(Resources marketing, Resources design) {
        marketingRes = marketing;
        designRes = design;
    }

    @Override
    public void run() {
        synchronized (designRes) {
            System.out.println("MarketingDepartment is reading DesignResources in Thread: "
                    + Thread.currentThread().getName());
            List<File> files = designRes.getFiles();
        }

        synchronized (marketingRes){
            System.out.println("MarketingDepartment is adding files in MarketingResources in Thread: "
                    + Thread.currentThread().getName());
            marketingRes.addFile(new File("Designe Sketch 1.txt"));
            marketingRes.addFile(new File("Designe Sketch 2.txt"));
        }
    }
}
