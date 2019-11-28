package players;

public class Pyromancer extends Player {
    public Pyromancer(int pozi, int pozj) {
        super("P", 500, 0, 0, pozi, pozj,false);
    }

    @Override
    public void levelup() {
        super.levelup();
        super.setHp(500 + 50 * super.getLevel());
    }
}
