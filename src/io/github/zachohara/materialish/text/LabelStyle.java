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

package io.github.zachohara.materialish.text;

public enum LabelStyle {
	
	DISPLAY_4 ("light", 112),
	DISPLAY_3 ("regular", 56),
	DISPLAY_2 ("regular", 45),
	DISPLAY_1 ("regular", 34),
	HEADLINE ("regular", 24),
	TITLE ("medium", 20),
	SUBHEADING ("regular", 15),
	BODY_2 ("medium", 13),
	BODY_1 ("regular", 13),
	CAPTION ("regular", 12),
	BUTTON ("medium", 14);
	
	private final String weight;
	
	private final int size;
	
	private LabelStyle(String weight, int size) {
		this.weight = weight;
		this.size = size;
	}
	
	public String getWeight() {
		return this.weight;
	}
	
	public int getSize() {
		return this.size;
	}

}
