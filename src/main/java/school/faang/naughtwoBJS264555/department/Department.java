package school.faang.naughtwoBJS264555.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import school.faang.naughtwoBJS264555.resources.Resources;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Getter
public abstract class Department implements Runnable {
    private final Resources resourcesOfThis;
    private final Resources resourcesOfAnother;

    @Override
    public void run() {
        synchronized (resourcesOfAnother) {
            log.info("Looking through the resources of another department, hehe");
            List<String> resourceList = resourcesOfAnother.getResourceList();

            synchronized (resourcesOfThis) {
                log.info("Copying the resources of another department");
                resourceList.forEach(resource -> resourcesOfThis.writeResource(resource));
            }
        }
    }
}

