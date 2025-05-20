package org.example;

public class Ring extends Equipment {
    int multiplier;

    public Ring(String name, int equipmentId, int bonusToDex, int bonusToStr, int bonusToLife, int bonusToEvasion, int bonusToDamage, int multiplier) {
        super(name, equipmentId, bonusToDex, bonusToStr, bonusToLife, bonusToEvasion, bonusToDamage);
        this.multiplier = multiplier;
    }


    @Override
    public int getBonusToDex() {
        return super.getBonusToDex() * multiplier;
    }

    @Override
    public int getBonusToStr() {
        return super.getBonusToStr() * multiplier;
    }

    @Override
    public int getBonusToLife() {
        return super.getBonusToLife() * multiplier;
    }

    @Override
    public int getBonusToEvasion() {
        return super.getBonusToEvasion() * multiplier;
    }

    @Override
    public int getBonusToDamage() {
        return super.getBonusToDamage() * multiplier;
    }
}
