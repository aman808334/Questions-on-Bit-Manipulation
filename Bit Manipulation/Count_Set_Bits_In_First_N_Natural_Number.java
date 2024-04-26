
// Count set bits in first N natural number

/*
S(n) = 2^x-1*x + (n-2^x+1) + solve(n-2^x), where 2^x is largest power of 2 which is <= the given number
*/

class Count_Set_Bits_In_First_N_Natural_Number {

    public static int count(int n){

        // Base Condition
        if(n == 0){
            return 0;
        }

        // Find largest possible power of 2
        int power = 0;
        while(n >= (1<<power)){
            power++;
        }

        power--;

        int ans = ((1<<(power-1)) * power) + (n - (1<<power) + 1) + (count(n-(1<<power)));

      return ans;  
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(count(n));
    } 
}