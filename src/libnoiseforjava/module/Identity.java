package libnoiseforjava.module;

/**
 * Created by IntelliJ IDEA.
 * User: mike
 * Date: 2/5/12
 * Time: 4:19 PM
 * Package: libnoiseforjava.module
 */
public class Identity extends ModuleBase {

    AXIS axis = AXIS.Y;

    public enum AXIS {
        X,
        Y,
        Z
    };

    public Identity() {
        super();
    }

    public Identity( AXIS axis ) {
        super();
        this.axis = axis;
    }

    public void setAxis( AXIS axis ) {
        this.axis = axis;
    }

    public double getValue(double x, double y, double z) {
        if ( axis == AXIS.Y ) {
            return y;
        }
        else if ( axis == AXIS.X ) {
            return x;
        }
        else {
            return z;
        }
    }
}
