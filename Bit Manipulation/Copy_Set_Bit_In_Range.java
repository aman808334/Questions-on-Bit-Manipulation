
// Copy Set Bits in a Range

/*
Given two numbers A & B and two positions left and right.
The bits which a ON in A b/w left and right, set that bit ON in B only

Note - Don't change other bits of B
*/

class Copy_Set_Bit_In_Range {

    public static int copy(int a, int b, int left, int right){
        
        // Creating mask to create helper mask
        int x = 1<<(left-right+1);
        x = x - 1;
        x = x<<right; // Mask to create helper mask

        // Creating the helper mask
        int helper = a & x;

        // Coping Set Bits
        b = b | helper;


      return b;
    }

    public static void main(String[] args) {

        int a = 13; // 1101
        int b = 10; // 1010
        int left = 3;
        int right = 2;
        System.out.println(copy(a, b, left, right)); // Output should be 14
    } 
}