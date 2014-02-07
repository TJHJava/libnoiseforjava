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
 * Time: 4:19 PM
 * URL: https://github.com/michaelnugent/libnoiseforjava
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
