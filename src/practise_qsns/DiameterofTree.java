package practise_qsns;


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }


//  Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// Example:
// Given a binary tree

//           1
//          / \
//         2   3
//        / \
//       4   5

//  Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

// Note: The length of path between two nodes is represented by the number of edges between them.

class Height {
    int h;
}



class DiamSolution{
    public int diameterOfBinaryTree(TreeNode root) {
        Height height=new Height();
        return diameter(root,height);

    }




    public int diameter(TreeNode root,Height height) {
        Height lh=new Height();
        Height rh=new Height();
        if(root==null) {
            height.h=0;
            return 0;
        }
        int d1=diameter(root.right,rh);
        int d2=diameter(root.left,lh);
        height.h=Math.max(lh.h,rh.h)+1;
        return Math.max(lh.h + rh.h,Math.max(d1,d2));
    }







}

