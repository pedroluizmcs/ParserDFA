package model;


public class Transition {

    private Character value;
    private State target;

    public Transition(Character value, State target) {
        this.value = value;
        this.target = target;
    }


    public Character getValue() {
        return value;
    }

    public State getTarget() {
        return target;
    }
}
