package state;

import model.Scenario;

public abstract class State {
    public static final String SUCCESS = "success";
    public static final String MEDIOCRE = "mediocre";
    public static final String PENDING = "pending";
    public static final String FAILURE = "failure";

    protected Scenario scenario;

    public abstract boolean isFinished();
    public abstract String getResult();
    public abstract void handle();
}
