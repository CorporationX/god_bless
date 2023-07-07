package faang.school.godbless.sprint5.multithreading_conc.task6_work.task2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment implements Runnable{

    private DesignResources designResources;


    @Override
    public void run() {
        designResources.readFiles();
        designResources.addFile("marketing some file");
    }
}
