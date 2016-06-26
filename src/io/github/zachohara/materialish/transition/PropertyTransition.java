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

import javafx.beans.property.DoubleProperty;

public class PropertyTransition extends LinearSlider {
	
	private final DoubleProperty property;
	
	public PropertyTransition(DoubleProperty property, double increment) {
		super(property.get(), increment);
		this.property = property;
	}

	@Override
	protected final void updateValue(double currentValue) {
		this.property.set(currentValue);
	}

}
