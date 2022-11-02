package state;

import model.Scenario;

public class Ongoing extends State {

    public Ongoing(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getResult() {
        return PENDING;
    }
    
    @Override
    public void handle() {
        if(!scenario.isSpecialAlive())
            this.scenario.setCurrentState(new SpecialRIP(this.scenario));

        if(scenario.getMonster().getHealth() <= 0)
            this.scenario.setCurrentState(new MonsterRIP(this.scenario));
    }
}
