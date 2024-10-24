package school.faang.carry.storages;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.carry.Item;
import school.faang.carry.Player;

import java.util.List;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@Slf4j
public class Store extends ItemStorage {

    public Store(List<Item> items) {
        super(items);
    }

    @Override
    public synchronized Item getItem(Item item, Player player) {
        validate(item, player);
        System.out.println("Курьер несет предмет " + item + " из магазина");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        player.spendGold(item.price());
        return super.getItem(item, player);
    }

    @Override
    protected void validate(Item item, Player player) {
        super.validate(item, player);
        if (item.price() > player.getCash()) {
            throw new IllegalStateException("у игрока " + player + " недостаточно средств");
        }
    }
}
