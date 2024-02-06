package faang.school.godbless.multi.task10skynet;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class Robot {
    private static final Set<String> targets = new HashSet<>();

    private String target;

    public void attack() {
        synchronized (targets) {
            if (targets.contains(target)) {
                System.out.println("Цель уже атакуется другим роботом: " + target);
                return;
            }

            targets.add(target);
        }

        System.out.println("Робот атакует цель: " + target);

        synchronized (targets) {
            targets.remove(target);
        }
    }
}
