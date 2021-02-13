package third;

public class PutFeet extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return -1;
    }

    @Override
    public String getDescription() {
        return "Положить ноги на пульт управления";
    }

}
