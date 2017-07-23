#include <iostream>
using namespace std;
int uniquePaths(int m, int n) {
	int path = 0;
	if (m == 1 || n == 1)
		return 1;
	if (m > n)
	{
		long long a = m + n - 2;
		long long b = n - 1;
		for (int i = m + n - 3; i > m - 1; i--)
			a *= i;
		for (int j = n - 2; j > 0; j--)
			b *= j;
		path = a / b;
	}
	else {
		long long  a = m + n - 2;
		long long  b = m - 1;
		for (int i = m + n - 3; i > n - 1; i--)
			a *= i;
		for (int j = m - 2; j > 0; j--)
			b *= j;
		path = a / b;
	}
	return path;
}

int main()
{
	int m, n;
	cout << "输入行列数：";
	cin >> m >> n;
	int path = uniquePaths(m, n);
	cout << path << endl;
	system("pause");
	return 0;
}