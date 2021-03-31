class Solution {
    private void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int partition(int[] nums, int left, int right)
    {
        int p=nums[left];
        int j=left;
        for (int i=left+1;i<=right;i++)
        {
            if(nums[i]<p)
            {
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,j,left);
        return j;
    }
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        while(true)
        {
            int p=partition(nums,left,right);
            if(p==len-k)
                return nums[p];
            else
                {
                    if(p<len-k) left=p+1;
                    else right=p-1;
                }
        }
    }
}