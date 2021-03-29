#include <iostream>
#include <vector>
using namespace std;
int removeElement(vector<int>& nums, int val) {
	int length = 0;
	nums.erase(remove(nums.begin(), nums.end(), val),nums.end());
	length = nums.size();
	return length;
}
int main() {
	vector<int> nums;
	int val, x;
	while (cin >> x)
	{
		nums.push_back(x);
		if (cin.get() == '\n')
			break;
	}
	cin >> val;
	cout << removeElement(nums,val) << endl;
	return 0;
}