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
    private boolean ignited;
    private int dmgignite;
    private int nrignite;
    private int posiblehp;

    public Player(String type, int hp, int xp, int level, int pozi, int pozj, boolean dead) {
        this.type = type;
        this.hp = hp;
        this.xp = xp;
        this.level = level;
        this.pozi = pozi;
        this.pozj = pozj;
        this.dead = dead;
    }

    public int getPosiblehp() {
        return posiblehp;
    }

    public void setPosiblehp(int posiblehp) {
        this.posiblehp = posiblehp;
    }

    public int getNrignite() {
        return nrignite;
    }

    public void setNrignite(int nrignite) {
        this.nrignite = nrignite;
    }

    public boolean isIgnited() {
        return ignited;
    }

    public void setIgnited(boolean ignited) {
        this.ignited = ignited;
    }

    public int getDmgignite() {
        return dmgignite;
    }

    public void setDmgignite(int dmgignite) {
        this.dmgignite = dmgignite;
    }

    @Override
    public String toString() {
        return "Player{" +
                "type='" + type + '\'' +
                ", hp=" + hp +
                ", xp=" + xp +
                ", level=" + level +
                ", pozi=" + pozi +
                ", pozj=" + pozj +
                ", dead=" + dead +
                ", stan=" + stan +
                ", ignited=" + ignited +
                ", dmgignite=" + dmgignite +
                '}';
    }

    public void getdamage(int damage) {
        if (getHp() <= damage) {
            setHp(0);
            setDead(true);
        } else {
            int hp = getHp();
            hp -= damage;
            setHp(hp);
        }
    }

    public void levelup() {

    }


    public boolean isStan() {
        return stan;
    }

    public void setStan(boolean stan) {
        this.stan = stan;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        levelup();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPozi() {
        return pozi;
    }

    public void setPozi(int pozi) {
        this.pozi = pozi;
    }

    public int getPozj() {
        return pozj;
    }

    public void setPozj(int pozj) {
        this.pozj = pozj;
    }

    public int calculatedamage(Player player, char type,int damaged) {
        return 0;
    }
}

