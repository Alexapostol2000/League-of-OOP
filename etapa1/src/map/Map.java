package map;

import java.util.List;

public class Map {
    private int n;
    private int m;
    private List<String> typeground;

    public Map(final int n, final int m, final List<String> typeground) {
        this.n = n;
        this.m = m;
        this.typeground = typeground;
    }

    /*creeaza harta*/
    public char[][] createmap() {
        char[][] map = new char[n][m];
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getM(); j++) {
                for (int k = 0; k < getTypeground().size(); k++) {
                    map[i][j] = getTypeground().get(j).charAt(k);
                }
            }
        }
        return map;
    }

    /*returneaza nr de linii*/
    public int getN() {
        return n;
    }

    /*returneaza nr de coloane*/
    public int getM() {
        return m;
    }

    /*returneaza lista cu tipurile terenurilor*/
    public List<String> getTypeground() {
        return typeground;
    }


}
