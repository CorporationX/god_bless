package school.faang.sprint_3.task_49549;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VladController {
    private final List<TamagotchiVlad> vladList;

    public void addVlad(@NonNull TamagotchiVlad vlad) {
        vladList.add(vlad);
    }

    public void removeVlad(TamagotchiVlad vlad) {
        vladList.remove(vlad);
    }

    public void feedAll() {
        vladList.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        vladList.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        vladList.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        vladList.forEach(TamagotchiVlad::sleep);
    }
}
