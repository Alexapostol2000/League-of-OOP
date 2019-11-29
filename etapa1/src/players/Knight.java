package players;

public class Knight extends Player {
    public Knight(int pozi, int pozj) {

        super("K", 900, 0, 0, pozi, pozj, false);
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
            setHp(900 + 80 * getLevel());
            setPosiblehp(getHp());
        }
    }

    int Execute(Player victim, char type) {
        float damage = 0;
        int real = 0;
        damage = 200 + 30 * this.getLevel();
        int procent = 20 + 1 * getLevel();
        if (victim.getHp() < (procent / 100) * victim.getPosiblehp()) {
            real = victim.getHp();
            return real;
        }
        if (victim instanceof Rogue) {
            damage = damage + damage * 0.15f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage + damage * 0.1f;
        }
        if (victim instanceof Wizard) {
            damage = damage - damage * 0.2f;
        }
        if (type == 'L') {
            damage = damage + damage * 0.15f;
        }
        real = Math.round(damage);
        return real;
    }

    int Slam(Player victim, char type) {
        victim.setStan(true);
        victim.setNrstan(1);
        float damage = 0;
        int real = 0;
        damage = 100 + 40 * this.getLevel();
        if (victim instanceof Rogue) {
            damage = damage - damage * 0.2f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * 0.1f;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * 0.2f;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * 0.05f;
        }
        if (type == 'L') {
            damage = damage + damage * 0.15f;
        }
        real = Math.round(damage);
        return real;
    }

    public int calculatedamage(Player victim, char type, int damaged) {
        return Execute(victim, type) + Slam(victim, type);
    }
}
