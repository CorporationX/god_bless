package faang.school.godbless.VladTamagochi;

import java.util.List;

public class VladController {
    private List<TamagochiVlad> tamagochiVlads;

    public VladController(List<TamagochiVlad> tamagochiVlads) {
        this.tamagochiVlads = tamagochiVlads;
    }

    public void feedAll() {
        tamagochiVlads.forEach(TamagochiVlad::feedVlad);
    }

    public void restAll() {
        tamagochiVlads.forEach(TamagochiVlad::restVlad);
    }

    public void playWithAll() {
        tamagochiVlads.forEach(TamagochiVlad::makeHappyVlad);
    }

    public void cleanseAll() {
        tamagochiVlads.forEach(TamagochiVlad::cleanseVlad);
    }

}
