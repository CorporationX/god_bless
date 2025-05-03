package workiswaiting;

import java.util.List;

public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public DesignDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }


//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Marketing...");
//
//        synchronized (marketingResources) {
//            System.out.println(Thread.currentThread().getName() + " получил доступ к Marketing.");
//            List<String> marketingFiles = marketingResources.getFiles();
//            if (!marketingFiles.isEmpty()) {
//                String fileToCopy = marketingFiles.get(0) + "_design";
//                System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Design...");
//                synchronized (designResources) {
//                    System.out.println(Thread.currentThread().getName() + " получил доступ к Design.");
//                    designResources.addFiles(fileToCopy);
//                }
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + " завершил работу.");
//    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Marketing...");

        synchronized (marketingResources) {
            System.out.println(Thread.currentThread().getName() + " получил доступ к Marketing.");
            List<String> marketingFiles = marketingResources.getFiles();
            if (!marketingFiles.isEmpty()) {
                String fileToCopy = marketingFiles.get(0) + "_design";
                System.out.println(Thread.currentThread().getName() + " пытается получить доступ к Design...");
                synchronized (designResources) {
                    System.out.println(Thread.currentThread().getName() + " получил доступ к Design.");
                    designResources.addFiles(fileToCopy);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу.");
    }
}
