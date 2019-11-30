package main;

import players.Player;

import java.util.List;

import static common.Constants.MAXXP;
import static common.Constants.MULTXP;
public class Game {
    /*aici se desfasoara luptele intre playerii aflati in acelasi loc pe harta*/
    public void fight(final List<Player> players, final char[][] harta) {
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getPozi() == players.get(j).getPozi()) {
                    if (players.get(i).getPozj() == players.get(j).getPozj()) {
                        if (!players.get(i).isDead() && !players.get(j).isDead()) {
                            if (players.get(i).isIgnited()) {
                                players.get(i).getdamage(players.get(i).getDmgignite());
                                if (players.get(i).getNrignite() == 1) {
                                    players.get(i).setIgnited(false);
                                    players.get(i).setNrignite(0);
                                    players.get(i).setIgnited(false);
                                } else {
                                    players.get(i).setNrignite(players.get(i).getNrignite() - 1);
                                }
                            }
                            if (players.get(j).isIgnited()) {
                                players.get(j).getdamage(players.get(j).getDmgignite());
                                if (players.get(j).getNrignite() == 1) {
                                    players.get(j).setIgnited(false);
                                    players.get(j).setNrignite(0);
                                    players.get(j).setIgnited(false);
                                } else {
                                    players.get(j).setNrignite(players.get(j).getNrignite() - 1);
                                }
                            }

                            if (players.get(i).isParal()) {
                                players.get(i).getdamage(players.get(i).getDmgparal());
                                if (players.get(i).getNrparal() == 1) {
                                    players.get(i).setParal(false);
                                    players.get(i).setNrparal(0);
                                } else {
                                    players.get(i).setNrparal(players.get(i).getNrparal() - 1);
                                }
                            }
                            if (players.get(j).isParal()) {
                                players.get(j).getdamage(players.get(j).getDmgparal());
                                if (players.get(j).getNrparal() == 1) {
                                    players.get(j).setParal(false);
                                    players.get(j).setNrparal(0);
                                } else {
                                    players.get(j).setNrparal(players.get(j).getNrparal() - 1);
                                }
                            }
                            int damagej = 0, damagei = 0;
                            if (players.get(i).getType().equals("P")) {
                                damagei = players.get(i).calculatedamage(players.get(j),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], 0);
                            }
                            if (players.get(j).getType().equals("P")) {
                                damagej = players.get(j).calculatedamage(players.get(i),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], 0);
                            }
                            if (players.get(i).getType().equals("K")) {
                                damagei = players.get(i).calculatedamage(players.get(j),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], 0);
                            }
                            if (players.get(j).getType().equals("K")) {
                                damagej = players.get(j).calculatedamage(players.get(i),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], 0);
                            }

                            if (players.get(i).getType().equals("W")) {
                                if (players.get(j).getType().equals("W")) {
                                    damagej = players.get(j).calculatedamage(players.get(i),
                                            harta[players.get(i).getPozj()]
                                                    [players.get(i).getPozj()], 0);
                                    damagei = players.get(i).calculatedamage(players.get(j),
                                            harta[players.get(i).getPozj()]
                                                    [players.get(i).getPozj()], 0);
                                }
                            }
                            if (players.get(i).getType().equals("W")) {
                                if (!players.get(j).getType().equals("W")) {
                                    damagej = players.get(j).calculatedamage(players.get(i),
                                            harta[players.get(i).getPozj()]
                                                    [players.get(i).getPozj()], 0);
                                }
                                damagei = players.get(i).calculatedamage(players.get(j),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], damagej);
                            } else {
                                if (players.get(j).getType().equals("W")) {
                                    damagei = players.get(i).calculatedamage(players.get(j),
                                            harta[players.get(i).getPozj()]
                                                    [players.get(i).getPozj()], 0);
                                    damagej = players.get(j).calculatedamage(players.get(i),
                                            harta[players.get(i).getPozj()]
                                                    [players.get(i).getPozj()], damagei);
                                }
                            }
                            if (players.get(i).getType().equals("R")) {
                                damagei = players.get(i).calculatedamage(players.get(j),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], 0);
                            }
                            if (players.get(j).getType().equals("R")) {
                                damagej = players.get(j).calculatedamage(players.get(i),
                                        harta[players.get(i).getPozj()]
                                                [players.get(i).getPozj()], 0);
                            }

                          // System.out.println(damagei+" "+damagej);
                            players.get(i).getdamage(damagej);
                            players.get(j).getdamage(damagei);

                            if (players.get(j).isDead()) {
                                players.get(i).setXp(players.get(i).getXp() + Math.max(
                                        0, MAXXP - (players.get(i).getLevel()
                                                - players.get(j).getLevel()) * MULTXP));
                            players.get(i).levelup();
                            }

                            if (players.get(i).isDead()) {
                                players.get(j).setXp(players.get(j).getXp()
                                        + Math.max(0, MAXXP - (players.get(j).getLevel()
                                        - players.get(i).getLevel()) * MULTXP));
                            players.get(j).levelup();
                            }
                        }
                    }
                }
            }
        }
    }

    /*miscarea playerlor pe harta*/
    public void moveplayers(final List<Player> players, final String move) {
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isDead() && !players.get(i).isStan()) {

                players.get(i).levelup();
                if (move.charAt(i) == 'U') {
                    players.get(i).setPozi(players.get(i).getPozi() - 1);
                }
                if (move.charAt(i) == 'D') {
                    players.get(i).setPozi(players.get(i).getPozi() + 1);
                }
                if (move.charAt(i) == 'L') {
                    players.get(i).setPozj(players.get(i).getPozj() - 1);
                }
                if (move.charAt(i) == 'R') {
                    players.get(i).setPozj(players.get(i).getPozj() + 1);
                }
            }
            if (players.get(i).isStan()) {
                players.get(i).setNrstan(players.get(i).getNrstan() - 1);
                if (players.get(i).getNrstan() == 0) {
                    players.get(i).setStan(false);
                }
            }
        }
    }
}
