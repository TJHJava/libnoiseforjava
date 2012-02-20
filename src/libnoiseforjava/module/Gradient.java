package libnoiseforjava.module;

/**
 * Created by IntelliJ IDEA.
 * User: mike
 * Date: 2/5/12
 * Time: 4:40 PM
 * Package: libnoiseforjava.module
 */
public class Gradient extends ModuleBase {

    AXIS axis = AXIS.Y;

    double inputMin = 0;
    double inputMax = 255;

    double scaledMin = -1;
    double scaledMax = 1;

    public enum AXIS {
        X,
        Y,
        Z
    };

    public Gradient() {
        super();
    }

    public Gradient(AXIS axis) {
        super();
        this.axis = axis;
    }

    public double getValue(double x, double y, double z) {
        if (axis == AXIS.Y) {
            double outy = scale(y, this.inputMin, this.inputMax, this.scaledMin, this.scaledMax);
            System.out.println("y/outy " + y + "/" + outy);
            return outy;
        } else if (axis == AXIS.X) {
            double outx = scale(x, this.inputMin, this.inputMax, this.scaledMin, this.scaledMax);
            System.out.println("x/outx " + x + "/" + outx);
            return outx;
        } else {
            double outz = scale(z, this.inputMin, this.inputMax, this.scaledMin, this.scaledMax);
            //System.out.println("z/outz " + z + "/" + outz);
            return outz;
        }
    }

    private double scale( double inVal, double inMin, double inMax, double min, double max ) {
        double m = (max-min)/(inMax-inMin);
        double c = min-inMin*m;
        return m*inVal+c;
    }

    public AXIS getAxis() {
        return axis;
    }

    public void setAxis(AXIS axis) {
        this.axis = axis;
    }

    public double getInputMin() {
        return inputMin;
    }

    public void setInputMin(double inputMin) {
        this.inputMin = inputMin;
    }

    public double getInputMax() {
        return inputMax;
    }

    public void setInputMax(double inputMax) {
        this.inputMax = inputMax;
    }

    public double getScaledMin() {
        return scaledMin;
    }

    public void setScaledMin(double scaledMin) {
        this.scaledMin = scaledMin;
    }

    public double getScaledMax() {
        return scaledMax;
    }

    public void setScaledMax(double scaledMax) {
        this.scaledMax = scaledMax;
    }
}
