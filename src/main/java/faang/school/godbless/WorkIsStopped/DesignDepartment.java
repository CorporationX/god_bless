package faang.school.godbless.WorkIsStopped;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class DesignDepartment extends Thread {
    private final String name = "Design Department";
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public void writeFiles() {
        for (int i = 0; i < 10; i++) {
            designResources.writeFiles("Design file" + (i + 1));
        }
    }

    public void readFiles() {
            marketingResources.readFiles();
    }

    @Override
    public void run() {
        writeFiles();
        readFiles();
    }
}
