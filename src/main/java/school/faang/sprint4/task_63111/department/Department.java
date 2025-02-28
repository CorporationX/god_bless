package school.faang.sprint4.task_63111.department;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task_63111.resources.Resources;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Department implements Runnable {
    private final Resources inputResources;
    private final Resources outputResources;

    protected Department(Resources inputResources, Resources outputResources) {
        this.inputResources = inputResources;
        this.outputResources = outputResources;
    }

    @Override
    public void run() {
        String file;

        synchronized (inputResources) {
            log.debug("{} captured {}", this, inputResources);
            file = inputResources.read();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        log.debug("{} released the {}", this, inputResources);

        synchronized (outputResources) {
            log.debug("{} captured {}", this, outputResources);
            outputResources.write(file);
        }
        log.debug("{} released the {}", this, outputResources);
    }
}
