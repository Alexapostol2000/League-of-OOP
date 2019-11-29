package players;

public class Rogue extends Player {
    public Rogue(int pozi, int pozj) {
        super("R", 600, 0, 0, pozi, pozj, false);
        setIgnited(false);
        setStan(false);
        setPosiblehp(getHp());
    }

    @Override
    public void levelup() {
        if (getXp() >= 250 && getXp() < 300) {
            setLevel(1);
        }
        if (getXp() >= 300 && getXp() < 350) {
            setLevel(2);
        }
        if (getXp() >= 350 && getXp() < 400) {
            setLevel(3);
        }
        if (getXp() >= 400) {
            setLevel(4);
        }
        if (isDead() == false && getLevel() != 0) {
            setHp(600 + 40 * getLevel());
            setPosiblehp(getHp());
        }
    }



}
