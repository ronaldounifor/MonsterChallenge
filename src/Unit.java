public class Unit {
  private int health;
  private int attack;
  private Unit proximo;

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

  public Unit getProximo() {
    return proximo;
  }

  public void setProximo(Unit proximo) {
    this.proximo = proximo;
  }

}