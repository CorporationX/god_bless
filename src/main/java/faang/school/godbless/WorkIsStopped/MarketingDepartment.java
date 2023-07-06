package faang.school.godbless.WorkIsStopped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private final String name = "Marketing Department";
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public void writeFiles() {
        for (int i = 0; i < 10; i++) {
            marketingResources.writeFiles("Marketing file" + (i + 1));
        }
    }

    public void readFiles() {
        designResources.readFiles();
    }

    @Override
    public void run() {
        writeFiles();
        readFiles();
    }
}
