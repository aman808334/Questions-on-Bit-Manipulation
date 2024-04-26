
// Swap all odd and even bits

/*
Example -

Input -> 10 (1010)
Output -> 5 (0101)
*/

/*
Approach -

Step 1st -

Preserve the bits at odd position and at even position by performing "AND" operation of given no. with following -
(1) For preserving odd bits use "01010101010101010101010101010101" mask
(2) For preserving even bits use "10101010101010101010101010101010" mask

Step 2nd - 

left Shift by '1' to odd preserved and right shift by '1' to even preserved and then take "OR" of both

*/

class Swap_All_Odd_And_Even_Bits {

    public static int swap(int n){

        int oddmask = 0x55555555; //0b01010101010101010101010101010101;
        int evenmask = 0xAAAAAAAA; //0b10101010101010101010101010101010;

        int oddsame = (n & oddmask); // Bits at odd place will be same
        int evensame = (n & evenmask); // Bits at even place will be same

        // left Shift to oddsame and right shift to even same

        oddsame = (oddsame<<1); 
        evensame = (evensame>>1);

        // "OR" of both number
        n = oddsame | evensame;

       return n;
    }

    public static void main(String[] args) {

        int n = 4; // 1010
        System.out.println(swap(n));       
    } 
}