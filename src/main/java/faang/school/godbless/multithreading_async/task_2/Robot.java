package faang.school.godbless.multithreading_async.task_2;

public record Robot(String name, int attackPower, int defensePower) {
    public int getSumPower() {
        return this.attackPower + this.defensePower;
    }
}
