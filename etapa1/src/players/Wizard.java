package players;

public class Wizard extends Player {
   /*construc*/
    public Wizard(final int pozi, final int pozj) {
        super("W", 400, 0, 0, pozi, pozj);
        setIgnited(false);
        setStan(false);
        setPosiblehp(getHp());
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
            setHp(400 + 30 * super.getLevel());
            setPosiblehp(getHp());
        }
    }
/*first ability*/
    public int drain(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        float procent = 20 + 5 * getLevel();
        damage = (procent / 100) * Math.min(0.3f * victim.getPosiblehp(), victim.getHp());
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
        if (type == 'D') {
            damage = damage + damage * 0.1f;
        }
        real = Math.round(damage);
        return real;

    }
/*second ability*/
    public int deflect(final Player victim, final char type, final int damaged) {
        float damage = 0;
        int real = 0;
        /*
        if (victim instanceof Knight) {

        }
        */
        if (victim instanceof Wizard) {
            return real;
        }
        float procent = 35 + 5 * getLevel();
        damage = (procent / 100) * damaged;
        if (victim instanceof Rogue) {
            damage = damage + damage * 0.2f;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * 0.3f;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * 0.4f;
        }
        if (type == 'D') {
            damage = damage + damage * 0.1f;
        }
        real = Math.round(damage);
        return real;

    }
/*calculate damage*/
    public int calculatedamage(final Player victim, final char type, final int damaged) {

        return drain(victim, type) + deflect(victim, type, damaged);
    }
}
