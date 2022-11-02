package model;

public class Unit implements Cloneable {
  private int health;
  private int attack;
  private Unit proximo;
  private boolean special;

  public Unit() {}

  public Unit(int health, int attack, boolean special) {
    this.health = health;
    this.attack = attack;
    this.special = special;
  }

  @Override
  public Unit clone() throws CloneNotSupportedException {
    Unit clone = new Unit();
    clone.setAttack(attack);
    clone.setHealth(health);
    clone.setSpecial(special);
    return clone;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getAttack() {
    return this.attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public Unit getProximo() {
    return proximo;
  }

  public void setProximo(Unit proximo) {
    this.proximo = proximo;
  }

  public boolean isSpecial() {
    return special;
  }

  public void setSpecial(boolean special) {
    this.special = special;
  }

}