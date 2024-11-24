package Java;

import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int rollDice() {
        return new Random().nextInt(6) + 1; // used to get dice value 1-6
    }

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);//reduce health after damage
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return name + " [Health=" + health + ", Strength=" + strength + ", Attack=" + attack + "]";
    }
}
