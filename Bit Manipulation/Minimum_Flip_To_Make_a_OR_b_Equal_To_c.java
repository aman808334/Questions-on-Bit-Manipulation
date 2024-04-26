
// Minimum Flip to make 'a' OR 'b' equal to 'c'

/*
Example -

Input -> a = 2 (0010), b = 5 (0101),  c = 6 (0110).

a | b = 7 (0111)

Output -> 1
*/

/*
Approach -

We'll check every bit of 'c' -

Case 1st - Bit is "OFF" in 'c' then, that bit should be "OFF" in both 'a' & 'b'
Case 2nd - Bit is "ON" in 'c' then, that bit should be "ON" in at least 'a' or 'b'
*/

class Minimum_Flip_To_Make_a_OR_b_Equal_To_c {

    public static int minimumFlips(int a, int b, int c) {

        int count = 0;

        for(int i=0; i<32; i++){

            int mask = 1<<i;

            // Check in 'c' weather bit is "ON" or "OFF"
            if((c & mask) == 0){ // Bit is "OFF" in 'c'

              // That bit should be "OFF" in both 'a' & 'b'

              if((a & mask) != 0)
                count++;

              if((b & mask) != 0)
                count++;  
            }

            else{ // Bit is "ON" in 'c'

              // That bit should be "ON" in at least 'a' or 'b'

              if((a & mask) == 0 && (b & mask) == 0)
                count++;

            }
        }
      return count;   
    }
    
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        int c = 6;
        System.out.println(minimumFlips(a, b, c));
    }
}
