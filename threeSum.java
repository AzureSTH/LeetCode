class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int k=0; //固定三数中的第一个数
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (k=0;k<nums.length-2;k++)
        {
            if(k>0&&nums[k]==nums[k-1]) continue;
            int i=k+1;
            int j=nums.length-1;
            if(nums[k]>0) break;
            while(i<j)
            {
                int sum=nums[k]+nums[i]+nums[j];
                if (sum<0){ //左指针前移
                    i++;
                    while(i<j&&nums[i]==nums[i-1])
                        i++;
                }
                if(sum>0){ //右指针后移
                    j--;
                    while(i<j&&nums[j]==nums[j+1])
                        j--;
                }
                if(sum==0){ //左右指针都动
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    i++;j--;
                    while(i<j&&nums[i]==nums[i-1])
                        i++;
                    while(i<j&&nums[j]==nums[j+1])
                        j--;
                }
            }
        }
        return res;    
    }
}