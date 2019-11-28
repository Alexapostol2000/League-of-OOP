package players;

public class Rogue extends Player {
    public Rogue(int pozi, int pozj) {
        super("R", 600, 0, 0, pozi, pozj, false);
        setIgnited(false);
        setStan(false);
    }

    @Override
    public void levelup() {
        if (isDead() == false) {
            super.levelup();
            super.setHp(600 + 40 * super.getLevel());
        }
    }
}
