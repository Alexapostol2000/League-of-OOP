package players;

public class Pyromancer extends Player {
    public Pyromancer(int pozi, int pozj) {
        super("P", 500, 0, 0, pozi, pozj, false);
        setPosiblehp(getHp());
        setIgnited(false);
        setStan(false);
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
        if (isDead() == false) {
            setHp(500 + 50 * getLevel());
            setPosiblehp(getHp());
        }

    }

    public int Fireblast(Player victim, char type) {
        float damage = 0;
        int real = 0;
        damage = 350 + 50 * this.getLevel();

        if (victim instanceof Rogue) {
            damage = damage - damage * 0.2f;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * 0.2f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * 0.1f;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * 0.05f;
        }
        if (type == 'V') {
            damage = damage + damage * 0.25f;
        }
        real = Math.round(damage);
        return real;
    }

    public int Ignite(Player victim, char type) {
        float damage = 0;
        int real = 0;
        damage = 150 + 20 * getLevel();
        int damageignite = 50 + 30 * getLevel();
        victim.setDmgignite(damageignite);
        victim.setIgnited(true);
        victim.setNrignite(2);
        if (victim instanceof Rogue) {
            damage = damage - damage * 0.2f;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * 0.2f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * 0.1f;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * 0.05f;
        }
        if (type == 'V') {
            damage = damage + damage * 0.25f;
        }
        real = Math.round(damage) + victim.getDmgignite();
        return real;
    }

    @Override
    public int calculatedamage(Player victim, char type, int damaged) {
        return Ignite(victim, type) + Fireblast(victim, type);
    }
}
