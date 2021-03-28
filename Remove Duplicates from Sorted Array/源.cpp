#include <iostream>
#include <vector>
using namespace std;
int removeDuplicates(vector<int>& nums) {
	int length = 0;
	if (nums.empty()) return length;
	int j = 1;//±ê¼Ç
	for (int i = 0; i < nums.size() - 1 && j < nums.size(); i++)
	{
		length++;
		while (nums[i] == nums[j])
		{
			if (j == nums.size() - 1) return length;
			j++;
		}
		nums[i + 1] = nums[j];
		j++;
	}
	length++;
	return length;
}
int main() {
	vector<int> nums;
	int x;
	while (cin >> x)
	{
		nums.push_back(x);
		if (cin.get() == '\n')
			break;
	}
	cout << removeDuplicates(nums) << endl;
	return 0;
}