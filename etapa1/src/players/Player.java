package players;

public abstract class Player {
    private String type;
    private int hp;
    private int xp;
    private int level;
    private int pozi;
    private int pozj;
    private boolean dead;
    private boolean stan;
    private int nrstan;
    private boolean ignited;
    private int dmgignite;
    private int nrignite;
    private int dmgparal;
    private int nrparal;
    private boolean paral;
    private int posiblehp;
/*construct player*/
    public Player(final String type, final int hp, final int xp, final int level,
                  final int pozi, final int pozj) {
        this.type = type;
        this.hp = hp;
        this.xp = xp;
        this.level = level;
        this.pozi = pozi;
        this.pozj = pozj;
        this.dead = false;
    }
/*return nrrundestan*/
    public int getNrstan() {
        return nrstan;
    }
/*seteazanrderundestan*/
    public void setNrstan(final int nrstan) {
        this.nrstan = nrstan;
    }
/*returneaza hp maxim la level lui*/
    public int getPosiblehp() {
        return posiblehp;
    }
/*seteaza hp maxim posibil*/
    public void setPosiblehp(final int posiblehp) {
        this.posiblehp = posiblehp;
    }
/*returneaza nr de runde cu ignite*/
    public int getNrignite() {
        return nrignite;
    }
/*seteaza nr de runde cu ignite*/
    public void setNrignite(final int nrignite) {
        this.nrignite = nrignite;
    }
/*returneaza daca e afectat de ignite*/
    public boolean isIgnited() {
        return ignited;
    }
/*seteaza daca e afectat de ignite*/
    public void setIgnited(final boolean ignited) {
        this.ignited = ignited;
    }
/*damage dat de ignite*/
    public int getDmgignite() {
        return dmgignite;
    }
/*seteaza damage-ul dat de ignite*/
    public void setDmgignite(final int dmgignite) {
        this.dmgignite = dmgignite;
    }
/*afisare*/
    @Override
    public String toString() {
        return "Player{"
                + "type='" + type + '\''
                + ", hp=" + hp
                + ", xp=" + xp
                + ", level=" + level
                + ", pozi=" + pozi
                + ", pozj=" + pozj
                + ", dead=" + dead
                + ", stan=" + stan
                + ", ignited=" + ignited
                + ", dmgignite=" + dmgignite + '}';
    }
/*aplica damage pe player*/
    public void getdamage(final int damage) {
        if (getHp() <= damage) {
            setHp(0);
            setDead(true);
        } else {
            int hp = getHp();
            hp -= damage;
            setHp(hp);
        }
    }
/*returneaza daca are stan*/
    public boolean isParal() {
        return paral;
    }
/*seteaza daca are stan*/
    public void setParal(final boolean paral) {
        this.paral = paral;
    }
/*level manager*/
    public void levelup() {

    }
/*return numar de runde paralizat*/
    public int getNrparal() {
        return nrparal;
    }
/*seteaza numarul de runde cu stan*/
    public void setNrparal(final int nrparal) {
        this.nrparal = nrparal;
    }
/*return damage cand e afectat de paralizie*/
    public int getDmgparal() {
        return dmgparal;
    }
/*seteaza damage-ul paraliziei*/
    public void setDmgparal(final int dmgparal) {
        this.dmgparal = dmgparal;
    }
/*returneaza daca are stan*/
    public boolean isStan() {
        return stan;
    }
/*seteaza daca are stan*/
    public void setStan(final boolean stan) {
        this.stan = stan;
    }

/*returneaza typul de player*/
    public String getType() {
        return type;
    }
/*seteaza tipul de player*/
    public void setType(final String type) {
        this.type = type;
    }
/*returneaza daca e mort*/
    public boolean isDead() {
        return dead;
    }
/*seteaza daca a murit*/
    public void setDead(final boolean dead) {
        this.dead = dead;
    }
/*returneaza hp*/
    public int getHp() {
        return hp;
    }
/*seteaza hp*/
    public void setHp(final int hp) {
        this.hp = hp;
    }
/*returneaza xp-ul*/
    public int getXp() {
        return xp;
    }
/*seteaza valoare de xp*/
    public void setXp(final int xp) {
        this.xp = xp;
        levelup();
    }
/*returneaza level-ul*/
    public int getLevel() {
        return level;
    }
/*seteaza level-ul*/
    public void setLevel(final int level) {
        this.level = level;
    }
/*returneaza pozitia*/
    public int getPozi() {
        return pozi;
    }
/*seteaza pozitia */
    public void setPozi(final int pozi) {
        this.pozi = pozi;
    }
    /*returneaza pozitia*/
    public int getPozj() {
        return pozj;
    }
/*seteaza pozitia*/
    public void setPozj(final int pozj) {
        this.pozj = pozj;
    }
/*calculeaza damageul dat*/
    public int calculatedamage(final Player player, final char type, final int damaged) {
        return 0;
    }
}

