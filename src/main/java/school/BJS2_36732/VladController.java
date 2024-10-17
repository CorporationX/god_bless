package school.BJS2_36732;

import java.util.List;

public class VladController {

    List<TamagotchiVlad> tamagotchiVlads;

    public VladController(List<TamagotchiVlad> tamagotchiVlads) {
        this.tamagotchiVlads = tamagotchiVlads;
    }

    public void addVlad(TamagotchiVlad vlad) {
        tamagotchiVlads.add(vlad);
    }
    public void removeVlad(TamagotchiVlad vlad) {
        tamagotchiVlads.remove(vlad);
    }

    public void feedAll() {
        tamagotchiVlads.stream().forEach(vlad -> {
            try {
                vlad.feed(vlad.getTamagotchiVladName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public void playAll() {
        tamagotchiVlads.stream().forEach(vlad -> {
            try {
                vlad.play(vlad.getTamagotchiVladName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public void cleanAll() {
        tamagotchiVlads.stream().forEach(vlad -> {
            try {
                vlad.clean(vlad.getTamagotchiVladName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public void sleepAll() {
        tamagotchiVlads.stream().forEach(vlad -> {
            try {
                vlad.sleep(vlad.getTamagotchiVladName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
