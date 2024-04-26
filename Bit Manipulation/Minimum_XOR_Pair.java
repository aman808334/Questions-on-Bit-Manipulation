
// Minimum XOR pair


// Important -  If a <= b <= c then, a^b < a^c or b^c < a^c i.e a^c will be greatest

/*
Approach -

Input -> [5,15,7,3,18]

Sort the given array -> [3,5,7,15,18]

Now, iterate to the array and find the minimum XOR
*/
import java.util.Arrays;

class Minimum_XOR_Pair {

    public static int mimimumXORpair(int arr[]){

        Arrays.sort(arr); // Will sort the given array

        int minimum = Integer.MAX_VALUE;

        for(int i=0; i<arr.length-1; i++){

            int xor = arr[i]^arr[i+1];
            minimum = Math.min(minimum, xor);

        }
       return minimum;
    }

    public static void main(String[] args) {
        int arr[] = {9, 5, 3};
        System.out.println(mimimumXORpair(arr));
    }
}