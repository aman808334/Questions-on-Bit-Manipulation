
// All Repeating Except Two

/*
U'r given an array in which every element appears twice except two elements.
Find that two elements

Example - 

Input -> [1,2,1,3,2,5]
Output -> [3, 5] (Order isn't important)
*/

class All_Repeating_Except_Two {

    public static int[] findTwo(int arr[]){

        int req = 0;
        for(int i: arr){
            req = req ^i; // Req = x^y (x and y are two required nos.)
        }

        int rmsbmask = req & -req; // Right Most Set Bit Mask

        /* With the help of rmsbmask we will check whose bit is "ON" or "OFF" in this position & based on that
        we will separate numbers of given array & find there XOR and we'll get the req. nos. from these */

        int x = 0;
        int y = 0;
        for(int i: arr){
            if((i & rmsbmask) == 0) // Bit is "OFF"
              x = x ^ i; // Will give one no.
            else
              y = y ^ i; // Will give another no.
        }

       int res[] = new int[2];
       res[0] = x;
       res[1] = y;

      return res;  
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,1,3,2,5};
        int res[] = findTwo(arr);
        for(int i: res){
            System.out.print(i + " ");
        }
    }  
}
