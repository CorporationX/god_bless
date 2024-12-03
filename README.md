# BJS2-43822
# Абстракция, абстракция!

## Условие задачи:
Создать иерархию классов для персонажей игры с использованием наследования и полиморфизма. В задаче рассматривается создание абстрактного класса, наследников с уникальными особенностями и механизма взаимодействия между персонажами через полиморфизм.

Требования:
1️⃣Создать абстрактный класс Character со следующими полями:

Имя;

Сила;

Ловкость;

Интеллект;

Здоровье. У всех персонажей по умолчанию 100.

2️⃣ Сделать в Character два конструктора: один принимает только имя, а другой все доступные параметры, кроме здоровья — оно имеет значение по умолчанию.

3️⃣ Создать классы-наследники от Character: Warrior и Archer. Переопределить их конструкторы:

для Warrior сила всегда выставляется в 10, ловкость в 5, интеллект в 3. Имя передаётся извне;

для Archer сила всегда выставляется в 3, ловкость в 10, интеллект в 5. Имя передаётся извне.

4️⃣Сделать в Character абстрактный метод attack, который принимает другого Character в качестве параметра.

5️⃣Переопределить этот метод в Warrior и Archer:

в Warrior персонаж - Character наносит урон противнику - Warrior в количестве собственной силы. У противника отнимается столько же очков здоровья, сколько он получает урона;

в Archer персонаж  - Character наносит урон противнику  - Archer в количестве собственной ловкости. У противника отнимается столько же очков здоровья, сколько он получает урона.

Замечание: для доступа к полям, нужно добавить им соответствующий модификатор доступа в абстрактном классе.

## Что было реализовано?

Был реализован абстрактный класс со всеми данными для персонажа. Написано два конструктора.
Написан абстрактный класс атаки, который реализуется в дочерних классах.
Реализованы геттеры и сеттеры, так же метод toString().
Написаны два класса: Warrior, Archer. Они наследуются от абстрактного класса и переопределяют метод attack() по контексту персонажа.
В точке входа написана мини-игра для тестирования.