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

import io.github.zachohara.materialish.resource.font.roboto.RobotoFont;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MaterialLabel extends StackPane {
	
	private static final int DEFAULT_WEIGHT = 2; // regular weight
	
	private final Label label;
	
	private int weight;
	private boolean italic;
	private boolean condensed;
	
	public MaterialLabel(LabelStyle style) {
		this("", style);
	}
	
	public MaterialLabel(String text, LabelStyle style) {
		this(text);
		this.setFontStyle(style.getWeight());
		this.setFontSize(style.getSize());
	}
	
	public MaterialLabel() {
		this("");
	}
	
	public MaterialLabel(String text) {
		super();
		this.label = new Label(text);
		
		this.weight = DEFAULT_WEIGHT;
		this.italic = false;
		this.condensed = false;
		
		this.updateFont();
		
		this.getChildren().add(this.label);
	}

	public final void setFontStyle(String font) {
		font = font.toLowerCase().trim();
		this.weight = RobotoFont.getWeightFromString(font);
		this.italic = font.contains("italic");
		this.condensed = font.contains("condensed");
		this.updateFont();
	}
	
	public final String getText() {
		return this.label.getText();
	}
	
	public final void setText(String text) {
		this.label.setText(text);
	}
	
	public final int getWeight() {
		return this.weight;
	}
	
	public final void setWeight(int weight) {
		this.weight = weight;
		this.updateFont();
	}
	
	public final boolean getItalic() {
		return this.italic;
	}
	
	public final void setItalic(boolean italic) {
		this.italic = italic;
		this.updateFont();
	}
	
	public final boolean getCondensed() {
		return this.condensed;
	}
	
	public final void setCondensed(boolean condensed) {
		this.condensed = condensed;
		this.updateFont();
	}
	
	public final void setToBlack() {
		this.label.setTextFill(Color.BLACK);
	}
	
	public final void setToWhite() {
		this.label.setTextFill(Color.WHITE);
	}
	
	public final double getFontSize() {
		return this.getFont().getSize();
	}
	
	public final void setFontSize(double size) {
		this.label.setFont(new Font(this.label.getFont().getName(), size));
	}
	
	public final Font getFont() {
		return this.label.getFont();
	}
	
	public final double getTextOpacity() {
		return this.label.getOpacity();
	}

	public final void setTextOpacity(double opacity) {
		this.label.setOpacity(opacity);
	}
	
	private void updateFont() {
		this.label.setFont(RobotoFont.fromProperties(this.weight, this.italic, this.condensed).getFont());
	}
	
}
