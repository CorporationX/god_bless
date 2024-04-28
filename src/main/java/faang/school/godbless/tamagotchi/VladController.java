package faang.school.godbless.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VladController {
    private Map<Integer, TamagotchiVlad> tamagotchiVladMap;

    public VladController() {
        this.tamagotchiVladMap = new HashMap<>();
    }

    public synchronized void addNewTamogotchi(TamagotchiVlad tamagotchiVlad) {
        log.info("Tamagotchi with name {} has joined!", tamagotchiVlad.getName());
        tamagotchiVladMap.put(tamagotchiVlad.getId(), tamagotchiVlad);
    }

    public synchronized void removeTamagotchi(TamagotchiVlad tamagotchiVlad) {
        log.info("Tamagotchi with name {} has removed!", tamagotchiVlad.getName());
        tamagotchiVladMap.remove(tamagotchiVlad.getId());
    }

    public synchronized void feedAll() {
        tamagotchiVladMap.forEach((k, v) -> v.feed());
    }

    public synchronized void playAll() {
        tamagotchiVladMap.forEach((k, v) -> v.play());
    }

    public synchronized void cleanAll() {
        tamagotchiVladMap.forEach((k, v) -> v.clean());
    }

    public synchronized void sleepAll() {
        tamagotchiVladMap.forEach((k, v) -> v.sleep());
    }
}