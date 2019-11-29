package main;

import java.util.List;

public class GameInput {
    private final List<String> players;
    private final List<String> typeground;
    private final List<String> rounds;
    private final List<Integer> position;
    // DO NOT MODIFY
    private int mRounds;
    private int nrpers;
    private int length;
    private int width;

    public GameInput(final int mRounds, final int nrpers,
                     final int length, final int width, final List<String> players,
                     final List<String> typeground,
                     final List<String> rounds, final List<Integer> position) {
        this.mRounds = mRounds;
        this.nrpers = nrpers;
        this.length = length;
        this.width = width;
        this.players = players;
        this.typeground = typeground;
        this.rounds = rounds;
        this.position = position;
    }

    /*returneaza pozitiile jucatorilor*/
    public List<Integer> getPosition() {
        return position;
    }

    /*returneaza nr de runde*/
    public int getmRounds() {
        return mRounds;
    }

    /*returneaza nr de jucatori*/
    public int getNrpers() {
        return nrpers;
    }

    /*retruneaza nr de linii */
    public int getLength() {
        return length;
    }

    /*returneaza nr de coloane*/
    public int getWidth() {
        return width;
    }

    /*returneaza lista cu playeri*/
    public List<String> getPlayers() {
        return players;
    }

    /*retuneaza lista cu tipurile de terenuri*/
    public List<String> getTypeground() {
        return typeground;
    }

    /*returneaza miscarile playerilor*/
    public List<String> getRounds() {
        return rounds;
    }
}
