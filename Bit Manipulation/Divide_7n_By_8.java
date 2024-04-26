
// Divide 7n/8 without using multiplication & division operation

/*
Approach -

7n/n = 8n -n/8 
Now we can use left and right shift for numbers which are in 2's power
*/

class Divide_7n_By_8 {

    public static int calulate(int n){
      return ((n<<3)-n)>>3;  
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(calulate(n));
    }
}