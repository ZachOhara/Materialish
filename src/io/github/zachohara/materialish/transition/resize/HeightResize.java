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

package io.github.zachohara.materialish.transition.resize;

import io.github.zachohara.materialish.transition.LinearSlider;
import javafx.scene.layout.Region;

public class HeightResize extends LinearSlider {
	
	private final Region resizingRegion;
	
	public HeightResize(Region resizingRegion, double newHeight) {
		super(resizingRegion.getHeight(), newHeight - resizingRegion.getHeight());
		this.resizingRegion = resizingRegion;
	}

	@Override
	protected final void updateValue(double currentValue) {
		this.resizingRegion.setPrefHeight(currentValue);
	}
	
}
