package school.faang.work_stop;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("Прочитал данные файла Marketing");
            List<String> marketingFile = marketingResources.readeMarketing();
            synchronized (marketingResources) {
                System.out.println("Added File Marketing from Design");
                designResources.addFileDesign("Design add");
            }
        }
    }
}
