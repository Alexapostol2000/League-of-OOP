package players;

public class Rogue extends Player {
    private int rc;
/*cosntruct more*/
    public Rogue(final int pozi, final int pozj) {
        super("R", 600, 0, 0, pozi, pozj);
        setIgnited(false);
        setStan(false);
        setPosiblehp(getHp());
        setRc(0);
    }
/*return round current*/
    public int getRc() {
        return rc;
    }
/*set round current*/
    public void setRc(final int rc) {
        this.rc = rc;
    }
/*level manager*/
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
        if (!isDead() && getLevel() != 0) {
            setHp(600 + 40 * getLevel());
            setPosiblehp(getHp());
        }
    }
/*first ability*/
    public int backstab(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        damage = 200 + 20 * this.getLevel();
        if (getRc() == 3) {
            if (type == 'W') {
                damage = damage + 0.15f * damage;
            }
            setRc(0);
        } else {
            setRc(getRc() + 1);
        }

        if (victim instanceof Rogue) {
            damage = damage + damage * 0.2f;
        }
        if (victim instanceof Knight) {
            damage = damage - damage * 0.1f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage + damage * 0.25f;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * 0.25f;
        }
        if (type == 'W') {
            damage = damage + damage * 0.15f;
        }
        real = Math.round(damage);
        return real;
    }
/*secound ability*/
    public int paralysis(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        damage = 40 + 10 * this.getLevel();
        if (victim instanceof Rogue) {
            damage = damage - damage * 0.1f;
        }
        if (victim instanceof Knight) {
            damage = damage - damage * 0.2f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage + damage * 0.20f;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * 0.25f;
        }
        if (type == 'W') {
            damage = damage + damage * 0.15f;
        }
        victim.setParal(true);
        victim.setDmgparal(Math.round(damage));
        if (type == 'W') {
            victim.setNrparal(6);
        } else {
            victim.setNrparal(3);
        }
        real = Math.round(damage);
        return real;
    }
/*calculate damage*/
    public int calculatedamage(final Player victim, final char type, final int damaged) {
        return backstab(victim, type) + paralysis(victim, type);
    }
}
