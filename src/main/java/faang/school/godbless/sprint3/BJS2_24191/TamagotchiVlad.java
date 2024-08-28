package faang.school.godbless.sprint3.BJS2_24191;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@AllVladsConstructor
@Getter
@Setter
//@VladSetter
@ToString
public class TamagotchiVlad {
    private static int vladNextId = 0;
    private String vladId;

    private double vladsHungerLevel = 100; // 100.0 means very hungry, 0.0 means full
    private double vladsEnergyLevel = 100;
    private double vladsCleanliness = 100;
    private double vladsSleepiness = 100;

    public TamagotchiVlad() {
        this.vladId = "vlad" + vladNextId++;
    }

    public synchronized void feed() {
        if (vladsHungerLevel > 0.0) {
            vladsHungerLevel -= 10.0;
            if (vladsHungerLevel < 0.0) vladsHungerLevel = 0.0;
            log.info("Vlad has been fed. Hunger level: {}", vladsHungerLevel);
        } else {
            log.info("Vlad is not hungry.");
        }
    }

    public synchronized void play() {
        if (vladsEnergyLevel > 0.0) {
            vladsEnergyLevel -= 10.0;
            if (vladsEnergyLevel < 0.0) vladsEnergyLevel = 0.0;
            log.info("Vlad played. Boredom level: {}", vladsEnergyLevel);
        } else {
            log.info("Vlad is not bored.");
        }
    }

    public synchronized void clean() {
        if (vladsCleanliness > 0.0) {
            vladsCleanliness -= 10.0;
            if (vladsCleanliness < 0.0) vladsCleanliness = 0.0;
            log.info("Vlad has been cleaned. Cleanliness level: {}", vladsCleanliness);
        } else {
            log.info("Vlad is already clean.");
        }
    }

    public synchronized void sleep() {
        if (vladsSleepiness > 0.0) {
            vladsSleepiness -= 10.0;
            if (vladsSleepiness < 0.0) vladsSleepiness = 0.0;
            log.info("Vlad is sleeping. Sleepiness level: {}", vladsSleepiness);
        } else {
            log.info("Vlad is not sleepy.");
        }
    }
}
