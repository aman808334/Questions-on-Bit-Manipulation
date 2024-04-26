
// Sudoku

/*
You are given a partially filled 9*9 2D array which represents an incomplete sudoku state 
You are required to assign the digits from 1 to 9 to the empty cells following some rules.

Rule 1-> Digits from 1-9 must occur exactly once in each row.
Rule 2-> Digits from 1-9 must occur exactly once in each column.
Rule 3-> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array

Assumption -

The given Sudoku puzzle will have a single unique solution.

Sample Input -

3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1 
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

Sample Output -

3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
*/

class Sudoku {

    public static void solveSudoku(int arr[][]) {

        /* Will make a row array which will contain number crossponding to each row and that number will have 
        all those bits as set which are present in that row */
        int row [] = new int[arr.length]; 

        for(int r=0; r<arr.length; r++){

            int num = 0;
            for(int c=0; c<arr[0].length; c++){
                  num = (num|(1<<arr[r][c])); // "On" the bit
            }
            row[r] = num;
        }

        // Similarly make column array
        int column [] = new int[arr[0].length]; 

        for(int c=0; c<arr[0].length; c++){

            int num = 0;
            for(int r=0; r<arr[0].length; r++){
                  num = (num|(1<<arr[r][c]));
            }
            column[c] = num;
        }

        // Similarly make array of 9 sub matrices
        int matrix[][] = new int[3][3];

        for(int r=0; r<arr.length; r++){
            for(int c=0; c<arr[0].length; c++){
                  matrix[r/3][c/3] |= (1<<arr[r][c]); 
            }
        }  

        solveSudokuHelper(arr,row,column,matrix,0,0); // Initially row & column is (0,0)
    }
    // Iterate to all 81 position
    public static void solveSudokuHelper(int arr[][], int row[], int column[], int matrix[][], int r,int c){


        // Base Condition
        if(r==arr.length){
          display(arr);
          return;

          
        }

        // For iteration in the array
        int nextRow = 0;
        int nextCol = 0;

        if(c == arr[0].length-1){ // In last column of a particular row
            nextRow = r+1;
            nextCol = 0;
        }
        else{
            nextRow = r;
            nextCol = c+1;
        }

        if(arr[r][c] != 0) { // If the digit isn't '0'. We can't do anything
            solveSudokuHelper(arr, row, column, matrix, nextRow, nextCol);
        }
        else{
            for(int option=1; option<=9; option++){

                if( ((row[r] & (1<<option)) == 0) && ((column[c] & (1<<option)) == 0) && ((matrix[r/3][c/3] & (1<<option)) == 0)){
                    arr[r][c] = option; // Put that value in that block

                    // "ON" that bit in row,column and matrix
                    row[r] ^= (1<<option);
                    column[c] ^= (1<<option);
                    matrix[r/3][c/3] ^= (1<<option);

                    solveSudokuHelper(arr, row, column, matrix, nextRow, nextCol);

                    arr[r][c] = 0; // Undo the changes while coming back.
                    row[r] ^= (1<<option);
                    column[c] ^= (1<<option);
                    matrix[r/3][c/3] ^= (1<<option);
                }
            }
        }
    }

    public static void display(int arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
          System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{3,0,6,5,0,8,4,0,0},
                       {5,2,0,0,0,0,0,0,0},
                       {0,8,7,0,0,0,0,3,1},
                       {0,0,3,0,1,0,0,8,0},
                       {9,0,0,8,6,3,0,0,5},
                       {0,5,0,0,9,0,6,0,0},
                       {1,3,0,0,0,0,2,5,0},
                       {0,0,0,0,0,0,0,7,4},
                       {0,0,5,2,0,6,3,0,0}};

        solveSudoku(arr);      
    }
}