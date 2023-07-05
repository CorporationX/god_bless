package faang.school.godbless.Multitrading2.TamagochiVlad;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class VladController {
    List<TamagotchiVlad> devices;

    public synchronized void addDevice(TamagotchiVlad device) {
        devices.add(device);
    }
    public synchronized void removeDevice(TamagotchiVlad device) {
        devices.remove(device);
    }

    public synchronized void feedAll() {
        System.out.println("feed All");
        devices.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        System.out.println("play All");
        devices.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        System.out.println("clean All");
        devices.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        System.out.println("sleep All");
        devices.forEach(TamagotchiVlad::sleep);
    }
}
