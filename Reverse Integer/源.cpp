#include <iostream>
#include <queue>
#include <math.h>
using namespace std;

int reverse(long int x) {
	queue<int> q;
	long int ans = 0;
	int f = 0;
	if (x < 0) { 
		f = 1; 
		x = -x; 
	}
	while (x / 10 > 0)
	{
		q.push(x % 10);
		x = x / 10;
	}
	q.push(x);
	if (q.front() == 0) q.pop();
	while (!q.empty())
	{
			ans +=q.front() * pow(10,q.size()-1);
			q.pop();
	}
	if (ans > INT32_MAX) return 0;
	if (f == 1) ans = -ans;
	return ans;
}
int main() {
	int x;
	cin >> x;
	cout << reverse(x) << endl;
	return 0;
}