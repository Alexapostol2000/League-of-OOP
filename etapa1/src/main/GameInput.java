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

    public GameInput(final int mRounds, final int nrpers, final int length, final int width, final List<String> players,
                     final List<String> typeground, final List<String> rounds, final List<Integer> position) {
        this.mRounds = mRounds;
        this.nrpers = nrpers;
        this.length = length;
        this.width = width;
        this.players = players;
        this.typeground = typeground;
        this.rounds = rounds;
        this.position = position;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public int getmRounds() {
        return mRounds;
    }

    public int getNrpers() {
        return nrpers;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getTypeground() {
        return typeground;
    }

    public List<String> getRounds() {
        return rounds;
    }
}
