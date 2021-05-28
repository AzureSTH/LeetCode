class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap();
        int[] res=new int[k];
        //记录各数出现频次
        for (int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) 
        {
            if(heap.size()<k) heap.add(key);
            else if(map.get(key)>map.get(heap.peek())){
                heap.poll();
                heap.add(key);
            }
        }
        for(int i=0;i<k;i++)
        {
            res[i]=heap.poll();
        }
        return res;
    }
}