package players;

public class Rogue extends Player {
    public Rogue(int pozi, int pozj) {
        super("R", 600, 0, 0, pozi, pozj,false);
    }

    @Override
    public void levelup() {
        super.levelup();
        super.setHp(600 + 40 * super.getLevel());
    }
}
