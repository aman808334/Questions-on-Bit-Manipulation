
// Number of Bits Flip to Convert A to B

/*
Approach -

No. of bits flip to convert A to B = No. of which differ in A and B

We can find number of bits differ in A & B by XOR and count the bits by Kernighan's Algorithm

*/

class Number_Of_Bits_Flip_To_Convert_A_To_B {

    public static int convert(int a, int b){

        int xor = a^b;

        // Counting setbits by Kernighan's Algorithm
        int count = 0;
        while(xor != 0){
            int rmsb = xor & (-xor);
            xor = xor - rmsb;
            count++;
        }

       return count;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        System.out.println(convert(a, b));
    }
}
