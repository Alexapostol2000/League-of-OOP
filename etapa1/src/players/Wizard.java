package players;

public class Wizard extends Player {
    public Wizard(int pozi, int pozj) {
        super("W", 400, 0, 0, pozi, pozj,false);
    }

    @Override
    public void levelup() {
        super.levelup();
        super.setHp(400 + 30 * super.getLevel());
    }
}
