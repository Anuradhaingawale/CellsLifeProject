
// Alive cells are represented by 1�s and dead cells are represented by 0�s.

import java.util.Scanner;

class CellsLife
{
	 public static int rows;
	 public static int columns;
	 public static int cells[][];


	//intialization 
	public CellsLife(int rows,int columns)
	{
		this.rows=rows;
		this.columns=columns;
		 
	}

	//function For next generation
	static void nextGeneration(int cells[][], int rows, int columns) 
    {
        int[][] nextGenCells = new int[rows][columns];     //  create celles for next generation of size rowsXcolumns
  
        
        for (int l = 1; l < rows - 1; l++)                        // Loop through every cells rows and columns
        {
            for (int m = 1; m < columns - 1; m++)
            {
                
                int aliveNeighbours = 0;                           // count no Of Neighbours that are alive
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += cells[l + i][m + j];
  

                aliveNeighbours -= cells[l][m];
  
                // Implementing the Rules of cells Life
  
                
                if ((cells[l][m] == 1) && (aliveNeighbours < 2))     // Cell is dies by loneliness
                    nextGenCells[l][m] = 0;
  
                
                else if ((cells[l][m] == 1) && (aliveNeighbours > 3))  // Cell dies due to overcrowding
                    nextGenCells[l][m] = 0;
  
                
                else if ((cells[l][m] == 0) && (aliveNeighbours == 3))   // cell comes to life
                    nextGenCells[l][m] = 1;
  
                
                else
                    nextGenCells[l][m] = cells[l][m];           // Remains unchanged
            }
        }
  
	  System.out.println("Next Generation");		//Print Next Generation by for loop iteration
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (nextGenCells[i][j] == 0)
                    System.out.print("0");
                else
                    System.out.print("1");
            }
            System.out.println();
        }

	}


	public static void main(String[] args) 
	{
	   
	   System.out.print("Enter cells array size : "); // Enter the size of array (matrix format) E.g rowsxcolumns=? i.e 2x2=4 
       Scanner sc=new Scanner(System.in);
       rows=sc.nextInt();						//Input for no. rows 
       columns=sc.nextInt();					//Input for no. of colums
       
       System.out.println("Enter Cells elements : "); //Enter only 1 and 0 as input
        
        int cells[][]=new int[rows][columns];  

        for(int i=0; i<rows;i++)				// loop to enter data in 2D array of size rowsXcolumns
         {            
            for(int j=0; j<columns;j++)
            {
                cells[i][j]=sc.nextInt();
            }
         }

        System.out.print("\nData you entered : \n"); // loop to print data in provided by user  
        for(int []x:cells){
            for(int y:x){
            System.out.print(y+"        ");
            }
            System.out.println();
        }

		nextGeneration(cells, rows, columns);       // call next generation based on user provided cells data
	}

	
}
