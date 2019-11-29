package players;
import static common.Constants.XP1;
import static common.Constants.XP2;
import static common.Constants.XP3;
import static common.Constants.XP4;
import static common.Constants.LVL1;
import static common.Constants.LVL2;
import static common.Constants.LVL3;
import static common.Constants.LVL4;
import static common.Constants.HEALW;
import static common.Constants.MULTW;
import static common.Constants.HUNDRED;
import static common.Constants.EXM;
import static common.Constants.MUL5;
import static common.Constants.F2;
import static common.Constants.F1;
import static common.Constants.F5;
import static common.Constants.F3;
import static common.Constants.F4;
import static common.Constants.MULTD;


public class Wizard extends Player {
   /*construc*/
    public Wizard(final int pozi, final int pozj) {
        super("W", HEALW, 0, 0, pozi, pozj);
        setIgnited(false);
        setStan(false);
        setPosiblehp(getHp());
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
            setHp(HEALW + MULTW * super.getLevel());
            setPosiblehp(getHp());
        }
    }
/*first ability*/
    public int drain(final Player victim, final char type) {
        float damage = 0;
        int real = 0;
        float procent = EXM + MUL5 * getLevel();
        damage = (procent / HUNDRED) * Math.min(F3 * victim.getPosiblehp(), victim.getHp());
        if (victim instanceof Rogue) {
            damage = damage - damage * F2;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * F1;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * F2;
        }
        if (victim instanceof Wizard) {
            damage = damage + damage * F5;
        }
        if (type == 'D') {
            damage = damage + damage * F1;
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
        float procent = MULTD + MUL5 * getLevel();
        damage = (procent / HUNDRED) * damaged;
        if (victim instanceof Rogue) {
            damage = damage + damage * F2;
        }
        if (victim instanceof Pyromancer) {
            damage = damage - damage * F3;
        }
        if (victim instanceof Knight) {
            damage = damage + damage * F4;
        }
        if (type == 'D') {
            damage = damage + damage * F1;
        }
        real = Math.round(damage);
        return real;
    }
/*calculate damage*/
    public int calculatedamage(final Player victim, final char type, final int damaged) {

        return drain(victim, type) + deflect(victim, type, damaged);
    }
}
