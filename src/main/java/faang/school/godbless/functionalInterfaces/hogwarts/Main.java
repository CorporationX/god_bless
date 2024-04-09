package faang.school.godbless.functionalInterfaces.hogwarts;


public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String ridiculous = "Ridiculous";
        String eatSlugs = "Eat Slugs";
        String obliviate = "Obliviate";

        System.out.println("SpellCaster valid params test:");

        spellCaster.cast(ridiculous, spellName -> "The subject shrank and acquired amusing sound effects after being subjected to the " + spellName + " spell.");
        spellCaster.cast(eatSlugs, spellName -> "A bunch of slugs appeared in the mouth of the individual after being hit by the " + spellName + " spell.");
        spellCaster.cast(obliviate, spellName -> "The subject forgot everything he knew prior to being hit by the " + spellName + " spell.");


        System.out.println("\nSpellCaster invalid params test:");
        spellCaster.cast(null, spellName -> "Something was made by " + spellName + " cast.");
        spellCaster.cast("", spellName -> "Something was made by " + spellName + " cast.");
    }
}
