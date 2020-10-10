
package practise_qsns;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> set=new ArrayList<>();
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination(candidates,target,0);
        return result;


    }

    public void combination(int[] candidates, int target,int index) {


        if(index==candidates.length) {
            return;
        }
        if(target==0) {
            result.add(new ArrayList<>(set));
            return;
        }
        if(target<0) {
            return;
        }

        set.add(candidates[index]);
        combination(candidates,target-candidates[index],index);
        if(!set.isEmpty()) {
            set.remove(set.size()-1);
        }
        combination(candidates,target,index+1);

        return;
    }


}