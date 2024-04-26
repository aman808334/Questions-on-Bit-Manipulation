
// Convert a binary number to Integer

/*
Given a array representating binary number. Return integer value of the binary number represented by the array

Example -

Input -> [1,0,1]
Output -> 5
*/

public class Convert_Binary_Number_To_Integer {

    public static int conertToInteger(int arr[]) {

        int n = 0;

        for(int i=0; i<arr.length; i++){

            n = (n<<1); // Double the value by left shift
            n += arr[i]; // Add 
        }

       return n;
    }

    public static void main(String[] args) {
        int arr[] = {1,0,1};
        System.out.println(conertToInteger(arr));
    }  
}