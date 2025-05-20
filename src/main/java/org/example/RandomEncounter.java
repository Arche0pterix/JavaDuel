package org.example;

import java.util.ArrayList;
import java.util.Random;

public class RandomEncounter {
    Random random = new Random();
    int randomInt;
    ArrayList<Duelist> duelistList = new ArrayList<Duelist>();
    public RandomEncounter(){
        initMonsterList();
    }
    public void initMonsterList() {
        duelistList.add(new Duelist(0, 0, "Crow", 50, 50, 0, 6, 20, 4, 15000));
        duelistList.add(new Duelist(1, 3, "Fox", 130, 130, 0, 10, 9, 8, 7000));
        duelistList.add(new Duelist(2, 5, "Wolf", 160, 160, 0, 13, 14, 14, 12000));
        duelistList.add(new Duelist(3, 1, "Rat", 40, 40, 0, 3, 14, 1, 10000));
        duelistList.add(new Duelist(4, 2, "Snake", 80, 80, 0, 10, 14, 3, 17000));
        duelistList.add(new Duelist(5, 10, "Bear", 500, 500, 0, 65, 20, 20, 15000));
        duelistList.add(new Duelist(6, 6, "Lynx", 330, 330, 0, 15, 9, 8, 27000));
        duelistList.add(new Duelist(7, 2, "Turtle", 260, 260, 0, 2, 14, 14, 3000));
        duelistList.add(new Duelist(8, 0, "Chicken", 10, 10, 0, 4, 14, 1, 10000));
        duelistList.add(new Duelist(9, 2, "Wasp", 30, 30, 100, 4, 16, 2, 11000));
    }
    public Duelist pickRandomEnemy(Duelist duelist){
        randomInt = random.nextInt(duelistList.size()+1);
        while (duelist.level <= duelistList.get(randomInt).level){
            randomInt = random.nextInt(duelistList.size());
        }
         return duelistList.get(randomInt);
    }

    public Equipment pickRandomEquipment() {
        ArrayList<Equipment> gearList = new ArrayList<Equipment>();
        gearList.add(new BodyArmor("Tabula", 0, 0, 2, 22, 2577, 0));
        gearList.add(new Ring("Golden ring", 1, 5, 5, 100, 0, 15, 2));
        gearList.add(new LegGear("Leggings", 2, 2, 0, 2, 300, 2));
        gearList.add(new Helmet("Heavy helm", 3, 0, 0, 15, 0, 1));
        gearList.add(new Ring("Iron ring", 4, 3, 3, 5, 0, 5, 1));

        return gearList.get(random.nextInt(5));
    }

    /*
    Random encounter class , contains random encounter methods
    */
}
