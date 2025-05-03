package dead.lock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        //Я так и не понял если после того как добились deadlock
        //и решили проблему оставить тут synchronized или нет)
        synchronized (marketingResources) {
            synchronized (designResources) {
                for (String designFile : designResources.getDesignFile()) {
                    marketingResources.addFile(designFile);
                }
            }
        }
    }
}
