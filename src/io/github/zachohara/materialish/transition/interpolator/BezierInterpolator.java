/* Copyright (C) 2016 Zach Ohara
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.zachohara.materialish.transition.interpolator;

import javafx.animation.Interpolator;

public class BezierInterpolator extends Interpolator {
	
	public static final Interpolator STANDARD = new BezierInterpolator(new double[][] {{0.0, 0.0}, {0.4, 0.0}, {0.2, 1.0}, {1.0, 1.0}});
	public static final Interpolator SHARP = new BezierInterpolator(new double[][] {{0.0, 0.0}, {0.4, 0.0}, {0.6, 1.0}, {1.0, 1.0}});
	public static final Interpolator ACCELERATION = new BezierInterpolator(new double[][] {{0.0, 0.0}, {0.4, 0.0}, {1.0, 1.0}, {1.0, 1.0}});
	public static final Interpolator DECELERATION = new BezierInterpolator(new double[][] {{0.0, 0.0}, {0.0, 0.0}, {0.2, 1.0}, {1.0, 1.0}});
	
	private final BezierCurve interpolationCurve;
	
	public BezierInterpolator(double[][] bezierPoints) {
		this.interpolationCurve = new BezierCurve(bezierPoints);
	}
	
	@Override
	public final double curve(double t) {
		return this.interpolationCurve.getPoint(t).getY();
	}
	
}
