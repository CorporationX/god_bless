package faang.school.godbless.WorkStaying;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private DesignResources designResources;
    private MarketingResources marketingResources;

//    @Override
//    public void run() {             // ну типа задача 1 я сделал дедлок ура
//        synchronized (designResources) {
//            designResources.printAllFiles();
//            synchronized (marketingResources) {
//                marketingResources.addFile("design.txt");
//            }
//        }
//    }

    @Override   // типа задача 2 ура я пофиксил невероятнейший дедлок урааааа
    public void run() {
        designResources.printAllFiles();
        synchronized (marketingResources) {
            marketingResources.addFile("design.txt");
        }
    }
}
