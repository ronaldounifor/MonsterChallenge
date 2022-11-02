package model;

import java.util.ArrayList;

import state.Ongoing;
import state.State;

public class Scenario implements Cloneable {
    private Unit monster;
    private HeroQueue heroes;
    private int special;
    private boolean specialAlive;
    private State currentState;
    private Unit lastHit;
    private ArrayList<Integer> buffedHeroes;

    public Scenario() {}

    public Scenario(Unit monster, HeroQueue heroes, int special) {
      this.monster = monster;
      this.heroes = heroes;
      this.special = special;
      this.specialAlive = true;
      this.currentState = new Ongoing(this);
      this.buffedHeroes = new ArrayList<>();
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

    public void applyBuff(int heroPosition, int buffStrength) {
      heroes.applyBuff(heroPosition, buffStrength);
      buffedHeroes.add(heroPosition);
    }

    public boolean isFinished() {
      return currentState.isFinished();
    }

    public String getResult() {
      return currentState.getResult();
    }

    @Override
    public Scenario clone() throws CloneNotSupportedException {
        Scenario clone = new Scenario();

        clone.setMonster(monster.clone());
        clone.setHeroes(heroes.clone());
        clone.setSpecial(special);
        clone.setSpecialAlive(true);
        clone.setCurrentState(new Ongoing(clone));
        clone.setBuffedHeroes(new ArrayList<>());

        return clone;
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

    public ArrayList<Integer> getBuffedHeroes() {
      return buffedHeroes;
    }

    public void setBuffedHeroes(ArrayList<Integer> buffedHeroes) {
      this.buffedHeroes = buffedHeroes;
    }
    
}
