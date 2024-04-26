
// XOR Queries of a subarray

/*
Example -

Input -  arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output - [2,7,14,8] 

Explaination - 

The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
*/

/*
Approach -

We'll make prefix XOR array (Similar to prefix sum array).
Then use - S(left,right) = Prefix XOR array(right) - Prefix XOR array(left-1)
*/

class XOR_Queries_Of_Subarray {

    public static int[] xorQueries(int[] arr, int[][] queries){

        // Make prefix XOR array
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0]; 

        for(int i=1; i<arr.length; i++)
          prefix[i] = prefix[i-1] ^ arr[i];
        
        int ans[] = new int[queries.length];
        int j = 0; // Pointer for j


        for(int a[] : queries){

            int left = a[0];
            int right = a[1];

            if(left == 0)
              ans[j] = prefix[right];
            else
              ans[j] = prefix[right] ^ prefix[left-1];

          j++;
        }

      return ans;   
    }

    public static void main(String[] args) {
        
        int arr[] = {1,3,4,8};
        int queries[][] = {{0,1}, {1,2}, {0,3}, {3,3}};
        int ans[] = xorQueries(arr, queries);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }  
}