/**
* CptS 131, Project 9 "Java Graphics"
*
* CafeWall: Program will draw a set of rows and grids to form a 
*           geometrical-optical illusion in which the parallel straight 
*           dividing lines between staggered rows with alternating black 
*           and white "bricks" appear to be sloped
*
* @author   Shawn Petersen
* @version  1.0
* @since    2019-11-15
*/

import java.awt.*;

public class CafeWall {
    public static final int PIXEL_SIZE = 2;
    public static final int MORTAR_SPACING = PIXEL_SIZE;   
    public static final int PANEL_WIDTH = 650;
    public static final int PANEL_HEIGHT = 400;
		
    public static void main(String[] args)  {        

        //Create panel with size 650x400
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH,PANEL_HEIGHT);

        //Set background of panel to gray        
        panel.setBackground(Color.GRAY);

        //Set Graphics panel title
        panel.setTitle("CafeWall by Shawn Petersen");

        //Graphics panel
        Graphics g = panel.getGraphics();
        
        //Draw rows      
        drawRow(0, 0, 4, 20, g);
        drawRow(50, 70, 5, 30, g);      
      
        //Draw grid
        drawGrid(400, 20, 2, 35, 35, g);       
        drawGrid(10, 150, 4, 25, 0, g);        
        drawGrid(250, 200, 3, 25, 10, g);     
        drawGrid(425, 180, 5, 20, 10, g);     

	}	


//***************************************************************************
//
// Static Methods Defines
//
//***************************************************************************

	//***************************************************************************
	/** 
    * Draw a series of black, white boxes in a row.  The boxes have a blue
    * x-cross drawn from corner to corner
	*
	* @param xCord      x-coordinate on grid
	* @param yCord      y-coordinate on grid
	* @param rowPairs   number of boxes in pairs to draw
	* @param boxSize    size of box to draw
	* @param g          Graphics Class passed
	*
	*/
    public static void drawRow( int xCord, 
                                int yCord, 
                                int rowPairs, 
                                int boxSize, 
                                Graphics g)
    {

        //Are Row Pairs are valid
        if (rowPairs < 1) 
        {
            throw new IllegalArgumentException( "Row Pairs need to be greater " +
                                                " or equal to 1");
        }


       for (int i = 0; i < rowPairs; i++)
       {    
            //Draw Black box
            g.setColor(Color.BLACK);
            g.fillRect( xCord + 2 * (i * boxSize), 
                        yCord, 
                        boxSize, 
                        boxSize);
           
            //Draw white box
            g.setColor(Color.WHITE);
            g.fillRect( xCord + 2 * (i * boxSize) + boxSize, 
                        yCord, 
                        boxSize,
                        boxSize);

            //Draw blue x-cross
            g.setColor(Color.BLUE);
            g.drawLine( xCord + 2 * i * boxSize, 
                        yCord, 
                        xCord + 2 * i * boxSize + boxSize, 
                        yCord + boxSize);                  

            g.drawLine( xCord + 2 * i * boxSize, 
                        yCord + boxSize, 
                        xCord + 2 * i *boxSize + boxSize,
                        yCord);
         }
     }

    /** draws a grid by calling drawRow multiple times
    *
    * @param xCoordinate x-coordinate of the top-left box
    * @param yCoordinate y-coordinate of the first row
    * @param rowPairs  number of boxes in pairs per row plus number of rows in the grid
    * @param boxSize width & height of box (square)
    * @param offset length to offset second row of the pair relative to the first row
    * @param g Graphics Class passed    
    */
     public static void drawGrid(   int xCoordinate, 
                                    int yCoordinate,
                                    int rowPairs, 
                                    int boxSize,
                                    int offset,
                                    Graphics g) 
     {   
         for (int rowNumber = 0; rowNumber < rowPairs * 2; rowNumber++)
         {
            drawRow( xCoordinate + (offset * (rowNumber % 2)), 
                     yCoordinate + (boxSize * rowNumber) + (MORTAR_SPACING * rowNumber), 
                     rowPairs, 
                     boxSize,
                     g); 
         }
     }

  }