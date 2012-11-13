/*
 * Copyright 2011 Cologne University of Applied Sciences Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.amcgala.framework.shape.textured;

import java.awt.Color;

import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.renderer.Renderer;
import org.amcgala.framework.shape.TexturedAbstractShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Repraesentiert eine texturierte Box.
 * @author Sascha Lemke
 */
public class TexturedBox extends TexturedAbstractShape {

	private double width;
	private double height;
	private double depth;
	private Vector3d position;
	
	/**
	 * Konstruktor.
	 * @param position Die Position der Box
	 * @param width die Breite der Box
	 * @param height die Hoehe der Box
	 * @param depth die Tiefe der Box
	 */
	public TexturedBox(Vector3d position, double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.position = position;
	}
	
	/**
	 * Gibt die Farbe des entsprechenden Pixels auf Basis der Textur zurueck. 
	 * @return
	 */
	private Color getPixelColor() {
		return null;
	}
	
	public void render(Renderer renderer) {
		// rendern der texturierten box
	}
	
	private static final Logger log = LoggerFactory.getLogger(TexturedBox.class.getName());
}
