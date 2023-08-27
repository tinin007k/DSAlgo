package org.practice.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsLevelOrderTraversal {
    static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> currentLevelList = new ArrayList<>(size);
            while(size > 0){
                TreeNode node=q.poll();
                currentLevelList.add(node.value);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                size--;
            }
            System.out.println(currentLevelList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1= new TreeNode(2);
        TreeNode right1=new TreeNode(3);
        TreeNode left2=new TreeNode(4);
        TreeNode right2=new TreeNode(5);
        TreeNode right21=new TreeNode(6);
        left1.left=left2;
        root.left=left1;
        right1.left=right2;
        right1.right=right21;
        root.right=right1;
        right21.right=new TreeNode(10);
        right21.left=new TreeNode(11);

        levelOrderTraversal(root);
    }
}
