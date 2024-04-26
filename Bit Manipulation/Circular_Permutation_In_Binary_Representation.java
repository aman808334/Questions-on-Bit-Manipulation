
// Circular Permutation in Binary Representation

/*
Given a number & start.
Return Grey Code of the given number but Grey Code should start from the given start point.

Note - The start & the end must also differ by only one bit in their binary representation

Example -

Input -> num = 3 & start = 2
Output -> [2,6,7,5,4,0,1,3]
*/

import java.util.ArrayList;
import java.util.List;

class Circular_Permutation_In_Binary_Representation {

    public static List<Integer> circularPermutation(int n, int start) {

        ArrayList<String> gc = greyCode(n); // Will get Grey Code of 'n'

        // Change the Grey Code in String to Integer
        List<Integer> list = new ArrayList<>();

        for(String s:gc){
            list.add(Integer.parseInt(s,2));
        }

        /* Now arrange the Grey Code on the basis of start.

           Step 1st - Finding the index of start in the list of Grey Code
           Step 2nd - First store all the elements from given "start" to last in result and then store
                      the remaining elements from index '0' to (index of given start - 1)   
        */
        
        int index = 0;

        for(int i=0; i<list.size(); i++){
            if(list.get(i) == start)
              index = i;
        }
        
        List<Integer> result = new ArrayList<>();

        for(int i=index; i<list.size(); i++){
            result.add(list.get(i));
        }

        for(int i=0; i<index; i++){
            result.add(list.get(i));
        }

      return result;
    }

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
        int start = 2;
        System.out.println(circularPermutation(n, start));
    } 
}