
// Place N Queens

/*
Given N*N chessboard  & n queens are given. We've to place n queens in chessboard so that no queen can cut
other queens.
*/

class N_Queens {

    public static void placeQueens(boolean chessboard[][]) {

        int column = 0; // To represent in which columns queen can't be placed.
        int nDiagonal = 0; // To represent in which normal diagonal queen can't be placed
        int rDiagonal = 0; // To represent in which reverse diagonal queen can't be placed
        String answer = ""; // Initially Empty

        queensPlace(chessboard, column, nDiagonal, rDiagonal, answer, 0); // Row is initially 0
    }

    public static void queensPlace(boolean chessboard[][], int column, int nDiagonal, int rDiagonal, String answer, int row){

        // Base Condition
        if(row==chessboard.length){
            System.out.println(answer);
            return;
        }
        
        // Now the option is equal to the number of columns. So for loop & function call inside the loop.
        for(int col=0; col<chessboard[0].length; col++){

            if( ((column & (1<<col)) == 0) && ((nDiagonal & (1<<(row+col))) == 0) && ((rDiagonal & (1<<(row-col+chessboard.length-1))) == 0)) {

                chessboard[row][col] = true; // Place the queen
                // A/f placing the queen update the column, nDiagonal & rDiagonal
                column = (column^(1<<col));
                nDiagonal = (nDiagonal^(1<<(row+col)));
                rDiagonal = (rDiagonal^(1<<(row-col+chessboard.length-1)));

                queensPlace(chessboard, column, nDiagonal, rDiagonal, answer + row + "-" + col + "  ", row+1); // Function Call

                // While returning i.e backtracking undo the changes
                chessboard[row][col] = false;
                column = (column^(1<<col));
                nDiagonal = (nDiagonal^(1<<(row+col)));
                rDiagonal = (rDiagonal^(1<<(row-col+chessboard.length-1)));
            }
        }
    }

    public static void main(String[] args) {
        boolean chessboard [][] = new boolean[4][4];    
        placeQueens(chessboard);
    }   
}