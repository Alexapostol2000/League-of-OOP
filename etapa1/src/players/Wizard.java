package players;

public class Wizard extends Player {
    public Wizard(int pozi, int pozj) {
        super("W", 400, 0, 0, pozi, pozj, false);
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
            setHp(400 + 30 * super.getLevel());
            setPosiblehp(getHp());
        }
    }
public int Drain(Player victim, char type)
{
    float damage = 0;
    int real = 0;
    float procent = 20 + 5*getLevel();
    damage = (procent/100)*Math.min(0.3f*victim.getPosiblehp(),victim.getHp());
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
public int Deflect(Player victim, char type,int damaged)
{
    float damage = 0;
    int real = 0;
    if(victim instanceof Knight)
    {

    }
    if(victim instanceof Wizard)
    {
        return real;
    }
    float procent = 35 + 5*getLevel();
    damage = (procent/100)*damaged;
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
    public int calculatedamage(Player victim, char type,int damaged) {

        return Drain(victim, type) + Deflect(victim, type,damaged);
    }
}
