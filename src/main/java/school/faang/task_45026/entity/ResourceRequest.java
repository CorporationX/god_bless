package school.faang.task_45026.entity;

public record ResourceRequest(double load) {
    public ResourceRequest {
        if (load <= 0) {
            throw new IllegalArgumentException("load must be greater than 0");
        }
    }
}
