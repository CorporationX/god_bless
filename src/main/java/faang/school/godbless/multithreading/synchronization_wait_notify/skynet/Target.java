package faang.school.godbless.multithreading.synchronization_wait_notify.skynet;

public class Target {
    private String name;
    private boolean status = true;

    public Target(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public synchronized void setStatus(boolean status) {
        this.status = status;
    }
}
