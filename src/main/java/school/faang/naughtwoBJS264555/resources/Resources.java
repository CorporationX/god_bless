package school.faang.naughtwoBJS264555.resources;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Getter
public abstract class Resources {
    private List<String> resourceList = new CopyOnWriteArrayList<>();

    public void writeResource(String recourse) {
        resourceList.add(recourse);
        log.info("File '{}' added", recourse);
    }

    public void readResources() {
        log.info("List of files: ");
        resourceList.forEach(resource -> log.info("{}", resource));
    }
}
