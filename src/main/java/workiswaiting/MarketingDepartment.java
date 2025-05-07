package workiswaiting;

import java.util.List;

public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    /*
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Design...");
        synchronized (designResources) {
            System.out.println(Thread.currentThread().getName() + " получил доступ к Design.");
            List<String> designFiles = designResources.getFiles();
            if (!designFiles.isEmpty()) {
                String fileToCopy = designFiles.get(0) + "_marketing";
                System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Marketing...");
                synchronized (marketingResources) {
                    System.out.println(Thread.currentThread().getName() + " получил доступ к Marketing.");
                    marketingResources.addFiles(fileToCopy);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу.");
    }

     */

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Design...");
        synchronized (marketingResources) {
            System.out.println(Thread.currentThread().getName() + " получил доступ к Design.");
            List<String> designFiles = designResources.getFiles();
            if (!designFiles.isEmpty()) {
                String fileToCopy = designFiles.get(0) + "_marketing";
                System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Marketing...");
                synchronized (designResources) {
                    System.out.println(Thread.currentThread().getName() + " получил доступ к Marketing.");
                    marketingResources.addFiles(fileToCopy);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу.");
    }
}
