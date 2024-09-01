package faang.school.godbless.BJS2_25446;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class Resources {
    private final List<String> resources;

    public void addResource(String resource) {
        resources.add(resource);
    }

    public void getResources() {
        System.out.println(resources.toString());
    }
}
