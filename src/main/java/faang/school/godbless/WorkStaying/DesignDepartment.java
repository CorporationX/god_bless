package faang.school.godbless.WorkStaying;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment extends Thread {
    private DesignResources designResources;
    private MarketingResources marketingResources;

//    @Override
//    public void run() {
//        synchronized (marketingResources) {
//            marketingResources.printAllFiles();
//            synchronized (designResources) {
//                designResources.addFile("design.txt");
//            }
//        }
//    }
    @Override   // типа задача 2 ура я пофиксил невероятнейший дедлок урааааа
    public void run() {
        marketingResources.printAllFiles();
        synchronized (designResources) {
            designResources.addFile("design.txt");
        }
    }
}
