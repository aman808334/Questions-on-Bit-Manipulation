
// Power of 4

/*
Wrong Approach -

Divide the given no. by '4' and now check if it is power of 2 or  not. This approach is wrong.
Example - 8,32,128, ...
*/

class Power_Of_4 { 

    public static boolean check(int num){

      int mask = 0b01010101010101010101010101010101;

      if((num&(num-1)) == 0 && (num & mask) != 0)
          return true;
      
      return false; 
    }
}
