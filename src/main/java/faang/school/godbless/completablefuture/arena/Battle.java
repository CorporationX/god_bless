package faang.school.godbless.completablefuture.arena;

import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class Battle {

    private static final int ATTACK_DURATION = 100;
    private static final int BASE_ATTACK_TIME = 1000;
    private List<Robot> robots;

    public CompletableFuture<Optional<Robot>> fight() {
        List<CompletableFuture<Void>> futures = robots.stream()
                .map((robot ->
                        CompletableFuture.runAsync(() -> {
                            try {
                                Thread.sleep(new Random().nextInt(0, 250)); // for random first hit
                                this.startFighting(robot);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                System.out.printf("%s was interrupted\n", Thread.currentThread().getName());
                                e.printStackTrace();
                            }
                        })))
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> robots.stream()
                        .filter(Robot::isAlive)
                        .findFirst());
    }

    synchronized private void startFighting(Robot robot) throws InterruptedException {
        while (robot.isAlive() && isAnyToAttack()) {
            Robot target = getRandomTarget(robot);

            robot.setAttacking(true);
            this.wait(ATTACK_DURATION);
            robot.setAttacking(false);

            System.out.printf("%s -> %s\n", robot.getName(), target.getName());
            if (robot.isInterrupted()) {
                robot.setInterrupted(false);
                System.out.printf("%s was interrupted by attack\n\n", robot.getName());
            } else {
                if (target.isAlive()) {
                    System.out.printf("%s <- %d dmg || %s\n", target.getName(), robot.getAttackPower(), LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SS")));
                    inflictDamage(robot, target);
                    if (!target.isAlive()) {
                        System.out.printf("\nXXX %s is dead XXX\n\n", target.getName());
                    }
                } else {
                    System.out.printf("%s tried to kill already dead man! He-he =)\n", target.getName());
                }
            }
            printRobotsHP();
            
            int betweenAttacksTime = (int) (BASE_ATTACK_TIME * robot.getAttackSpeed());
            this.wait(betweenAttacksTime);
        }
    }

    private void inflictDamage(Robot attacker, Robot target) {
        if (target.isAttacking()) {
            target.setInterrupted(true);
        }
        target.receiveDamage(attacker.getAttackPower());
    }

    private void printRobotsHP() {
        robots.forEach((robot ->
                System.out.printf("| %s = %d ", robot.getName(), robot.getHp())));
        System.out.println("|\n");
    }

    private Robot getRandomTarget(Robot robot) {
        List<Robot> targets = robots.stream()
                .filter(target -> target.isAlive() && !target.equals(robot))
                .toList();
        return targets.get(new Random().nextInt(0, targets.size()));
    }

    private boolean isAnyToAttack() {
        return robots.stream()
                .filter(Robot::isAlive)
                .count() > 1;
    }

}
