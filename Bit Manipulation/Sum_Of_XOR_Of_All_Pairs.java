
// Sum of XOR of all pairs

/*
Example -

Input -> [7,3,5]
Output -> 12
Explanation - (7^3)+(7^5)+(3^5) = 12
*/

class Sum_Of_XOR_Of_All_Pairs {

    public static long sumXOR (int arr[]) {
       
        long result = 0;
       
        for(int i=0; i<31; i++){ // Check all 32 bits
           
            int on = 0;
            int off = 0;
           
            int mask = (1<<i);
           
            for(int val:arr){
                if((val & mask) == 0)
                  off++;
            }
            
            on = arr.length - off;
            result +=  (long) on * off * (1<<i);     
        }

      return result;    
    }

    public static void main(String[] args) {
        int arr[] = {7,3,5};
        System.out.println(sumXOR(arr));
    }
}