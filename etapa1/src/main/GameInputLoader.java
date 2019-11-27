package main;

import fileio.FileSystem;

import java.util.ArrayList;
import java.util.List;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {

        List<String> players = new ArrayList<>();
        List<String> typeground = new ArrayList<>();
        List<String> rounds = new ArrayList<>();
        List<Integer> position = new ArrayList<>();
        int mRounds=0;
        int nrpers=0;
        int length=0;
        int width=0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            length = fs.nextInt();
            width = fs.nextInt();

            for (int i = 0; i < length; ++i) {
                typeground.add(fs.nextWord());
            }
            nrpers = fs.nextInt();

            for (int i = 0; i < nrpers; ++i) {
                players.add(fs.nextWord());
                position.add(fs.nextInt());
                position.add(fs.nextInt());
            }

            mRounds = fs.nextInt();
            for (int i=0;i<mRounds;++i){
                rounds.add(fs.nextWord());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mRounds,nrpers,length,width,players,typeground,rounds,position);
    }
}
