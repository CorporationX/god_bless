package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Создать класс Server, который будет содержать следующие характеристики:
// double load — отражает текущую нагрузку на сервер; считаю в RPS
// double maxLoad — отражает максимальную нагрузку на сервер; RPS, для каждого сервера разная, определяется при добавлении
// double energyConsumption — отражает текущие энергозатраты сервера.
// формула энергопотребление = потребление при 0 нагрузки
// (константа для каждого сервера, определяется при добавлении) + load*3, вот такое у меня оно будет
// так как реально половину задачи не написали, я моделирую её сам
@Getter
@Setter
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
