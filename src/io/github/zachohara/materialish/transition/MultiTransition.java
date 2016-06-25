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

import java.util.LinkedList;
import java.util.List;

public class MultiTransition<T extends MultiTransition<T>> extends MaterialTransition<T> {
	
	private final List<MaterialTransition<?>> transitionList;
	
	public MultiTransition() {
		super();
		this.transitionList = new LinkedList<MaterialTransition<?>>();
	}
	
	public final void addTransition(MaterialTransition<?> transition) {
		this.transitionList.add(transition);
	}

	@Override
	public final void interpolate(double fraction) {
		for (MaterialTransition<?> t : this.transitionList) {
			t.interpolate(fraction);
		}
	}

}
