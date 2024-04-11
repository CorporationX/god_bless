package faang.school.godbless.hogwarts;

class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Алохомора";
        String lumos = "Люмос";
        String expelliarmus = "Экспелиармус";

        spellCaster.cast(alohomora, (spell) -> "Дверь открыта с помощью " + spell);
        spellCaster.cast(lumos, (spell) -> "Свет создан с помощью " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Противник обезоружен с помощью " + spell);
    }
}
