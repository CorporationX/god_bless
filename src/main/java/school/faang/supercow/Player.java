package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public record Player(String name) {
    public void doBattle(Boss boss) throws InterruptedException {
        validateArgument(boss);
        boss.joinBattle(this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток был прерван");
        }
        boss.leaveBattle(this);
    }

    private <T> void validateArgument(T argument) {
        Objects.requireNonNull(argument, "Переданное значение не может быть null");
    }
}