package main;

import players.Player;

import java.util.List;

public class Game {
    public void fight(List<Player> players){
        for (int i=0;i<players.size()-1;i++){
            for (int j=i+1;j<players.size();j++) {
                if (players.get(i).isDead() == false && players.get(j).isDead() == false) {
                    if (players.get(i).getPozi() == players.get(j).getPozi()) {
                        if (players.get(i).getPozj() == players.get(j).getPozj()) {
                            //fSystem.out.println("fight");
                        }
                    }
                }
            }
        }
    }
public void moveplayers(List<Player> players,String move){
        for (int i=0;i<players.size();i++){
            if(players.get(i).isDead() == false){
                players.get(i).levelup();
                if(move.charAt(i) == 'U'){
                    players.get(i).setPozi(players.get(i).getPozi()-1);
                }
                if(move.charAt(i) == 'D'){
                    players.get(i).setPozi(players.get(i).getPozi()+1);
                }
                if(move.charAt(i) == 'L'){
                    players.get(i).setPozj(players.get(i).getPozj()-1);
                }
                if(move.charAt(i) == 'R'){
                    players.get(i).setPozj(players.get(i).getPozj()+1);
                }
            }
        }
}
}
