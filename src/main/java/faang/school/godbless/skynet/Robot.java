package faang.school.godbless.skynet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private Target target;

    public  void attack() {
        synchronized (target) {
            System.out.println("Проводится атака на " + target.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Ошибка прерывания потока!");
            }
            System.out.println("Цель " + target.getName() + " была атакована");
        }
    }
}
