package players;
import static common.Constants.XP1;
import static common.Constants.XP2;
import static common.Constants.XP3;
import static common.Constants.XP4;
import static common.Constants.LVL1;
import static common.Constants.LVL2;
import static common.Constants.LVL3;
import static common.Constants.LVL4;
import static common.Constants.LVL6;
import static common.Constants.F2;
import static common.Constants.F1;
import static common.Constants.F15;
import static common.Constants.F25;
import static common.Constants.MULTXP;
import static common.Constants.HEALR;
import static common.Constants.DMGK;
import static common.Constants.EXM;
import static common.Constants.EXR;

public class Rogue extends Player {
    private int rc;
/*cosntruct more*/
    public Rogue(final int pozi, final int pozj) {
        super("R", HEALR, 0, 0, pozi, pozj);
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
        if (!isDead() && getLevel() != 0) {
            setHp(HEALR + MULTXP * getLevel());
            setPosiblehp(getHp());
        }
    }
/*first ability*/
    public int backstab(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        damage = DMGK + EXM * this.getLevel();
        if (getRc() == LVL3) {
            if (type == 'W') {
                damage = damage + F15 * damage;
            }
            setRc(0);
        } else {
            setRc(getRc() + 1);
        }

        if (victim instanceof Rogue) {
            damage = damage + damage * F2;
        }
        if (victim instanceof Knight) {
            damage = damage - damage * F1;
        }
        if (victim instanceof Pyromancer) {
            damage = damage + damage * F25;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * F25;
        }
        if (type == 'W') {
            damage = damage + damage * F15;
        }
        real = Math.round(damage);
        return real;
    }
/*secound ability*/
    public int paralysis(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        damage = MULTXP + EXR * this.getLevel();
        if (victim instanceof Rogue) {
            damage = damage - damage * F1;
        }
        if (victim instanceof Knight) {
            damage = damage - damage * F2;
        }
        if (victim instanceof Pyromancer) {
            damage = damage + damage * F2;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * F25;
        }
        if (type == 'W') {
            damage = damage + damage * F15;
        }
        victim.setParal(true);
        victim.setDmgparal(Math.round(damage));
        if (type == 'W') {
            victim.setNrparal(LVL6);
        } else {
            victim.setNrparal(LVL3);
        }
        real = Math.round(damage);
        return real;
    }
/*calculate damage*/
    public int calculatedamage(final Player victim, final char type, final int damaged) {
        return backstab(victim, type) + paralysis(victim, type);
    }
}
