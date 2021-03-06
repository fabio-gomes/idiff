package ilcs;

import idiff.IDiff;
import ilcs.result.IResultDiff;
import ilcs.algorithms.Algorithm;
import ilcs.grain.Grain;
import java.io.File;

/**
 * Diff
 * @author Fernanda Floriano Silva
 */
public class Diff {

    private final File fileVersionOne;
    private final File fileVersionTwo;

    /**
     * Constructor
     * @param fileVersionOne
     * @param fileVersionTwo
     */
    public Diff(File fileVersionOne, File fileVersionTwo) {
        this.fileVersionOne = fileVersionOne;
        this.fileVersionTwo = fileVersionTwo;
    }

    /**
     * Compare
     * @param grain
     * @param iLCSBean
     * @return IResultDiff
     * @throws DiffException 
     */
    public IResultDiff compare(Grain grain, ILCSBean iLCSBean) throws DiffException {
        IDiff comparator = Algorithm.getComparator();
        Result.clean();
        Result.getResult().setDifferences(comparator.idiff(this.fileVersionOne, this.fileVersionTwo, grain, iLCSBean));
        return Result.getResult();
    }
}
