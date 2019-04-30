class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        // 求树高
        int h = getHeight(root);
        // 初始化结果数组
        List<List<Integer>> res = new ArrayList<>(h);
        if (h == 0) {
            return res;
        }
        for (int i = 0; i < h; i++) {
            res.add(new ArrayList<Integer>());
        }
        // 调用递归
        LinkedList<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.push(root);
        }
        // 递归循环，每次带着深度
        res = levelOrder(0, queue, res);
        return res;
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int maxHeight = 0;
        for (Node subNode : root.children) {
            int h = getHeight(subNode);
            maxHeight = maxHeight < h ? h : maxHeight;
        }
        return 1 + maxHeight;
    }

    private List<List<Integer>> levelOrder(int level, LinkedList<Node> queue, List<List<Integer>> res) {
        if (queue.isEmpty()) {
            return null;
        }
        Node node = queue.pop();
        List<Integer> item;

        item = res.get(level);
        /*
           if (item == null) {
           item = new ArrayList<>();
           }
         */
        item.add(node.val);
        res.set(level, item);
        if (node.children != null) {
            for (Node subNode : node.children) {
                queue.push(subNode);
                res = levelOrder(level + 1, queue, res);
            }
        }
        return res;
    }
}
