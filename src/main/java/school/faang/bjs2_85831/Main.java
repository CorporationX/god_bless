package school.faang.bjs2_85831;

import school.faang.bjs2_85831.spell.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Разрушение", "метает в оппонента дюжину сизых кулаков");
        HogwartsSpells.addSpellEvent("Разрушение", "соски противника выкручиваются на 360 градусов");
        HogwartsSpells.addSpellEvent("Чары", "оппонент начинает верить, что Земля плоская");
        HogwartsSpells.addSpellEvent("Чары", "штаны спускаются с противника, что бы он ни делал");
        HogwartsSpells.addSpellEvent("Трансфигурация", "вы обратитесь в оборотня-гигачада ночью");
        HogwartsSpells.addSpellEvent("Трансфигурация", "вы обращаетесь в неонового негра");
        HogwartsSpells.addSpellEvent("Защита", "укройтесь за Шахматной Ладьей");
        HogwartsSpells.addSpellEvent("Защита", "вас охраняет навозный купол");

        HogwartsSpells.printAllSpellEvents();
        System.out.println();

        HogwartsSpells.deleteSpellEvents("Чары");

        HogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println(HogwartsSpells.getSpellEventsByType("Разрушение"));
        System.out.println();

        System.out.println(HogwartsSpells.getSpellEventById(6));
        System.out.println();

        HogwartsSpells.deleteSpellEvent(8);
        HogwartsSpells.printAllSpellEvents();
    }
}
