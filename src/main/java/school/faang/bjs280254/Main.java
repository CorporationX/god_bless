package school.faang.bjs280254;

public class Main {
    public static void main(String[] args) {
        String emperio = "Подчинение";
        String fly = "Полет";
        String fireball = "Огненный шар";
        SpellCaster caster = new SpellCaster();
        caster.spellCast(emperio, action -> {
            System.out.printf("Было применено заклинане наложения: %s.%n", emperio);
            System.out.println("Человек подчинен вашей воле.");
        });
        caster.spellCast(fly, action -> {
            System.out.printf("Было применено заклинание наложение: %s.%n", fly);
            System.out.println("Заклинание будет действовать пока мана игрока не закончиться.");
        });
        caster.spellCast(fireball, action -> {
            System.out.printf("Было применено заклинание атаки: %s.%n", fireball);
            System.out.println("Противник получил 250 ед. урона.");
        });
    }
}
