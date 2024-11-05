package school.faang.work.is.in.place;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        System.out.println("пытаюсь получить доступ к папке отдела Дизайна...");
        designResources.getFileNames();
        marketingResources.addFileName("new File");
    }
}
