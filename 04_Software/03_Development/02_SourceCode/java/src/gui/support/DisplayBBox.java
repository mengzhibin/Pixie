/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.support;

import java.awt.Rectangle;
import java.awt.Color;

/**
 * Encapsulate the needed information to be able to display bounding boxes. They
 * will not be used in the algorithms; just for display purposes.
 *
 * @author Olimpia Popica
 */
public class DisplayBBox {

    /**
     * The color of the bounding box
     */
    private final Color color;

    /**
     * The position and the size of the bounding box.
     */
    private final Rectangle panelBox;

    /**
     * The text to be displayed on top of the box.
     */
    private final String text;

    /**
     * Shows how the representation of the polygon shall be: true = the line
     * drawn is dashed, false = the line drawn is solid.
     */
    private final boolean useDashedLine;

    /**
     * Instantiates a new Display b box.
     *
     * @param panelBox      the panel box
     * @param color         the color
     * @param useDashedLine the use dashed line
     */
    public DisplayBBox(Rectangle panelBox, Color color, boolean useDashedLine) {
        this.color = color;
        this.panelBox = panelBox;
        this.text = "";
        this.useDashedLine = useDashedLine;
    }

    /**
     * Instantiates a new Display b box.
     *
     * @param panelBox      the panel box
     * @param color         the color
     * @param text          the text
     * @param useDashedLine the use dashed line
     */
    public DisplayBBox(Rectangle panelBox, Color color, String text, boolean useDashedLine) {
        this.color = color;
        this.panelBox = panelBox;
        this.text = text;
        this.useDashedLine = useDashedLine;
    }

    /**
     * The color of the box.
     *
     * @return the color used to draw the box
     */
    public Color getColor() {
        return color;
    }

    /**
     * The rectangle to be displayed.
     *
     * @return the rectangle to be drawn
     */
    public Rectangle getPanelBox() {
        return panelBox;
    }

    /**
     * The text to be displayed on top of the box.
     *
     * @return text to be displayed with the box
     */
    public String getText() {
        return text;
    }

    /**
     * Shows how the representation of the polygon shall be.
     *
     * @return true = the line drawn is dashed, false = the line drawn is solid
     */
    public boolean isUseDashedLine() {
        return useDashedLine;
    }

    /**
     * Equal panels boolean.
     *
     * @param pos the pos
     * @return the boolean
     */
    public boolean equalPanels(Rectangle pos) {
        return panelBox.equals(pos);
    }
}
