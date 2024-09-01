package work.waiting.departments;

import lombok.RequiredArgsConstructor;
import work.waiting.department_resources.Resources;

import java.util.concurrent.locks.ReadWriteLock;

@RequiredArgsConstructor
public class ThreadDepartment extends Thread {
    protected final Resources marketingResources;
    protected final Resources designResources;
    protected final ReadWriteLock lock;
}
