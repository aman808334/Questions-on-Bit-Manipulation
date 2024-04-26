 
// N Bit Grey Code

/*
U r given a number 'N'
U have to generate & print all n-bit grey code sequence
In a grey code sequence, successive terms differ only by one bit

Sample Input -> 2
Sample Output -> 0 0, 0 1, 1 1, 1 0
*/

import java.util.ArrayList;

class N_Bit_Grey_Code {

    public static ArrayList<String> greyCode(int n){

        // Base Condition
        if(n==1){
            ArrayList<String> al = new ArrayList<>();
            al.add("0");
            al.add("1");
            return al;
        }

        ArrayList<String> ans =  greyCode(n-1); // Believe that this will give me all the greycodes of n-1

        ArrayList<String> answer = new ArrayList<>(); // Creating AL for final answer

        // Will add "0"
        for(int i=0; i<ans.size(); i++){
            answer.add("0"+ans.get(i));
        }

        // Will add "1". Reverse to get the sequence of 1 bit change
        for(int i=ans.size()-1; i>=0; i--){ 
            answer.add("1"+ans.get(i));
        }

      return answer;  

    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(greyCode(n));
    }
    
}
