package school.faang.sprint2.task_57076;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        try {
            hogwartsSpells.addSpellEvent("Accio", "A spell that causes an object to fly towards the wizard");
            hogwartsSpells.addSpellEvent("Lumos", "A spell that ignites a light at the end of a wand");
            hogwartsSpells.addSpellEvent("Crucio", "A spell that causes extreme pain");
        } catch (IllegalArgumentException e) {
            System.out.println("Mistake: " + e.getMessage());
        }
    }
}
