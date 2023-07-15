package faang.school.godbless.sprint5.multithreading_conc.task6_work.task2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment implements Runnable{

    private MarketingResources marketingResources;

    @Override
    public void run() {
        marketingResources.readFiles();
        marketingResources.addFile("design some file");
    }
}
