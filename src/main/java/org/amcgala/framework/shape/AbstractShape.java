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
package org.amcgala.framework.shape;

import org.amcgala.framework.animation.Animation;
import org.amcgala.framework.math.Matrix;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.raytracer.Ray;
import org.amcgala.framework.raytracer.ShadingInfo;
import org.amcgala.framework.raytracer.material.Material;
import org.amcgala.framework.renderer.Renderer;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.shape.util.bounds.BoundingBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Diese Klasse stellt die Oberklasse aller darstellbaren Objekte dar.
 *
 * @author Robert Giacinto
 */
public abstract class AbstractShape implements Shape {

    private static final Logger log = LoggerFactory.getLogger(AbstractShape.class);
    private Animation animation;
    private Node node;
    protected String label = getClass().getSimpleName() + " - " + System.nanoTime();
    protected BoundingBox boundingBox = new BoundingBox();
    protected RGBColor color = new RGBColor(0, 0, 0);
    protected Material material = new Material();


    @Override
    public Color getColor() {
        return color.toColor();
    }

    @Override
    public void setColor(Color color) {
        float [] colors = color.getColorComponents(null);
        this.color = new RGBColor(colors[0], colors[1], colors[2]);
    }

    @Override
    public void setColor(RGBColor color) {
        this.color = color;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void update() {
        if (animation != null) {
            animation.update();
        }
    }

    @Override
    public void updateBoundingBox(Matrix transform) {
        boundingBox.updateBox(transform);
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }


    @Override
    public boolean hit(Ray ray, ShadingInfo shadingInfo) {
        return false;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public void render(Renderer renderer) {
        // Leere Implementierung. Sollte von Unterklassen mit Inhalt gefüllt werden,
        // wenn sie durch einen Renderer darstellbar sein sollen.
    }
}
