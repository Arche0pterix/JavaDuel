package org.example;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene();

        Duelist duelist1 = new Duelist(0, 1, "Max", 300, 300, 100, 22, 20, 22, 25000);
        Duelist duelist2 = new Duelist(1, 1, "Muxa", 200, 200, 120, 20, 22, 20, 22000);

        scene.battleSequence(duelist1);


/*




        System.out.println("Will " + duelist1.name + " equip his gear? Y or N");
        answer1 = scanner.next();
        if (answer1.equalsIgnoreCase("y")) {
            System.out.println("What set of gear would " + duelist1.name + " wear");
            System.out.println("Set 1 or Set 2 ? ( 1 or 2 )");
            answer2 = scanner.next();
            if (answer2.equalsIgnoreCase("1")) {
                duelist1.equipGear(gearSet1);
            } else duelist1.equipGear(gearSet2);
        } else System.out.println();
        System.out.println("gear off");
        duelist1.takeOffGear(duelist1.currentGear);

        while (duelist1.health > 0 && duelist2.health > 0) {
            int currentDex1 = duelist1.getRandomDex();
            int currentDex2 = duelist2.getRandomDex();

            if (currentDex1 > currentDex2) {
                System.out.println("____________________________________");
                System.out.println("Round " + round++);
                duelist1.attack(duelist2);
                if (duelist2.health == 0) {
                    break;
                } else duelist2.attack(duelist1);

            } else if (currentDex1 < currentDex2) {
                System.out.println("____________________________________");
                System.out.println("Round " + round++);
                duelist2.attack(duelist1);
                if (duelist1.health == 0) {
                    break;
                } else duelist1.attack(duelist2);
            }

        }
        if (duelist2.health > duelist1.health) {
            System.out.println(duelist2.name + " is the winner!!");
            System.out.println(duelist1.name + " is dead");
            // System.out.println();
            // System.out.println("Will "+ duelist2.name+ " take off his gear?");
            // duelist2.takeOffGear(duelist2.currentGear);
        } else {
            System.out.println(duelist1.name + " is the winner!!");
            System.out.println(duelist2.name + " is dead");
            // System.out.println();
            // System.out.println("Will "+ duelist1.name+ " take off his gear?");
            // duelist1.takeOffGear(duelist1.currentGear);
        }


        int numbers[] = new int[5];
        numbers[0] = 6;
        numbers[1] = 1;
        numbers[2] = 8;
        numbers[3] = 2;
        numbers[4] = 4;
        int result[] = remove(numbers, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] add(int[] numbers, int number) {
        int[] tent = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) {
            tent[i] = numbers[i];
        }
        tent[tent.length - 1] = number;

        return tent;
    }

    static int[] remove(int[] numbers, int index) {
        int[] tent = new int[numbers.length-1];
        for (int i = 0; i < index; i++) {
            tent[i] = numbers[i];
        }
        for (int i = index; i < tent.length; i++) {
            tent[i] = numbers[i+1];
        }
        return tent;
    }
*/
    }
}
