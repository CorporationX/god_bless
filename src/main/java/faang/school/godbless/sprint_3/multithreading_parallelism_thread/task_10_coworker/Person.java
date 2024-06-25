package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_10_coworker;

public record Person(String name, String surname, int age, String workplace) {
    public Person(String name) {
        this(name, "empty", 0, "empty");
    }
}
