package org.example;

 abstract class Equipment {
    private String name = "";
    private int equipmentId;
    private int bonusToDex;
    private int bonusToStr;
    private int getBonusToLife;
    private int bonusToEvasion;
    private int bonusToDamage;

    public Equipment(String name,int equipmentId, int bonusToDex, int bonusToStr, int bonusToLife, int bonusToEvasion, int bonusToDamage) {
        this.name = name;
        this.equipmentId= equipmentId;
        this.bonusToDex = bonusToDex;
        this.bonusToStr = bonusToStr;
        this.getBonusToLife = bonusToLife;
        this.bonusToEvasion = bonusToEvasion;
        this.bonusToDamage = bonusToDamage;
    }
     public String getName() {
         return name;
     }

     public int getEquipmentId(){
         return equipmentId;
     }

     public int getBonusToDex() {
         return bonusToDex;
     }

     public int getBonusToStr() {
         return bonusToStr;
     }

     public int getBonusToLife() {
         return getBonusToLife;
     }

     public int getBonusToEvasion() {
         return bonusToEvasion;
     }

     public int getBonusToDamage() {
         return bonusToDamage;
     }
 }
