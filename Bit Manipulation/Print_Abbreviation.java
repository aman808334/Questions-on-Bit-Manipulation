
// Print Abbreviation

/*
Example -

Input -> "abc"
Output -> abc, ab1,a1c, a2, 1bc, 1b1, 2c, 3
*/

class Print_Abbreviation {

    public static void abbreviation(String str){

        for(int i=0; i<(1<<str.length()); i++){  // For number

            
            StringBuilder ans = new StringBuilder();
            int count = 0;

            for(int j=0; j<str.length(); j++){ // For String

                int bit = str.length()-1-j; // Bit to analysis

                if((i & (1<<bit)) == 0){ // Bit is '0'. Character will be added

                  if(count == 0){
                    ans.append(str.charAt(j));
                  }
                  else{
                    ans.append(count);
                    ans.append(str.charAt(j));
                    count = 0;
                  }

                }
                else{
                    count++;
                }
            }

            // At last is count is greater that zero than add count in the answer
            if(count > 0)
            ans.append(count);

            System.out.println(ans);  
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        abbreviation(str);
    }    
}