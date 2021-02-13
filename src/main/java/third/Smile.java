package third;

public class Smile extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return -3;
    }

    @Override
    public String getDescription() {
        return "Улыбаться широко и непренужденно";
    }

}
