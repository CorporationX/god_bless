package abstraction;

import lombok.Getter;

@Getter
//setter не делаем так ка по условиям нельзя изменять характеристики персонажей
public abstract class Character {

    /**
     * ВОПРОС ПРОВЕРЯЮЩЕМУ
     *
     * У нас у каждого героя должна выставляться определенными характеристиками
     * Зачем мы создаем конструктор со всеми полями в Character ,если мы не можем сообщить пользователю, что поля должны быть
     * с определенными характеристиками(для Warrior сила всегда выставляется в 10, ловкость в 5, интеллект в 3. Имя передаётся извне;).
     * не пробовать же каждое число для консруктора при создании warrior, если мы допустим пропишем условия
     * В чем смысл, если для этого мы реализуем конструктор в самих классах героев, где ставим дефолт характеристики героев
     * например такой:
     *  public Warrior(String name) {
     *         super(name);
     *         strength = 10;
     *         agility = 5;
     *         intelligence = 3;
     *     }
     */


//нам нужно защитить данные от других, но private не позволяет использовать поля в классах наследниках,
//поэтому используем protected
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character (String name){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Пустое имя");
        }

        this.name = name;
        health = 100;
    }

    public Character (String name, int strength, int agility, int intelligence){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Пустое имя");
        }

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        health = 100;
    }

    public abstract void attack (Character character);
}
