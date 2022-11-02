package model;
import state.Ongoing;
import state.State;

public class Scenario implements Cloneable {
    private Unit monster;
    private HeroQueue heroes;
    private int special;
    private int buffStrength;
    private int buffCharges;
  
    private int tankValue;
    private int roundDamage;
  
    private int currentTank = 0;

    private boolean specialAlive;

    private State currentState;

    private Unit lastHit;

    public Scenario(Unit monster, HeroQueue heroes, int special, int buffStrength, int buffCharges) {
      this.monster = monster;
      this.heroes = heroes;
      this.special = special;
      this.buffStrength = buffStrength;
      this.buffCharges = buffCharges;
      this.specialAlive = true;
      this.currentState = new Ongoing(this);
    }

    public Scenario() {
    }

    public void nextRound() {
      monsterTurn();
      heroesTurn();
    }

    private void monsterTurn() {
      specialAlive = heroes.takeDamage(monster.getAttack());
      currentState.handle();
    }

    private void heroesTurn() {
      int quantidadeHerois = heroes.getQuantidade();

      int i = 0;
      while(i < quantidadeHerois && lastHit == null) {
        Unit heroiAtual = heroes.desenfileirar();

        monster.setHealth(monster.getHealth() - heroiAtual.getAttack());

        if(monster.getHealth() <= 0)
          lastHit = heroiAtual;

        currentState.handle();

        heroes.enfileirar(heroiAtual);
        i++;
      }
    }

    public boolean isFinished() {
      return currentState.isFinished();
    }

    public String getResult() {
      return currentState.getResult();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //TODO implementar clone razo
        return super.clone();
    }

    public Unit getMonster() {
      return monster;
    }

    public void setMonster(Unit monster) {
      this.monster = monster;
    }

    public HeroQueue getHeroes() {
      return heroes;
    }

    public void setHeroes(HeroQueue heroes) {
      this.heroes = heroes;
    }

    public int getSpecial() {
      return special;
    }

    public void setSpecial(int special) {
      this.special = special;
    }

    public int getBuffStrength() {
      return buffStrength;
    }

    public void setBuffStrength(int buffStrength) {
      this.buffStrength = buffStrength;
    }

    public int getBuffCharges() {
      return buffCharges;
    }

    public void setBuffCharges(int buffCharges) {
      this.buffCharges = buffCharges;
    }

    public int getTankValue() {
      return tankValue;
    }

    public void setTankValue(int tankValue) {
      this.tankValue = tankValue;
    }

    public int getRoundDamage() {
      return roundDamage;
    }

    public void setRoundDamage(int roundDamage) {
      this.roundDamage = roundDamage;
    }

    public int getCurrentTank() {
      return currentTank;
    }

    public void setCurrentTank(int currentTank) {
      this.currentTank = currentTank;
    }

    public boolean isSpecialAlive() {
      return specialAlive;
    }

    public void setSpecialAlive(boolean specialAlive) {
      this.specialAlive = specialAlive;
    }

    public State getCurrentState() {
      return currentState;
    }

    public void setCurrentState(State currentState) {
      this.currentState = currentState;
    }

    public Unit getLastHit() {
      return lastHit;
    }

    public void setLastHit(Unit lastHit) {
      this.lastHit = lastHit;
    }
    
}
