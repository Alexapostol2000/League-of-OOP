package players;
import static common.Constants.XP1;
import static common.Constants.XP2;
import static common.Constants.XP3;
import static common.Constants.XP4;
import static common.Constants.LVL1;
import static common.Constants.LVL2;
import static common.Constants.LVL3;
import static common.Constants.LVL4;
import static common.Constants.HEALP;
import static common.Constants.HEALM;
import static common.Constants.F2;
import static common.Constants.F1;
import static common.Constants.F5;
import static common.Constants.F25;
import static common.Constants.EXM;
import static common.Constants.DMGP;
import static common.Constants.DMGMK;


public class Pyromancer extends Player {
    /*cosntruct*/
    public Pyromancer(final int pozi, final int pozj) {
        super("P", HEALP, 0, 0, pozi, pozj);
        setPosiblehp(getHp());
        setIgnited(false);
        setStan(false);
    }
/*level manager*/
    @Override
    public void levelup() {
        if (getXp() >= XP1 && getXp() < XP2) {
            setLevel(LVL1);
        }
        if (getXp() >= XP2 && getXp() < XP3) {
            setLevel(LVL2);
        }
        if (getXp() >= XP3 && getXp() < XP4) {
            setLevel(LVL3);
        }
        if (getXp() >= XP4) {
            setLevel(LVL4);
        }
        if (!isDead()) {
            setHp(HEALP + HEALM * getLevel());
            setPosiblehp(getHp());
        }

    }
/*first ability*/
    public int fireblast(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        damage = XP3 + HEALM * this.getLevel();

        if (victim instanceof Rogue) {
            damage = damage - damage * F2;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * F2;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * F1;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * F5;
        }
        if (type == 'V') {
            damage = damage + damage * F25;
        }
        real = Math.round(damage);
        return real;
    }
/*second ability*/
    public int ignite(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        damage = DMGP + EXM * getLevel();
        int damageignite = HEALM + DMGMK * getLevel();
        victim.setDmgignite(damageignite);
        victim.setIgnited(true);
        victim.setNrignite(2);
        if (victim instanceof Rogue) {
            damage = damage - damage * F2;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * F2;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * F1;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * F5;
        }
        if (type == 'V') {
            damage = damage + damage * F25;
        }
        real = Math.round(damage) + victim.getDmgignite();
        return real;
    }
/*calculate score*/
    @Override
    public int calculatedamage(final Player victim, final char type, final int damaged) {
        return ignite(victim, type) + fireblast(victim, type);
    }
}
