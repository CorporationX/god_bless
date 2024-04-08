package faang.school.godbless.lambdas.task_1.model;

@FunctionalInterface
public interface SpellAction<String> {
    String pronounce(String spell);
}