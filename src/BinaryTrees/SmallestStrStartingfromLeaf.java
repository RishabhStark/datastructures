package BinaryTrees;

public class SmallestStrStartingfromLeaf {

//Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z':
// a value of 0 represents 'a', a value of 1 represents 'b', and so on.
//Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is
// lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)


//Example:1
//    Input: [0,1,2,3,4,3,4]
//    Output: "dba"




    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        String temp="";
        String res="";

        public String smallestFromLeaf(TreeNode root) {
            backtrack(root,temp);
            return res;
        }

        public void backtrack(TreeNode root,String temp) {
            if(root==null) return;
            temp=String.valueOf((char)(97+root.val))+temp;
            if(root.right==null && root.left==null) {

                if(res.equals("")) {
                    res=temp;
                }
                else if(temp.compareTo(res)<0) {
                    res=temp;
                }
            }
            backtrack(root.left,temp);
            backtrack(root.right,temp);


        }





}
