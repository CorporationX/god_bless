package school.faang.bjs2_90409;

import java.util.List;

public class VladController {
    List<TamagotchiVlad> tamagochis;

    public void feedAll() {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.feed();
        }
    }

    public void playAll() {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.play();
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.clean();
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad tamagochi : tamagochis) {
            tamagochi.sleep();
        }
    }

    //Дальше делаем пункт 3. Но в конце надо будет все-таки все пункты перечитать, вдруг на что не обратил
    //внимание.


}
