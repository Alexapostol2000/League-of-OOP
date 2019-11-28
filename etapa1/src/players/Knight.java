package players;

public class Knight extends Player {
    public Knight(int pozi, int pozj) {
        super("K", 900, 0, 0, pozi, pozj,false);
    }

    @Override
    public void levelup() {
        super.levelup();
        super.setHp(900 + 80 * super.getLevel());
    }
}
