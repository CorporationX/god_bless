package school.faang.bjs2_85753;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Разрушение", "Ломает стену!");
        HogwartsSpells.addSpellEvent("Разрушение", "Ломает позвоночник противнику!");

        HogwartsSpells.addSpellEvent("Защита", "Покрывает вас оболочкой невосприимчивости на 5 секунд!");
        HogwartsSpells.addSpellEvent("Защита", "закрывает вас большим розовым щитом!");

        HogwartsSpells.printAllSpellEvents();
    }
}
