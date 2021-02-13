package third;

public class Realize extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return 10;
    }

    @Override
    public String getDescription() {
        return "Не верит своим глазам";
    }

}
