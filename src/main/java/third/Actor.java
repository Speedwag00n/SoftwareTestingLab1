package third;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Actor {

    private String name;
    private List<Action> actions = new ArrayList<>();
    private int tension = 0;

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, Integer tension) {
        this.name = name;
        this.tension = tension;
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Integer getActionNumber(Action action) {
        if (actions.contains(action)) {
            return actions.indexOf(action);
        } else {
            return null;
        }
    }

    public int getTension() {
        return tension;
    }

    public int setTension(int tension) {
        if (tension > 10) {
            this.tension = 10;
        } else if (tension < 0) {
            this.tension = 0;
        } else {
            this.tension = tension;
        }

        return tension;
    }

    public int changeTension(int value) {
        int newValue = tension + value;
        if (newValue > 10) {
            this.tension = 10;
        } else if (newValue < 0) {
            this.tension = 0;
        } else {
            this.tension = newValue;
        }

        return tension;
    }

    public void doAction(int actionNumber) throws IllegalArgumentException {
        if (actionNumber >= 0 && actionNumber < actions.size()) {
            System.out.println(name + " выполнеяет действие...");
            changeTension(actions.get(actionNumber).doAction());
        } else {
            throw new IllegalArgumentException("Action with specified number doesn't exist");
        }
    }
}
