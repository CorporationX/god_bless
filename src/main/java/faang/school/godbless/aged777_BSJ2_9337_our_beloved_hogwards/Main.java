package faang.school.godbless.aged777_BSJ2_9337_our_beloved_hogwards;

public class Main {
    /*

    Условия задачи:
Вы являетесь учеником школы чародейства и волшебства «Хогвартс», и вам поручено создать систему для управления
заклинаниями. Ваша система должна быть способна выполнять различные магические действия, передавая функции в виде
лямбда-выражений.

Цель: Создайте класс SpellCaster с методом cast, который принимает строку с названием заклинания и лямбда-выражение,
описывающее действие этого заклинания. Используйте его для выполнения различных магических действий.

Требования:

Создайте функциональный интерфейс SpellAction, который принимает строку с названием заклинания и возвращает строку
с результатом выполнения заклинания;

Создайте класс SpellCaster с методом cast, который принимает строку с названием заклинания и лямбда-выражение типа
SpellAction, и который выполняет лямбда-выражение и выводит результат выполнения заклинания на консоль;
Соответственно лямбда и определяет, какой будет результат выполнения

Продемонстрируйте использование SpellCaster для выполнения различных заклинаний, таких как:
"Алохомора" (открывает дверь), "Люмос" (создает свет) и "Экспелиармус" (разоружает противника).

Пример использования:

SpellCaster spellCaster = new SpellCaster();

String alohomora = "Alohomora";
String lumos = "Lumos";
String expelliarmus = "Expelliarmus";

spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

     */

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        System.out.println(spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell));
        System.out.println(spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell));
        System.out.println(spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell));
    }
}
