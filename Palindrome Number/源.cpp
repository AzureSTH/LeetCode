#include <iostream>
#include <vector>
using namespace std;
bool isPalindrome(int x) {
	vector<int> v;
	if (x < 0) return false;
	else {
		while (x / 10 > 0)
		{
			v.push_back(x % 10);
			x = x / 10;
		}
		v.push_back(x);
		while (v.size() > 1)
		{
			if (v.front() == v.back())
			{
				v.pop_back();
				v.erase(v.begin());
				if (v.size() == 1) return true;
			}
			else return false;
		}
		return true;
	}
}
int main() {
	int x;
	cin >> x;
	if(isPalindrome(x))
		cout << "true" << endl;
	else
		cout << "false" << endl;
	return 0;
}