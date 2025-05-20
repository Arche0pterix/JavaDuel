package org.example;

import java.util.Random;
import java.util.Scanner;

public class Scene {
    Scanner scanner = new Scanner(System.in);
    RandomEncounter randomEncounter = new RandomEncounter();
    LocationManager locationManager = new LocationManager();
    Locations locations;
    String answer1 = "y";
    Room room;
    Random random = new Random();


    public void battleSequence(Duelist duelist1) {
        int round = 1;
        while (duelist1.health != 0) { //проверка на ноль хп
            System.out.println(locationManager.locationPicker(duelist1).name); //новая локация
            locationManager.roomList();                                         // first room name
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
                    System.out.println("You found "+loot.getName());
                }
                randomEncounter.healingSequence(duelist1); // хил (100% шанс)
            }
            //дальше( y /n )
            System.out.println("forward or backwards? ( f or any )");
            answer1 = scanner.next();
            if (answer1.equalsIgnoreCase("f")) {
                System.out.println(locationManager.moveForward().roomType);
            } else System.out.println(locationManager.goBack().roomType);
        }
    }
}


          /*


            System.out.println(locationManager.moveForward().roomType);
            while (answer1.equalsIgnoreCase("y") && duelist1.health != 0) {
                Duelist enemy = randomEncounter.pickRandomEnemy(duelist1);
                System.out.println("Press Y to start");
                answer1 = scanner.next();
                System.out.println();
                System.out.println("You've encountered a(an) " + enemy.name + " prepare for battle");
                System.out.println("Enemy health " + enemy.health);

                while (duelist1.health > 0 && enemy.health > 0) {

                    int currentDex1 = duelist1.getRandomDex();
                    int currentDex2 = enemy.getRandomDex();

                    if (currentDex1 > currentDex2) {
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
                if (enemy.health > duelist1.health) {
                    System.out.println(enemy.name + " is the winner!!");
                    System.out.println(duelist1.name + " is dead");
                } else {
                    System.out.println(duelist1.name + " is the winner!!");
                    System.out.println(enemy.name + " is dead");
                    Equipment loot = randomEncounter.randomLoot();
                    if (loot != null) {
                        System.out.println(loot.getName());
                    }
                    randomEncounter.healingSequence(duelist1);
                    System.out.println("Would you like to go forward? Y or N");
                    answer1 = scanner.next();
                    System.out.println("Your max hp is: " + duelist1.maxHealth);
                    System.out.println("Your current hp is: " + duelist1.health);
                }
            }
        }

        public void equipmentSequence (Duelist duelist1){
            Equipment randomEquipment = randomEncounter.pickRandomEquipment();
            System.out.println("You found: " + randomEquipment.getName() + " on the enemy");
            System.out.println("Would you like to equip it? Y or N");
            answer1 = scanner.next();
            if (answer1.equalsIgnoreCase("y")) {
                switch (randomEquipment.getEquipmentId()) {
                    case (0):
                        System.out.println("Id 0 " + randomEquipment.getName());
                        duelist1.equipBody((BodyArmor) randomEquipment);
                        System.out.println("new hp :" + duelist1.health);
                        break;
                    case (1):
                        System.out.println("id 1 " + randomEquipment.getName());
                        duelist1.equipRing((Ring) randomEquipment);
                        break;
                    case (2):
                        System.out.println("id 2 " + randomEquipment.getName());
                        duelist1.equipLeg((LegGear) randomEquipment);
                        break;
                    case (3):
                        System.out.println("id 3 " + randomEquipment.getName());
                        duelist1.equipHelmet((Helmet) randomEquipment);
                        break;
                    case (4):
                        System.out.println("id 4 " + randomEquipment.getName());
                        duelist1.equipRing((Ring) randomEquipment);
                        break;
                }
                System.out.println("current hp value " + duelist1.health);
                System.out.println("new dmg value " + duelist1.damage);
                System.out.println("new eva value " + duelist1.evasion);
                System.out.println("new dex value " + duelist1.dexterity);
                if (duelist1.helmetId != null) {
                    System.out.println("Helm" + duelist1.helmetId.getName());
                } else if (duelist1.bodyId != null) {
                    System.out.println("Body" + duelist1.bodyId.getName());
                } else if (duelist1.legGearId != null) {
                    System.out.println("Legs" + duelist1.legGearId.getName());
                } else if (duelist1.ringOneId != null) {
                    System.out.println("Ring1" + duelist1.ringOneId.getName());
                } else {
                    System.out.println("Ring2" + duelist1.ringTwoId.getName());
                }


            } else System.out.println("You put the item in the bag");
        }


    }
*///u