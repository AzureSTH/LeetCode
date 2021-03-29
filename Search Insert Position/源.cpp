#include <iostream>
#include <vector>
using namespace std;
int searchInsert(vector<int>& nums, int target) {
	vector<int>::iterator it = find(nums.begin(), nums.end(), target);
	if (it == nums.end()) //没找到target
	{
		for (int i = 0; i < nums.size(); i++) //查找插入点
		{
			if (nums[i] > target) return i;
			else if (i == nums.size() - 1) return nums.size();
		}
	}
	else return distance(nums.begin(), it);  //返回找到的元素的下标
}
int main() {
	vector<int> nums;
	int target;
	int temp;
	while (cin >> temp)
	{
		nums.push_back(temp);
		if (cin.get() == '\n')break;
	}
	cin >> target;
	cout << searchInsert(nums, target) << endl;
	return 0;
}