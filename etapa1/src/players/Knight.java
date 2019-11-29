package players;

import static common.Constants.HEALK;
import static common.Constants.XP1;
import static common.Constants.XP2;
import static common.Constants.XP3;
import static common.Constants.XP4;
import static common.Constants.LVL1;
import static common.Constants.LVL2;
import static common.Constants.LVL3;
import static common.Constants.LVL4;
import static common.Constants.MULTK;
import static common.Constants.DMGK;
import static common.Constants.DMGMK;
import static common.Constants.HUNDRED;
import static common.Constants.EXM;
import static common.Constants.F15;
import static common.Constants.F2;
import static common.Constants.F1;
import static common.Constants.F5;
import static common.Constants.MULTXP;
public class Knight extends Player {
    /*set position*/
    public Knight(final int pozi, final int pozj) {

        super("K", HEALK, 0, 0, pozi, pozj);
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
            setHp(HEALK + MULTK * getLevel());
            setPosiblehp(getHp());
        }
    }

    /*first ability*/
    public int execute(final Player victim, final  char type) {
        float damage = 0;
        int real = 0;
        damage = DMGK + DMGMK * this.getLevel();
        int procent = EXM +  getLevel();
        if (victim.getHp() < (procent / HUNDRED) * victim.getPosiblehp()) {
            real = victim.getHp();
            return real;
        }
        if (victim instanceof Rogue) {
            damage = damage + damage * F15;
        }
        if (victim instanceof Pyromancer) {
            damage = damage + damage * F1;
        }
        if (victim instanceof Wizard) {
            damage = damage - damage * F2;
        }
        if (type == 'L') {
            damage = damage + damage * F15;
        }
        real = Math.round(damage);
        return real;
    }
    /*second ability*/
   public int slam(final Player victim, final char type) {
        victim.setStan(true);
        victim.setNrstan(1);
        float damage = 0;
        int real = 0;
        damage = HUNDRED + MULTXP * this.getLevel();
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
        if (type == 'L') {
            damage = damage + damage * F15;
        }
        real = Math.round(damage);
        return real;
    }
    /*calculate damage*/
    public int calculatedamage(final Player victim, final char type, final int damaged) {
        return execute(victim, type) + slam(victim, type);
    }
}
