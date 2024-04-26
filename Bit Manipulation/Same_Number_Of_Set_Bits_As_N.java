
// Same Number of Set Bits as that of 'N'

/*
Given a +ve number N, count no. of numbers from 1 to N-1 which has the same no. of set bits as N.

Example -

Input -> 12
Output -> 5 (3,5,6,9,10 has same no. of set bits as 12)
*/

class Same_Number_Of_Set_Bits_As_N {

    public static int count(int num){

        int setbit = findSetBit(num);
        int ans = solve(num, setbit, 31); // Integer so 31. (0-31)

      return ans;  
    }

    public static int solve(int num, int sb, int i){

       //Base Case
       if(i == 0){
        return 0;
       }

       int res = 0;
       int mask = 1<<i;

       if((num & mask) == 0){
        res = solve(num, sb, i-1); // Don't do anything
       }

       else { 

        int res0 = nCr(i,sb); // i = n & r = sb
        int res1 = solve(num, sb-1, i-1); // keep 1 & call f/w
        res = res1 + res0;
       }
       
       return res;
    }

    // Function to find set bit 
    public static int findSetBit(int num){

        int count = 0;
        while(num != 0){
            int rmsb = num & - num;
            num = num - rmsb;
            count ++;
        }
      return count;
    }
    
    public static int nCr(int n, int r){

        int ans = 1;

        if(n<r){
            return 0;
        }
        
        for(int i=0; i<r; i++){
            ans = ans * (n-i);
            ans = ans / (i+1);  
        }

      return ans;
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(count(num)); 
    } 
}