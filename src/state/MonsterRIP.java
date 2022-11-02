package state;

import model.Scenario;

public class MonsterRIP extends State {

    public MonsterRIP(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public String getResult() {
        if(scenario.getLastHit().isSpecial())
            return SUCCESS;
        else
            return MEDIOCRE;
    }
    
    @Override
    public void handle() {
        if(!scenario.isSpecialAlive())
            this.scenario.setCurrentState(new SpecialRIP(this.scenario));

        if(scenario.getMonster().getHealth() <= 0)
            this.scenario.setCurrentState(new MonsterRIP(this.scenario));
    }
}
