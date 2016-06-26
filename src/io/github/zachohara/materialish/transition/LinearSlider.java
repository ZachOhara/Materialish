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

package io.github.zachohara.materialish.transition;

public abstract class LinearSlider extends MaterialTransition {
	
	private final double startValue;
	private final double increment;
	
	public LinearSlider(double startValue, double increment) {
		this.startValue = startValue;
		this.increment = increment;
	}
	
	public final void interpolate(double fraction) {
		super.interpolate(fraction);
		double currentValue = startValue + (fraction * increment);
		this.updateValue(currentValue);
	}
	
	protected abstract void updateValue(double currentValue);
	
	public final double getStartValue() {
		return this.startValue;
	}
	
	public final double getIncrement() {
		return this.increment;
	}
	
	public final double getEndValue() {
		return this.startValue + this.increment;
	}
	
}
