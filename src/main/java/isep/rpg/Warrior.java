package isep.rpg;

public class Warrior extends Hero {
    public Warrior() { this.setLifePoints(5); }
    @Override
    public boolean attack(Fighter enemy) {
        return enemy.receiveAttack(5);
    }
    public boolean defense(Fighter enemy) {
        return enemy.receiveAttack(10);
    }
}
