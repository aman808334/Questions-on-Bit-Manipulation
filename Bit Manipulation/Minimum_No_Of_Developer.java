
// Minimum Number of Developers

/*
You are given N strings which represent N different skills related to the IT field .

You are working on a project and you want to hire a team of software developers for that project.

There are M applicants. Every applicant has mentioned his/her skills in their resume.

You have to select the minimum number of developers such that for every required skill, there is at least
one person in the team who has the skill.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Minimum_No_Of_Developer {

    static ArrayList<Integer> sol = new ArrayList<>(); 

    public static void solution(int applicants[], int n, int currentapplicant, ArrayList<Integer> ans, int skillmask){

        // Base Condition
        if(currentapplicant == applicants.length){
            if(skillmask == (1<<n)-1){
                
                if(sol.size()==0 || ans.size() < sol.size()){
                  sol = new ArrayList<>(ans);
                }   
            }
            return;
        }

        // Every applicant has two option to be the part of team & not to be a part of team
        solution(applicants, n, currentapplicant+1, ans, skillmask); // No call

        ans.add(currentapplicant);
        solution(applicants, n, currentapplicant+1, ans, (skillmask | applicants[currentapplicant])); // Yes call
        ans.remove(ans.size()-1); // While returning undo the change

    }

    public static void main(String[] args) {

        int n = 4; // n is total number of skills
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Java", 0);
        hm.put("C++", 1);
        hm.put("JS", 2);
        hm.put("Py", 3);

        Scanner s = new Scanner(System.in);

        int m = 1;
        int applicants[] = new int[m];
        for(int i=0; i<m; i++){
            int applicantskill = s.nextInt();
            for(int j=0; j<applicantskill; j++){
                String skill = s.next();
                int skillvalue = hm.get(skill);
                applicants[i] = applicants[i] | (1<<skillvalue);
            }
        }

       solution(applicants, n, 0, new ArrayList<>(), 0);
       System.out.println(sol);
    }
}