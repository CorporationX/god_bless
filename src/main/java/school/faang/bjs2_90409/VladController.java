package school.faang.bjs2_90409;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VladController {
    List<TamagotchiVlad> tamagochis;

    public void feedAll() throws InterruptedException {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.feed();
        }
    }

    public void playAll() throws InterruptedException {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.play();
        }
    }

    public void cleanAll() throws InterruptedException {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.clean();
        }
    }

    public void sleepAll() throws InterruptedException {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.sleep();
        }
    }
}
