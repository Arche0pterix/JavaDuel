package org.example;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene();
        Duelist duelist1 = new Duelist(0, 1, "Max", 300, 300, 100, 22, 20, 22, 25000);
        Duelist duelist2 = new Duelist(1, 1, "Muxa", 200, 200, 120, 20, 22, 20, 22000);
        scene.battleSequence(duelist1);
    }
}
