// A simple interface for drawing persistent images.

import java.awt.*;

/**
 * DrawingPanel is a simple class that provides a wrapper for drawing
 * using the java.awt.Graphics methods.
 * (Updated to add support for title and location properties, getter 
 * methods, and uniform borders)
 * 
 * @author Stuart Reges, Marty Streep
 * @author Dan Jinguji 
 * @version 0.5
 */
public class DrawingPanel {

    // overall window frame
    private javax.swing.JFrame frame;
    // drawing surface
    private javax.swing.JPanel panel;
    // drawing "pen"
    private Graphics g;
    
    /**
     * Constructs a DrawingPanel object with a working area of the 
     * given size.
     * 
     * @param width The width of the drawing area in pixels
     * @param height The height of the drawing area in pixels
     */
    public DrawingPanel(int width, int height) {
        // set up an empty image onto which we will draw
        java.awt.image.BufferedImage image;
        image = new java.awt.image.BufferedImage(width, height,
            java.awt.image.BufferedImage.TYPE_INT_ARGB);
        g = image.getGraphics();
        g.setColor(Color.BLACK);
        
        // enclose the image in a label inside a panel
        javax.swing.JLabel label = new javax.swing.JLabel();
        label.setIcon(new javax.swing.ImageIcon(image));
        label.setPreferredSize(new Dimension(width, height));
        panel = new javax.swing.JPanel();
        panel.setBackground(Color.WHITE);
        panel.add(label);
        
        // set up the frame
        frame = new javax.swing.JFrame("Drawing Panel");
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
    
    /**
     * Returns the DrawingPanel's graphics context which let's you draw on
     * the DrawingPanel.
     * 
     * @return The graphics context
     */
    public Graphics getGraphics() { return g; }
    
    /**
     * Returns the window's title
     * 
     * @return The text of window title
     */
    public String getTitle() { return frame.getTitle(); }
    
    /**
     * Sets the window's title
     * 
     * @param title The text to become the title of the window
     */
    public void setTitle(String title) { frame.setTitle(title); }
    
    /**
     * Returns the background color for the drawing panel
     * 
     * @return The background color of the drawing panel
     */
    public Color getBackground() { return panel.getBackground(); }
    
    /**
     * Sets the background color for the drawing panel
     * 
     * @param c The color to become the background color
     */
    public void setBackground(Color c) { panel.setBackground(c); }
    
    /**
     * Returns whether the drawing panel is visible or not
     * 
     * @return <tt>true</tt> if it is visible, <tt>false</tt> otherwise
     */
    public boolean isVisible() { return frame.isVisible(); }
    
    /**
     * Show or hide the drawing panel
     * 
     * @param b If <tt>true</tt>, show the component; otherwise, hide
     * the component
     */
    public void setVisible(boolean b) { frame.setVisible(b); }
    
    /**
     * Sets the location for the window. 
     * 
     * @param x The x-coordinate for the window
     * @param y The y-coordinate for the window
     */
    public void setLocation(int x, int y) { frame.setLocation(x, y); }
    
    /**
     * Sets the locatino for the window.
     * 
     * @param p The point for the upper-left corner of the window
     */
    public void setLocation(java.awt.Point p) { frame.setLocation(p); }
    
    /**
     * Gets the current location of the window.
     * 
     * @return The coordinates of the upper-left corner of the window
     */
    public java.awt.Point getLocation() { return frame.getLocation(); }
    
    /**
     * Force the window to paint itself
     */
    public void repaint() { frame.repaint(); }
    
}