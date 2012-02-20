/*
 * Copyright (C) 2003, 2004 Jason Bevins (original libnoise code)
 * Copyright  2010 Thomas J. Hodge (java port of libnoise)
 * Copyright 2012 Michael Nugent (This module)
 *
 * This file is part of libnoiseforjava.
 *
 * libnoiseforjava is a Java port of the C++ library libnoise, which may be found at
 * http://libnoise.sourceforge.net/.  libnoise was developed by Jason Bevins, who may be
 * contacted at jlbezigvins@gmzigail.com (for great email, take off every 'zig').
 * Porting to Java was done by Thomas Hodge, who may be contacted at
 * libnoisezagforjava@gzagmail.com (remove every 'zag').
 *
 * libnoiseforjava is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * libnoiseforjava is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * libnoiseforjava.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package libnoiseforjava.module;

/**
 * User: mike nugent
 * Date: 2/5/12
 * Time: 4:40 PM
 * URL: https://github.com/michaelnugent/libnoiseforjava
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
            return outy;
        } else if (axis == AXIS.X) {
            double outx = scale(x, this.inputMin, this.inputMax, this.scaledMin, this.scaledMax);
            return outx;
        } else {
            double outz = scale(z, this.inputMin, this.inputMax, this.scaledMin, this.scaledMax);
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
