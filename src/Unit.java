public class Unit {
  private int health;
  private int attack;

  public Unit(int health, int attack) {
    this.health = health;
    this.attack = attack;
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

}