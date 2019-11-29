package players;

public class Rogue extends Player {
    private int rc;
    public Rogue(int pozi, int pozj) {
        super("R", 600, 0, 0, pozi, pozj, false);
        setIgnited(false);
        setStan(false);
        setPosiblehp(getHp());
        setRc(0);
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
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

    public int Backstab(Player victim, char type)
    {
        float damage = 0;
        int real = 0;
        damage = 200 + 20 * this.getLevel();
        if(getRc() == 3){
            if(type == 'W') {
                damage = damage+ 0.15f*damage;
            }
            setRc(0);
        }
        else {
            setRc(getRc()+1);
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

    public int Paralysis(Player victim, char type)
    {
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
        if(type == 'W')
        {
            victim.setNrparal(6);
        }
        else
        {
            victim.setNrparal(3);
        }
        real = Math.round(damage);
        return real;
    }
    public int calculatedamage(Player victim, char type, int damaged) {
        return Backstab(victim, type) + Paralysis(victim, type);
    }
}
