package libnoiseforjava.module;

import libnoiseforjava.exception.ExceptionInvalidParam;

/**
 * Created by IntelliJ IDEA.
 * User: mike
 * Date: 2/18/12
 * Time: 11:57 PM
 * Package: libnoiseforjava.module
 */
public class Intersection extends ModuleBase {
    double cutoff;
    public Intersection(ModuleBase sourceModuleOne, ModuleBase sourceModuleTwo, double cutoff) throws ExceptionInvalidParam
    {
        super(2);
        setSourceModule(0, sourceModuleOne);
        setSourceModule(1, sourceModuleTwo);
        this.cutoff = cutoff;
    }

    public double getValue (double x, double y, double z)
    {
        assert (sourceModules[0] != null);
        assert (sourceModules[1] != null);

        double s1 = sourceModules[0].getValue(x,y,z);
        double s2 = sourceModules[1].getValue(x,y,z);

        if ( s1 + cutoff > s2 && s1 - cutoff < s2 ) {
            return s1;
        }
        else {
            return -1;
        }
    }
}
