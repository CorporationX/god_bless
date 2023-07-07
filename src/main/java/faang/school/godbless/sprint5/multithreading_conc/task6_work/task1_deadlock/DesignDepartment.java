package faang.school.godbless.sprint5.multithreading_conc.task6_work.task1_deadlock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment implements Runnable{

    private MarketingResources marketingResources;

    @Override
    public void run() {
        marketingResources.addFilesFromDesignResources();
    }
}
