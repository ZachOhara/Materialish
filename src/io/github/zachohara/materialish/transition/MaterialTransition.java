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

import io.github.zachohara.materialish.transition.interpolator.BezierInterpolator;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public abstract class MaterialTransition extends Transition implements EventHandler<ActionEvent> {
	
	private static final Interpolator STANDARD_INTERPOLATOR = BezierInterpolator.STANDARD;
	
	private final List<TransitionCompletionListener> completionListeners;
	private final List<TransitionProgressListener> progressListeners;
	
	public MaterialTransition() {
		super();
		this.setInterpolator(STANDARD_INTERPOLATOR);
		
		this.completionListeners = new LinkedList<TransitionCompletionListener>();
		this.progressListeners = new LinkedList<TransitionProgressListener>();
		
		this.setOnFinished(this);
	}
	
	public final void setMilliDuration(double millis) {
		this.setCycleDuration(Duration.millis(millis));
	}
	
	public final void addCompletionListener(TransitionCompletionListener completionListener) {
		this.completionListeners.add(completionListener);
	}
	
	public final void addProgressListener(TransitionProgressListener progressListener) {
		this.progressListeners.add(progressListener);
	}
	
	@Override
	public final void handle(ActionEvent event) {
		for (TransitionCompletionListener listener : this.completionListeners) {
			listener.handleTransitionCompletion(this);
		}
	}
	
	@Override
	public void interpolate(double fraction) {
		for (TransitionProgressListener listener : this.progressListeners) {
			listener.handleTransitionProgress(this, fraction);
		}
	}
	
}
