import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class PostOrderTree {

    static class Node{
        Node left, right;
        int value;
        Node(int value){
            this.value = value;
        }
    }

    static int preOrderIndex = 0;
    static Map<Integer, Integer> inOrder = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] preOrder = new int[len];
        int[] inOrderArray = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            inOrderArray[i] = Integer.parseInt(st.nextToken());
            inOrder.put(inOrderArray[i], i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }
        Node root = treeBuilder(inOrderArray, preOrder, 0, len - 1);
        StringBuilder sb = new StringBuilder();
        postOrderTree(root, sb);
        System.out.println(sb.toString().trim());
    }

    static Node treeBuilder(int[] in, int[] pre, int start, int end){
        if(start > end) return null;
        int value = pre[preOrderIndex++];
        Node root = new Node(value);
        int idx = inOrder.get(value);
        root.left= treeBuilder(in, pre, start, idx-1);
        root.right = treeBuilder(in, pre, idx+1, end);
        return root;
    }

    static void postOrderTree(Node root, StringBuilder sb){
        if(root == null) return;
        postOrderTree(root.left, sb);
        postOrderTree(root.right, sb);
        sb.append(root.value).append(" ");
    }
}
