package org.example;

import java.util.Random;
import java.util.Scanner;

public class Duelist {
    int id;
    int level;
    String name;
    int health;
    int maxHealth;
    int mana;
    int damage;
    int dexterity;
    int strength;
    int evasion;
    int evasionPerDex = 5;
    double randomNum = 0;
    Random random = new Random();
    Helmet helmetId;
    BodyArmor bodyId;
    LegGear legGearId;
    Ring ringOneId;
    Ring ringTwoId;
    Scanner scanner = new Scanner(System.in);

    Duelist(int id,int level, String name, int health, int maxHealth, int mana, int damage, int dexterity, int strength, int evasion) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.mana = mana;
        this.damage = damage;
        this.dexterity = dexterity;
        this.strength = strength;
        this.evasion = evasion;
    }

    void equipHelmet(Helmet helmet) {
        if (helmetId != null) {
            System.out.println("No more heads left");
        } else {
            helmetId = helmet;
            System.out.println("You have equipped " + helmet.getName());
            statChange(helmet.getBonusToLife(),
                    helmet.getBonusToDamage(),
                    helmet.getBonusToDex(),
                    helmet.getBonusToEvasion(),
                    helmet.getBonusToStr());
        }

    }

    void takeOffHelmet(Helmet helmet) {
        if (helmetId == null) {
            System.out.println("nothing to unequip");
        } else {
            helmetId = null;
            System.out.println("You took off " + helmet.getName());
            statChange(-helmet.getBonusToLife(),
                    -helmet.getBonusToDamage(),
                    -helmet.getBonusToDex(),
                    -helmet.getBonusToEvasion(),
                    -helmet.getBonusToStr());
        }

    }

    void equipBody(BodyArmor body) {
        if (bodyId != null) {
            System.out.println("no more slots");
        } else {
            bodyId = body;
            System.out.println("You have equipped " + body.getName());
            statChange(body.getBonusToLife(),
                    body.getBonusToDamage(),
                    body.getBonusToDex(),
                    body.getBonusToEvasion(),
                    body.getBonusToStr());
        }

    }

    void takeOffBody(BodyArmor body) {
        if (bodyId == null) {
            System.out.println("nothing to unequip");
        } else {
            bodyId = null;
            System.out.println("You took off " + body.getName());
            statChange(-body.getBonusToLife(),
                    -body.getBonusToDamage(),
                    -body.getBonusToDex(),
                    -body.getBonusToEvasion(),
                    -body.getBonusToStr());
        }

    }

    void equipLeg(LegGear leg) {
        if (legGearId != null) {
            System.out.println("One pair of legs maximum");
        } else {
            legGearId = leg;
            System.out.println("You have equipped " + leg.getName());
            statChange(leg.getBonusToLife(),
                    leg.getBonusToDamage(),
                    leg.getBonusToDex(),
                    leg.getBonusToEvasion(),
                    leg.getBonusToStr());
        }

    }

    void takeOffLeg(LegGear leg) {
        if (legGearId == null) {
            System.out.println("nothing to unequip");
        } else {
            legGearId = null;
            System.out.println("You took off " + leg.getName());
            statChange(-leg.getBonusToLife(),
                    -leg.getBonusToDamage(),
                    -leg.getBonusToDex(),
                    -leg.getBonusToEvasion(),
                    -leg.getBonusToStr());
        }

    }

    void equipRing(Ring ring) {
        if (ringOneId != null && ringTwoId != null) {
            System.out.println("You cannot equip more than two rings");
            System.out.println("Would you like to take off any of your current ring and put on the new one? Y or N");
            String answer = scanner.next();
            int answer1 ;
            if(answer.equalsIgnoreCase("y")){
                System.out.println("choose which one to take off. The (1)" +ringOneId.getName() + "or this (2)" + ringTwoId.getName());
                answer1 = scanner.nextInt();
                if (answer1 == 1){
                    ringOneId = null;
                }
                else ringTwoId = null;
            }
            else System.out.println("not taking anything off choice");
        } else if (ringOneId == null) {
            ringOneId = ring;
            System.out.println("You have equipped 1st " + ring.getName());
            statChange(ring.getBonusToLife(),
                    ring.getBonusToDamage(),
                    ring.getBonusToDex(),
                    ring.getBonusToEvasion(),
                    ring.getBonusToStr());
        } else {
            ringTwoId = ring;
            System.out.println("You have equipped 2nd " + ring.getName());
            statChange(ring.getBonusToLife(),
                    ring.getBonusToDamage(),
                    ring.getBonusToDex(),
                    ring.getBonusToEvasion(),
                    ring.getBonusToStr());
        }
    }

    void takeOffRing(Ring ring) {
        if (ringOneId == null && ringTwoId == null) {
            System.out.println("no rings to take off");
        } else if (ringTwoId != null) {
            ringTwoId = null;
            System.out.println("You took off 2nd " + ring.getName());
            statChange(-ring.getBonusToLife(),
                    -ring.getBonusToDamage(),
                    -ring.getBonusToDex(),
                    -ring.getBonusToEvasion(),
                    -ring.getBonusToStr());
        } else {
            ringOneId = null;
            System.out.println("You took off 1st " + ring.getName());
            statChange(-ring.getBonusToLife(),
                    -ring.getBonusToDamage(),
                    -ring.getBonusToDex(),
                    -ring.getBonusToEvasion(),
                    -ring.getBonusToStr());
        }
    }

    void statChange(int bonusToLife, int bonusToDamage, int bonusToDex, int bonusToEvasion, int bonusToStr) {

        this.maxHealth += bonusToLife;
        this.damage += bonusToDamage;
        this.dexterity += bonusToDex;
        this.evasion += bonusToEvasion;
        this.strength += bonusToStr;
    }


    int getAttackDamage() {
        Random random = new Random();
        int sway = 5;
        return damage - sway + random.nextInt(sway * 2 + 1);

    }

    double chanceToHit() {
        randomNum = (random.nextDouble() * 100) + 1;
        return randomNum;
    }

    double getEvasion() {
        return (evasion / 100.0 * (dexterity * evasionPerDex + 100)) / 1000;
    }

    boolean hasEvaded(Duelist enemy) {
        double temp = enemy.chanceToHit();
        return this.getEvasion() <= temp;
    }

    int getRandomDex() {
        Random random = new Random();
        return random.nextInt(this.dexterity) + 1;
    }

    void attack(Duelist enemy) {
        if (enemy.hasEvaded(this)) {
            System.out.println(enemy.name + " has evaded " + this.name + " attack");
        } else {
            int damage = this.getAttackDamage();
            enemy.health = enemy.health - damage;
            System.out.println();
            if (enemy.health < 0) {
                enemy.health = 0;
            }
            System.out.println(this.name + " has attacked " + enemy.name + " for " + damage + " damage");
            System.out.println(enemy.name + " has: " + enemy.health + " Hp");
            System.out.println();
        }
    }
}