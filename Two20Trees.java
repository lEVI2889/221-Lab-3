/*
import java.io.*;
import java.util.*;

public class Two20Trees {
    static int preIndex = 0;
    static Map<Integer, Integer> inOrderMap = new HashMap<>();

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node buildTree(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preOrder[preIndex++];
        Node root = new Node(rootVal);

        int inIndex = inOrderMap.get(rootVal);

        root.left = buildTree(inOrder, preOrder, inStart, inIndex - 1);
        root.right = buildTree(inOrder, preOrder, inIndex + 1, inEnd);

        return root;
    }

    static void postOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val).append(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] inOrder = new int[n];
        int[] preOrder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderMap.put(inOrder[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }

        Node root = buildTree(inOrder, preOrder, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        System.out.println(sb.toString().trim());
    }
}
*/
/*import java.io.*;
import java.util.*;

public class PreOrderTree {
    static class Node {
        Node left, right;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static int postOrderIndex;
    static Map<Integer, Integer> inOrderMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        int[] inOrder = new int[len];
        int[] postOrder = new int[len];
        postOrderIndex = len - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderMap.put(inOrder[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        Node root = buildTree(inOrder, postOrder, 0, len - 1);
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        System.out.println(sb.toString().trim());
    }

    static Node buildTree(int[] in, int[] post, int start, int end) {
        if (start > end) return null;

        int value = post[postOrderIndex--];
        Node root = new Node(value);
        int idx = inOrderMap.get(value);

        // Right subtree first because post-order is L-R-Root (we're moving backward)
        root.right = buildTree(in, post, idx + 1, end);
        root.left = buildTree(in, post, start, idx - 1);

        return root;
    }

    static void preOrderTraversal(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.value).append(" ");
        preOrderTraversal(root.left, sb);
        preOrderTraversal(root.right, sb);
    }
}*/

