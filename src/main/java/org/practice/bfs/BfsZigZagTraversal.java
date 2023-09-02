package org.practice.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsZigZagTraversal {
     static List<List<Integer>> traverse(TreeNode root){
         List<List<Integer>> result = new ArrayList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         boolean reverseOrder=false;
         while(!queue.isEmpty()){
             int levelSize = queue.size();
             List<Integer> levelList = new LinkedList<>();
             while(levelSize>0){
                 TreeNode node = queue.poll();
                 if(reverseOrder)
                     levelList.add(0,node.value);
                 else
                     levelList.add(node.value);
                 if(node.left!=null)
                     queue.add(node.left);
                 if(node.right!=null)
                     queue.add(node.right);
                 levelSize--;
             }
             reverseOrder=!reverseOrder;
             result.add(levelList);
         }
         return result;
     }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        root.left.right.left=new TreeNode(9);

        System.out.println(traverse(root));
    }
}
