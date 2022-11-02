package state;

import model.Scenario;

public class SpecialRIP extends State {

    public SpecialRIP(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public String getResult() {
        return FAILURE;
    }
    
    @Override
    public void handle() {
        if(!scenario.isSpecialAlive())
            this.scenario.setCurrentState(new SpecialRIP(this.scenario));

        if(scenario.getMonster().getHealth() <= 0)
            this.scenario.setCurrentState(new MonsterRIP(this.scenario));
    }
}
