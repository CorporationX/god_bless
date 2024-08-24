package faang.school.godbless.sprint3.BJS2_24191;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class VladController {
    private final List<TamagotchiVlad> vlads = Collections.synchronizedList(new ArrayList<>());

    public void addVlad(@NonNull TamagotchiVlad tamagotchiVlad) {
        vlads.add(tamagotchiVlad);
        log.info("Added new vlad: {}", tamagotchiVlad.getVladId());
    }

    public void deleteVlad(@NonNull TamagotchiVlad tamagotchiVlad) {
        vlads.remove(tamagotchiVlad);
        log.info("Deleted vlad: {}", tamagotchiVlad.getVladId());
    }

    public void feedAll() {
        vlads.forEach(TamagotchiVlad::feed);
        System.out.println();
    }

    public void playAll() {
        vlads.forEach(TamagotchiVlad::play);
        System.out.println();
    }

    public void cleanAll() {
        vlads.forEach(TamagotchiVlad::clean);
        System.out.println();
    }

    public void sleepAll() {
        vlads.forEach(TamagotchiVlad::sleep);
        System.out.println();
    }

    public void printVlads() {
        vlads.forEach(v -> {
            System.out.println(v.toString());
        });
    }
}
