
// XOR of Sum of all pairs

class XOR_Of_Sum_Of_All_Pair {

    public static int sum(int arr[]){

        int value = 0;

        for(int i=0; i<arr.length; i++){
            value = value ^ (2*arr[i]);
        }

       return value; 
    }

    public static void main(String[] args) {
        
        int arr[] = {7,3,5};
        System.out.println(sum(arr));
    } 
}
