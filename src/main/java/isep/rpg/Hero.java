package isep.rpg;

import java.util.List;

public abstract class Hero extends Fighter {

    private int armor;
    private int weaponDamage;
    private List<Potion> potions;
    private List<Food> lembas;

    public void defend() {}
    public void useConsumable() {
        this.addLifePoint(5);
    }

}
