package third;

public class FallApart extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return -1;
    }

    @Override
    public String getDescription() {
        return "Развалиться на стуле";
    }

}
