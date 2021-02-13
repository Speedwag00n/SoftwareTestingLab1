package third;

public class Enter extends Action {

    @Override
    public int doAction() {
        System.out.println(getDescription());
        return 5;
    }

    @Override
    public String getDescription() {
        return "Войти следом и стать ошеломленным";
    }

}
