package model;


public class Transition {

    private Character value;
    private State start;
    private State finish;

    public Transition(Character value, State start, State finish) {
        this.value = value;
        this.start = start;
        this.finish = finish;
    }

    public Character getValue() {
        return value;
    }
    
    public State getStart() {
    	return start;
    }

    public State getFinish() {
        return finish;
    }
    
    public String toString() {
    	return start.getName() + " --" + this.value + "--> " + this.finish.getName();
    }
}
