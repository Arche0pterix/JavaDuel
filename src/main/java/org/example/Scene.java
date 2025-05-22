package org.example;

import java.util.Scanner;

public class Scene {
    Scanner scanner = new Scanner(System.in);
    RandomEncounter randomEncounter = new RandomEncounter();
    LocationManager locationManager = new LocationManager();
    String answer1 = "y";

    public void battleSequence(Duelist duelist1) {
        int round = 1;
        while (duelist1.health != 0) { //проверка на ноль хп
            System.out.println(locationManager.locationPicker(duelist1).name); //новая локация
            System.out.println("This is room: " + locationManager.getRoomName());
            System.out.println("moster count: " + randomEncounter.getMonsterCount());
            if (locationManager.isRoomCompleted()) {
                System.out.println("Room is empty");
            } else {
                Duelist enemy = randomEncounter.pickRandomEnemy(duelist1); //новый враг
                System.out.println("You've encountered a(an) " + enemy.name + " it has " + enemy.health + " hp ,  prepare for battle");
                System.out.println();
                while (duelist1.health > 0 && enemy.health > 0) {

                    int currentDex1 = duelist1.getRandomDex();
                    int currentDex2 = enemy.getRandomDex();

                    if (currentDex1 > currentDex2) { //проверка инициативы 1 и 2
                        System.out.println("____________________________________");
                        System.out.println("Round " + round++);
                        duelist1.attack(enemy);
                        if (enemy.health == 0) {
                            break;
                        } else enemy.attack(duelist1);

                    } else if (currentDex1 < currentDex2) {
                        System.out.println("____________________________________");
                        System.out.println("Round " + round++);
                        enemy.attack(duelist1);
                        if (duelist1.health == 0) {
                            break;
                        } else duelist1.attack(enemy);
                    }
                }
                if (enemy.health > duelist1.health) { //проверка победителя
                    System.out.println(enemy.name + " is the winner!!");
                    System.out.println(duelist1.name + " is dead");
                } else {
                    System.out.println(duelist1.name + " is the winner!!");
                    System.out.println(enemy.name + " is dead");
                    Equipment loot = randomEncounter.randomLoot(); //получение лута
                    if (loot != null) {
                        System.out.println("You found " + loot.getName());
                    }
                    randomEncounter.healingSequence(duelist1); // хил (100% шанс)
                }
            }

            //дальше( y /n )
            System.out.println("forward or backwards? ( f or any )");
            System.out.println();
            answer1 = scanner.next();
            if (answer1.equalsIgnoreCase("f")) {
                System.out.println(locationManager.moveForward().roomType);
            } else {
                System.out.println(locationManager.goBack().roomType);

            }
        }
    }
}