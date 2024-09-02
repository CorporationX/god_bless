package work.waiting.departments;

import lombok.RequiredArgsConstructor;
import work.waiting.departments.resources.Resources;

@RequiredArgsConstructor
public abstract class ThreadDepartment extends Thread {
    protected final Resources marketingResources;
    protected final Resources designResources;

    @Override
    public abstract void run();
}
