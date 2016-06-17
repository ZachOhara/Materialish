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

package io.github.zachohara.materialish.resource.font.roboto;

import javafx.scene.text.Font;

public enum RobotoFont {
	
	THIN ("-Thin"),
	THIN_ITALIC ("-ThinItalic"),
	LIGHT ("-Light"),
	LIGHT_ITALIC ("-LightItalic"),
	REGULAR ("-Regular"),
	REGULAR_ITALIC ("-Italic"),
	MEDIUM ("-Medium"),
	MEDIUM_ITALIC ("-MediumItalic"),
	BOLD ("-Bold"),
	BOLD_ITALIC ("-BoldItalic"),
	BLACK ("-Black"),
	BLACK_ITALIC ("-BlackItalic"),
	
	LIGHT_CONDENSED ("Condensed-Light"),
	LIGHT_CONDENSED_ITALIC ("Condensed-LightItalic"),
	CONDENSED ("Condensed-Regular"),
	CONDENSED_ITALIC ("Condensed-Italic"),
	BOLD_CONDENSED ("Condensed-Bold"),
	BOLD_CONDENSED_ITALIC ("Condensed-BoldItalic");
	
	private static final double DEFAULT_SIZE = 0;
	private static final String[] WEIGHTS = {"thin", "light", "regular", "medium", "bold", "black"};	
	private static final int DEFAULT_WEIGHT = 2; // 'regular' weight
	private final Font font;
	
	private RobotoFont(String filename) {
		filename = "Roboto" + filename + ".ttf";
		this.font = Font.loadFont(this.getClass().getResource(filename).toExternalForm(), DEFAULT_SIZE);
	}
	
	public final Font getFont() {
		return this.font;
	}
	
	public static final int getWeightFromString(String font) {
		int weight = DEFAULT_WEIGHT;
		for (int i = 0; i < WEIGHTS.length; i++) {
			if (font.contains(WEIGHTS[i])) {
				weight = i;
			}
		}
		return weight;
	}
	
	public static final RobotoFont fromProperties(int weight, boolean italic, boolean condensed) {
		if (!condensed) {
			if (!italic) {
				switch (weight) {
					default:
						return null;
					case 0:
						return THIN;
					case 1:
						return LIGHT;
					case 2:
						return REGULAR;
					case 3:
						return MEDIUM;
					case 4:
						return BOLD;
					case 5:
						return BLACK;
				}
			} else { // if italic
				switch (weight) {
					default:
						return null;
					case 0:
						return THIN_ITALIC;
					case 1:
						return LIGHT_ITALIC;
					case 2:
						return REGULAR_ITALIC;
					case 3:
						return MEDIUM_ITALIC;
					case 4:
						return BOLD_ITALIC;
					case 5:
						return BLACK_ITALIC;
				}
			}
		} else { // if condensed
			if (!italic) {
				switch (weight) {
					default:
						return null;
					case 0:
						return LIGHT_CONDENSED;
					case 1:
						return CONDENSED;
					case 2:
						return BOLD_CONDENSED;
				}
			} else { // if italic
				switch (weight) {
					default:
						return null;
					case 0:
						return LIGHT_CONDENSED_ITALIC;
					case 1:
						return CONDENSED_ITALIC;
					case 2:
						return BOLD_CONDENSED_ITALIC;
				}
			}
		}
	}
	
}
