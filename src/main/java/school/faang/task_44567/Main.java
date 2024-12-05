package school.faang.task_44567;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells testing = new HogwartsSpells();
        testing.addSpellEvent(1, "attack", "attacking somebody");
        testing.addSpellEvent(2, "attack", "attacking somebody and stunning for 3s");
        testing.addSpellEvent(3, "heal", "healing your teammate");
        testing.addSpellEvent(4, "shield", "activating shield fro 5s");
        testing.addSpellEvent(5, "attack", "blinding + hit 5hp");
        testing.addSpellEvent(6, "bust", "rising speed for 5s");

        System.out.println(testing.getSpellEventById(3));


        testing.deleteSpellEvent(3);

        testing.printAllSpellEvents();

    }
}
