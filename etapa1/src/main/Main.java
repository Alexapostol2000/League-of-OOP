package main;
import map.*;
public class Main {

    public static void main(String[] args) {

        GameInputLoader gameInputLoader = new GameInputLoader(args[0],args[1]);
        GameInput gameInput = gameInputLoader.load();
        Map map = new Map(gameInput.getLength(),gameInput.getWidth(),gameInput.getTypeground());

        char [][] harta = map.Createmap();
        System.out.println(gameInput.getLength()+" "+gameInput.getWidth());
        for (int i=0;i<map.getN();i++) {
            for (int j = 0; j < map.getM(); j++)
                System.out.print(harta[i][j]);
            System.out.println();
        }
    System.out.println(gameInput.getNrpers());
        int k=0;
        for (int i=0;i<gameInput.getNrpers();i++){
            System.out.println(gameInput.getPlayers().get(i)+" "+gameInput.getPosition().get(k)+" "+gameInput.getPosition().get(k+1));
        k+=2;
        }
    System.out.println(gameInput.getmRounds());
        for (int i=0;i<gameInput.getmRounds();i++)
        {
            System.out.println(gameInput.getRounds().get(i));
        }
    for (int i=0;i<map.getN();i++) {
        for (int j = 0; j < map.getM(); j++)
            System.out.print(harta[i][j]);
        System.out.println();
    }
    }
}