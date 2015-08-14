package io.github.laurencemeynell.yourphotopuzzlegame;

/**
 * A prototype for my sliding puzzle game.  Will contain the logic to make the game work.
 * Created by Laurence on 14/08/2015.
 */
public class SlidingPuzzle
{

    private int rows;
    private int columns;
    private int[][] puzzle;
    private int[] emptySlot = new int[2];

    /**
     * Make a 3*3 puzzle with blocks numbered 1 to 8 and a space at the end like so:
     * 123
     * 456
     * 78*
     * The * represents an empty space
     */
    public SlidingPuzzle()
    {
        this(3,3);
    }

    /**
     * Makes a aRows*aColumns puzzle with blocks numbered 1 to (aRows*aColumns - 1) and a space
     * at the end like so:
     * 123.
     * ....
     * ...*
     * The * represents the empty space
     * @param aRows the number of rows in the puzzle
     * @param aColumns the number of columns in the puzzle
     */
    public SlidingPuzzle(int aRows, int aColumns)
    {

        this.rows = aRows;
        this.columns = aColumns;

        int counter = 1;
        this.puzzle = new int[aRows][aColumns];

        //populate the puzzle with numbers
        for(int theRow = 0; theRow < this.getRows(); theRow++)
        {
            for(int theColumn = 0; theColumn < this.getColumns(); theColumn++)
            {
                puzzle[theRow][theColumn] = counter;
                counter++;
            }
        }
        //make the final block 0 representing an empty space
        this.puzzle[aRows - 1][aColumns - 1] = 0;
        //record the empty slot's position
        this.emptySlot[0] = aRows - 1;
        this.emptySlot[1] = aColumns - 1;
    }

    /**
     * @return the number of rows on the board
     */
    public int getRows()
    {
        return rows;
    }


    /**
     * @return the number of columns on the board
     */
    public int getColumns()
    {
        return columns;
    }

    /**
     * Returns an int 2D array representing the board.  First dimension is the row number. Second
     * dimension is the column number.  As the index starts at zero, [0][0] would represent row 1
     * column 1.  The blank space is represented by a 0.
     * @return the board represented by a 2D int array
     */
    public int[][] getPuzzle()
    {
        return puzzle;
    }

    /**
     * Returns a String representation of the puzzle game board.  With the empty space
     * represented by a *.  If the board contains more than 100 squares then the columns won't be
     * aligned
     * @return a String representation of the board
     */
    @Override
    public String toString()
    {
        String puzzleString = "";
        int currentNumber;

        for(int theRow = 0; theRow < this.getRows(); theRow++)
        {
            for(int theColumn = 0; theColumn < this.getColumns(); theColumn++)
            {
                currentNumber = this.getPuzzle()[theRow][theColumn];

                if(currentNumber == 0)
                {
                    puzzleString += "|  *";
                }
                else
                {
                    if(currentNumber < 10)
                    {
                        puzzleString += "|  " + currentNumber;
                    }
                    else
                    {
                        puzzleString += "| " + currentNumber;
                    }
                }
            }
            puzzleString += "\n";
        }
        return puzzleString;
    }

    public static void main(String[] args)
    {
        SlidingPuzzle aPuzzle = new SlidingPuzzle(3, 5);
        System.out.println(aPuzzle);
    }
}
