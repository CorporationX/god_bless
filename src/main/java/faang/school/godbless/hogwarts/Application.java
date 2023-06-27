package faang.school.godbless.hogwarts;

 class Application {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        // Perform "Alohomora" spell (opens the door)
        spellCaster.cast("Alohomora", (spell) -> "The door swings open.");

        // Perform "Lumos" spell (creates light)
        spellCaster.cast("Lumos", (spell) -> "A bright light illuminates the area.");

        // Perform "Expeliarmus" spell (disarms the enemy)
        spellCaster.cast("Expeliarmus", (spell) -> "The enemy's wand flies out of their hand.");

        // You can add more spells here with their corresponding lambda expressions
    }
}
