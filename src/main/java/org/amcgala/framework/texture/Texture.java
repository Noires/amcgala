/*
 * Copyright 2011 Cologne University of Applied Sciences Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.amcgala.framework.texture;

import java.awt.Color;

import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.shape.textured.TexturedBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Klasse zum Laden von Texturen in amCGAla.
 * @author Sascha Lemke
 */
public class Texture {

	private String texture;
	
	public Texture(String texture) {
		this.texture = texture;
	}
	
	/**
	 * Gibt die Farbe eines Objektes im Bezug auf die Textur zurueck.
	 * @param position Die Position im 3D-Raum.
	 * @return Die Farbe des Pixels auf der Textur.
	 */
	protected Color getPixelColor(Vector3d position) {
		return null;
	}

	public String toString() {
		return "Textur:" + this.texture;
	}
	
	private static final Logger log = LoggerFactory.getLogger(TexturedBox.class.getName());
}
