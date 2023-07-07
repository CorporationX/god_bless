package faang.school.godbless.sprint5.multithreading_conc.task6_work.task1_deadlock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment implements Runnable{

    private DesignResources designResources;


    @Override
    public void run() {
        designResources.addFilesFromMarketingResources();
    }
}
