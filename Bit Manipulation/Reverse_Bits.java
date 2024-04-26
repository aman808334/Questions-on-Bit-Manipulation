
// Reverse Bits

/*
Example -

Input -> 11 (1011)
Output -> 13 (1101)
*/

class Reverse_Bits {

    public static int reverse(int n){

        int rev = 0; // Will store reverse no.
        int j = 0; // Pointer of reverse no. Initially on 0th bit

        boolean flag = false; // Will say that 1st "ON" bit has been found or not

        // Iterate the given number from left i.e 31st bit
        for(int i=31; i>=0; i--){

            int mask = (1<<i);

             if(flag == true){

                if((n & mask) != 0){ // Bit is"ON"

                  rev = rev | (1<<j); // "ON" jth bit of rev
                }
              j++;
            }

            if(flag == false && (n & mask) != 0){ // 1st "ON" bit has been found

               flag = true;
               rev = rev | (1<<j); // Put that '1' in 0th bit of rev
               j++;
            } 
        }

      return rev;
    }

    public static void main(String[] args) {
        
        int n = 11;
        System.out.println(reverse(n));
    }
}