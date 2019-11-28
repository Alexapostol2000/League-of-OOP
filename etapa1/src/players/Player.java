package players;

public class Player {
    private String type;
    private int hp;
    private int xp;
    private int level;
    private int pozi;
    private int pozj;
    private boolean dead;


    public Player(String type, int hp, int xp, int level, int pozi, int pozj, boolean dead) {
        this.type = type;
        this.hp = hp;
        this.xp = xp;
        this.level = level;
        this.pozi = pozi;
        this.pozj = pozj;
        this.dead = dead;
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
                '}';
    }
    public void getdamage(int damage){
        if(getHp()<damage){
            setHp(0);
            setDead(true);
        }
        else {
            setHp(getHp() - damage);
        }
    }
    public void levelup() {
        if (xp >= 250 && xp < 300) {
            setLevel(1);
        }
        if (xp >= 300 && xp < 350) {
            setLevel(2);
        }
        if (xp >= 350 && xp < 400) {
            setLevel(3);
        }
        if (xp >= 400) {
            setLevel(4);
        }
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
}
