class Solution {
    public String longestWord(String[] words) {

        Set<String> set = new HashSet<>();
        // 利用集合
        for (String word : words) {
            set.add(word);
        }

        // 初始状态
        String result = null;
        int longLen = 0;

        // 遍历
        for (String item : set) {
            int len = item.length();
            // 注意 初始值为1
            for (int i = 1; i < len + 1; i++) {
                String subStr = item.substring(0, i);
                if (!set.contains(subStr)) { // 未匹配到
                    break;
                }
                // 更新
                if (i == len) { // 匹配到最后
                    if (len > longLen) {
                        result = item;
                        longLen = len;
                    } else if (len == longLen) {
                        if (result != null && result.compareTo(item) > 0) {
                            result = item;
                        }
                    }
                }
            }

        }
        return result;
    }
}
