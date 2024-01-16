package faang.school.godbless.multi_con.task4work.subtask2;

import java.util.List;

public class DesignDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources design, MarketingResources marketing) {
        this.designResources = design;
        this.marketingResources = marketing;
    }

    public void run() {
        designResources.addFile("Design.sketch1");
        designResources.addFile("Design.sketch2");
        List<String> marketingFiles = marketingResources.readFiles();
        System.out.println("Дизайн прочитал файлы маркетинга: " + marketingFiles);
    }
}
