package algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * WordGrain
 * @author Fernanda Floriano Silva
 */
public class WordGrain extends Grain {

    /**
     * Constructor
     * @param word
     * @param idReference
     * @param grainBean 
     */
    public WordGrain(String word, int idReference, GrainBean grainBean) {
        super(LevelGranularity.WORD, word, idReference, grainBean);
    }

    /**
     * Constructor
     */
    public WordGrain() {
        super(LevelGranularity.WORD);
    }

    /**
     * Start word grain
     * @param list
     * @param ilcsB 
     * @return List<Grain>
     * @throws IOException 
     */
    public List<Grain> start(List<Grain> list,ILCSBean ilcsB) throws IOException {
        List<Grain> finalList = new ArrayList<Grain>();
        finalList.add(null);
        for (Iterator it = list.iterator(); it.hasNext();) {
            Grain grain = (Grain) it.next();
            if (grain != null) {
                Pattern p = Pattern.compile(ilcsB.getTags());
                String[] token = p.split(grain.getGrain());
                int idReference = 0;
                int startPosition = grain.getGrainBean().getStartPosition();
                setWordData(token, idReference, grain, startPosition, finalList);
            }

        }
        return finalList;
    }

    private void setWordData(String[] token, int idReference, Grain grain, int startPosition, List<Grain> finalList) {
        for (int i = 0; i < token.length; i++) {
            idReference++;
            WordGrain wordGrain = setData(token[i], grain, idReference, startPosition);
            if (!wordGrain.getGrain().equals("")) {
                finalList.add(wordGrain);
            }
            startPosition = setStartPosition(startPosition, wordGrain.getGrain());
        }
    }

    /**
     * Set Granularity Start Position 
     * @param startPosition
     * @param word
     * @return 
     */
    private int setStartPosition(int startPosition, String word) {
        return (startPosition + word.length() + 1);
    }

    /**
     * Set word grain data
     * @param token
     * @param grain
     * @param idReference
     * @param startPosition
     * @return WordGrain
     */
    private WordGrain setData(String token, Grain grain, int idReference, int startPosition) {
        String nextToken = token;
        GrainBean grainBean = new GrainBean(startPosition, nextToken.length());
        WordGrain wordGrain = new WordGrain(nextToken, grain.getOriginalReference().get(0), grainBean);
        wordGrain.setOriginalReference(idReference);
        wordGrain.setIdFile(grain.getIdFile());
        return wordGrain;
    }

    /**
     * Start Word Granularity
     * @param listFileFrom
     * @param listFileTo
     * @throws DiffException 
     */
    public void startWordGranularity(List<Grain> listFileFrom, List<Grain> listFileTo,ILCSBean ilcsB) throws DiffException {
        try {
            Algorithm.getComparator().setLinesFileOne(this.start(listFileFrom,ilcsB));
            Algorithm.getComparator().setColumnFileTwo(this.start(listFileTo,ilcsB));
        } catch (IOException ex) {
            throw new DiffException(ex, DiffException.MSG_INVALID_START_WORD_GRANULARITY);
        }
    }
}