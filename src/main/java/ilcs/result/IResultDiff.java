package ilcs.result;

import ilcs.grain.Grain;
import java.util.List;

/**
 * IResultDiff
 * @author Fernanda Floriano Silva
 */
public interface IResultDiff {

    /**
     * Get Grains From
     * @return List<Grain>
     */
    List<Grain> getGrainsFrom();

    /**
     * Get Grains To
     * @return List<Grain>
     */
    List<Grain> getGrainsTo();

    /**
     * Get list with differences 
     * @return List<Grain>
     */
    List<Grain> getDifferences();

    /**
     * Clean Result
     */
    void cleanResult();
}
