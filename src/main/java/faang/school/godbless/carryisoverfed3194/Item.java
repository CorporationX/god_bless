package faang.school.godbless.carryisoverfed3194;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String name;
    private int power;

    public static final Item DAGON_3 = new Item("Dagon 3", 3);
    public static final Item SKULL_BASHER = new Item("Skull Basher", 2);
    public static final Item BUTTERFLY = new Item("Butterfly", 5);
    public static final Item REFRESHER = new Item("Refresher Orb", 5);
    public static final Item SATANIC = new Item("Satanic", 8);
    public static final Item AGHANIM = new Item("Aghanim's Scepter", 8);
    public static final Item RAPIER = new Item("Divine Rapier", 10);

    @Override
    public String toString() {
        return String.format("%s - power %d",
                this.getName(),
                this.getPower());
    }
}
