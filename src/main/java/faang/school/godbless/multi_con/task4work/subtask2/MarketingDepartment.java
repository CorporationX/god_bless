package faang.school.godbless.multi_con.task4work.subtask2;

import java.util.List;

public class MarketingDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public MarketingDepartment(DesignResources design, MarketingResources marketing) {
        this.designResources = design;
        this.marketingResources = marketing;
    }

    public void run() {
        marketingResources.addFile("Strategy.docx1");
        marketingResources.addFile("Strategy.docx2");
        List<String> designFiles = designResources.readFiles();
        System.out.println("Маркетинг прочитал файлы дизайна: " + designFiles);
    }
}
