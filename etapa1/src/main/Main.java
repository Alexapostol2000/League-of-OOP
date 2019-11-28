package main;

import map.Map;
import players.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Map map = new Map(gameInput.getLength(), gameInput.getWidth(), gameInput.getTypeground());

        char[][] harta = map.Createmap();

        List<Player> players = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < gameInput.getNrpers(); i++) {
            if (gameInput.getPlayers().get(i).equals("R")) {
                Player aux = new Rogue(gameInput.getPosition().get(k), gameInput.getPosition().get(k + 1));
                players.add(aux);
            }
            if (gameInput.getPlayers().get(i).equals("W")) {
                Player aux = new Wizard(gameInput.getPosition().get(k), gameInput.getPosition().get(k + 1));
                players.add(aux);
            }
            if (gameInput.getPlayers().get(i).equals("K")) {
                Player aux = new Knight(gameInput.getPosition().get(k), gameInput.getPosition().get(k + 1));
                players.add(aux);
            }
            if (gameInput.getPlayers().get(i).equals("P")) {
                Player aux = new Pyromancer(gameInput.getPosition().get(k), gameInput.getPosition().get(k + 1));
                players.add(aux);
            }
            k += 2;
        }

        Game game = new Game();
        for (int i = 0; i < gameInput.getmRounds(); i++) {
            game.moveplayers(players, gameInput.getRounds().get(i));
            game.fight(players, harta);
        }

        FileWriter fw = new FileWriter(args[1]);
        for (Player player : players) {
            if (player.isDead() == true) {
                fw.write(player.getType() + " " + "dead");
            } else {
                fw.write(player.getType() + " " + player.getLevel() + " " + player.getXp() + " " + player.getHp()
                        + " " + player.getPozi() + " " + player.getPozj());
            }
            fw.write("\n");
        }
        fw.close();

    }
}