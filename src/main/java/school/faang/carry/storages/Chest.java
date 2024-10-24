package school.faang.carry.storages;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.carry.Item;
import school.faang.carry.Player;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Slf4j
public class Chest extends ItemStorage {
    private String ownerName;

    @Override
    public synchronized Item getItem(Item item, Player player) {
        validate(item, player);
        System.out.println("Курьер несет " + item + " из сундука");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return super.getItem(item, player);
    }

    @Override
    protected void validate(Item item, Player player) {
        super.validate(item, player);
        if (!isChestOwner(player)) {
            throw new IllegalArgumentException("сундук не принадлежит игроку");
        }
    }

    private boolean isChestOwner(Player player) {
        return ownerName.equals(player.getName());
    }
}
