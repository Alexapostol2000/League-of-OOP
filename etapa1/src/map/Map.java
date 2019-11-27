package map;

import java.util.List;

public class Map {
    private int n;
    private int m;
    private List<String> typeground;

    public char[][] Createmap()
    {  char[][] map = new char[n][m];
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getM(); j++) {
                for (int k=0;k<getTypeground().size();k++) {
                    map[i][j] = getTypeground().get(j).charAt(k);
                }
                }
        }
        return map;
    }

    public Map(int n, int m, List<String> typeground) {
        this.n = n;
        this.m = m;
        this.typeground = typeground;
    }

        public int getN() {
        return n;
    }

        public int getM() {
        return m;
    }


        public List<String> getTypeground() {
        return typeground;
    }



}
