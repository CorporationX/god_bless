package faang.school.godbless.multithreading_2.jobstand;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    private static final List<String> designResources = new ArrayList<>(List.of("дев", "тест", "прод"));
    private static final List<String> marketingResources = new ArrayList<>(List.of("дев", "тест", "прод"));

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    private static void writeResources(List<String> resources, String file) {
        resources.add(file);
    }

    private static void readFromDesignWriteToMarketingWrong() {
        List<String> resources;
        synchronized (designResources) {
            resources = designResources;
            threadSleep(1000);
            synchronized (marketingResources) {
                resources.forEach((resource) -> writeResources(marketingResources, resource));
            }
        }
    }

    private static void readFromMarketingWriteToDesignWrong() {
        List<String> resources;
        synchronized (marketingResources) {
            resources = marketingResources;
            threadSleep(1000);
            synchronized (designResources) {
                resources.forEach((resource) -> writeResources(designResources, resource));
            }
        }
    }

    private static void readFromDesignWriteToMarketing() {
        lock.readLock().lock();
        List<String> resources = designResources;
        lock.readLock().unlock();
        threadSleep(1000);
        lock.writeLock().lock();
        resources.forEach((resource) -> writeResources(marketingResources, resource));
        lock.writeLock().unlock();
    }

    private static void readFromMarketingWriteToDesign() {
        lock.readLock().lock();
        List<String> resources = marketingResources;
        lock.readLock().unlock();
        threadSleep(1000);
        lock.writeLock().lock();
        resources.forEach((resource) -> writeResources(designResources, resource));
        lock.writeLock().unlock();
    }



    public static void threadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(Main::readFromMarketingWriteToDesign);
        Thread thread2 = new Thread(Main::readFromDesignWriteToMarketing);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Выполнение завершено");


        // Реализация с DeadLock
        Thread threadWrong1 = new Thread(Main::readFromMarketingWriteToDesignWrong);
        Thread threadWrong2 = new Thread(Main::readFromDesignWriteToMarketingWrong);
        threadWrong1.start();
        threadWrong2.start();
        threadWrong1.join();
        threadWrong2.join();
        System.out.println("Выполнение завершено");
    }
}
