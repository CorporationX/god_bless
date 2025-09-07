package school.faang.bjs2_85902;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        try {
            hogwartsSpells.addSpellEvent("Трансфигурация", "Перебрасывает вас в указаное место");
            hogwartsSpells.addSpellEvent("Иллюзия", "Создает \"копию\" возле вас");
            hogwartsSpells.addSpellEvent("Длинный прыжок", "Вы можете выше прыгать");
            hogwartsSpells.addSpellEvent("Длинный прыжок", "Вы можете выше прыгать на 30 секунд");
            hogwartsSpells.addSpellEvent("Левитация", "Вы можете парить в воздухе");
            hogwartsSpells.addSpellEvent("Невидимость", "Вы становитесь невидимым на 30 секунд");
            hogwartsSpells.addSpellEvent("Огненный шар", "Создает взрывающийся огненный шар");
            hogwartsSpells.addSpellEvent("Телепортация", "Мгновенное перемещение на короткое расстояние");
            hogwartsSpells.addSpellEvent("Щитовая защита", "Создает магический щит на 1 минуту");
            hogwartsSpells.addSpellEvent("Исцеление", "Восстанавливает здоровье союзникам");
            hogwartsSpells.addSpellEvent("Замедление времени", "Время вокруг вас замедляется");
            hogwartsSpells.addSpellEvent("Телекинез", "Управление предметами на расстоянии");
            hogwartsSpells.addSpellEvent("Превращение", "Можете превращаться в животное");
            hogwartsSpells.addSpellEvent("Ясновидение", "Видите сквозь стены на 10 секунд");
            hogwartsSpells.deleteSpellEvent(5);
            hogwartsSpells.getSpellEventByType("Длинный прыжок");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.getSpellEventById(6);

    }
}
