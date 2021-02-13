package third;

public class PokeAround extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return 2;
    }

    @Override
    public String getDescription() {
        return "Ковыряться в зубах";
    }

}
