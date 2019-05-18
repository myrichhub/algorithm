public int majorityElement(int[] nums) {
    int size = nums.length;
    Map<Integer, Integer> map = new HashMap();

    for (int i = 0; i < size; i++) {
        int num = nums[i];
        Integer cnt = map.get(num);
        if (cnt != null) {

            map.put(num, cnt + 1);
        } else {
            map.put(num, 1);
        }
        if ((int) cnt + 1 > size * 1.0 / 2) {
            return num;
        }
        return 0;
    }
}
