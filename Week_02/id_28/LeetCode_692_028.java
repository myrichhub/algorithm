class Solution {
    public class MyNode {
        String word;
        int count;
        public MyNode(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> stat = new HashMap<String, Integer>();
        for (String item : words) {
            stat.put(item, stat.getOrDefault(item, 0) + 1);
        }
        List<MyNode> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : stat.entrySet()) {
            MyNode node = new MyNode(item.getKey(), item.getValue());
            list.add(node);
        }
        list.sort(new Comparator<MyNode>() {
                @Override
                public int compare(MyNode o1, MyNode o2) {
                if (o1.count > o2.count) {
                return -1;
                }
                if (o1.count < o2.count) {
                return 1;
                }
                if (o1.word.compareTo(o2.word) < 0) {
                return -1;
                } else {
                return 1;
                }
                }
                });
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            keys.add(list.get(i).word);
        }
        return keys;
    }
}
