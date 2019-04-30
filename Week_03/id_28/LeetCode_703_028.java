class KthLargest {
    private PriorityQueue queue = new PriorityQueue();
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        queue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() >= size) {
            if (val > (int) queue.peek()) {
                // queue.poll();
                queue.remove();
                queue.offer(val);
            }
        } else {
            queue.offer(val);
        }
        return (int) queue.peek();
    }
}
