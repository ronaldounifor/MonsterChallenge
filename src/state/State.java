package state;

import model.Scenario;

public abstract class State {
    protected static final String SUCCESS = "success";
    protected static final String PENDING = "pending";
    protected static final String FAILURE = "failure";

    protected Scenario scenario;

    public abstract boolean isFinished();
    public abstract String getResult();
    public abstract void handle();
}
