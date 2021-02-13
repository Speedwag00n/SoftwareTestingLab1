package third;

public class Relax extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return -10;
    }

    @Override
    public String getDescription() {
        return "Расслабиться";
    }

}
