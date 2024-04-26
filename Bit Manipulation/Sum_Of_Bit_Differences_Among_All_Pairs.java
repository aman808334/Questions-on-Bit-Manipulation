
// Sum of bit differences among all pairs

/*
Example -

Input -> [a,b,c,d]

a -> 10111
b -> 11001
c -> 10101
d -> 10010

Pairs -

ab,ac,ad
ba,bc,bd
ca,cb,cd
da,db,dc

*/

class Sum_Of_Bit_Differences_Among_All_Pairs {

    public static int difference(int arr[]){

        int ans = 0;

        // Solve bit by bit
        for(int i=0; i<32; i++){ // 32 bits in integer

            int onbits = 0;
            int mask = 1<<i;

            for(int val:arr){
                if((val&mask) != 0)
                  onbits++;
            }

            int offbits = arr.length - onbits;
            ans += onbits * offbits * 2;
        }

       return ans; 
    }

    public static void main(String[] args) {
        int arr[] = {23,25,21,18};
        System.out.println(difference(arr));
    }
}