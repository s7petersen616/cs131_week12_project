/**
* CptS 131, Project 9 "Object Oriented Programming"
*
* CafeWall: Program will convert temperature value the user sets on 
*
*						
*                       
*
* @author   Shawn Petersen
* @version  1.0
* @since    2019-11-15
*/


import java.awt.*;

public class CafeWall {
    public static final int PIXEL_SIZE = 2;
    public static final int SPACE_MORTAR = PIXEL_SIZE;   
		
    public static void main(String[] args)  {

        //Create panel		
        DrawingPanel panel = new DrawingPanel(650,400);
        panel.setBackground(Color.GRAY);
        Graphics brush = panel.getGraphics();

        drawRow(0, 0, 4, 20, brush);
        drawRow(50, 70, 5, 30, brush);

        drawGrid(10, 150, 4, 25, 0, brush);
        drawGrid(250, 200, 3, 25, 10, brush);
        drawGrid(425, 180, 5, 20, 10, brush);
        drawGrid(400, 20, 2, 35, 35, brush); 
	}	


//***************************************************************************
//
// Static Methods Defines
//
//***************************************************************************

	//***************************************************************************
	/** 
	* Find the last character on the string and return its value
	*
	* @param inString input string
	*
	*/

	public static void drawRow(int xCord, int yCord, int rowPairs, int boxSize, Graphics brush)
    {
       for (int i = 0; i < rowPairs; i++)
       {
          brush.setColor(Color.BLACK);
          brush.fillRect(xCord + 2 * (i * boxSize), yCord, boxSize, boxSize);

          brush.setColor(Color.WHITE);
          brush.fillRect(xCord + 2 * (i * boxSize) + boxSize, yCord , boxSize, boxSize);

          brush.setColor(Color.BLUE);
          brush.drawLine(xCord + 2 * i * boxSize, yCord, xCord + 2 * i * boxSize + boxSize, 
                         yCord + boxSize);
          brush.drawLine(xCord + 2 * i * boxSize, yCord + boxSize, 
                         xCord + 2 * i *boxSize + boxSize, yCord);
         }
     }

    //draws a grid by calling drawRow with the appropriate parameters and for loop
    //
    // int xCord - the xCordinate of the leftmost box 
    // int yCord - the yCordinate of the first row 
    // int rowPairs - the number of pairs of black and white boxes per row of boxes
    //                and the number of rows in the grid                  
    // int boxSize - the length and width of the boxes in the row
    // int offset - the x coordinate indentation of the second row 
    // Graphics brush - a graphics brush used to draw with in Drawing Panel  
     public static void drawGrid(int xCord, int yCord, int rowPairs, 
                                 int boxSize, int offset, Graphics brush) 
     {   
         for (int i = 0; i < rowPairs * 2; i++)
         {
            drawRow(xCord + (offset * (i % 2)), yCord + (boxSize * i) + (SPACE_MORTAR * i), 
                             rowPairs, boxSize, brush); 
         }
     }
	

}