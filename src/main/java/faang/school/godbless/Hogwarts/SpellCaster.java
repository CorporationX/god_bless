package faang.school.godbless.Hogwarts;

@FunctionalInterface
interface SpellAction {
    String execute(String spellName);
}

class SpellCaster {
    public void cast(String spellName, SpellAction action){
        String result = action.execute(spellName);
        System.out.println(result);
    }
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Alohomora", spellName -> spellName + " - The door is now unlocked!");
        spellCaster.cast("Lumos", spellName -> spellName + " - The room is illuminated!");
        spellCaster.cast("Expelliarmus", spellName -> spellName + " - The opponent's wand flies out of their hand!");
    }
}