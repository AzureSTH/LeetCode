//I	1; V	5; X	10; L	50; C	100; D	500; M	1000
#include <iostream>
using namespace std;
int romanToInt(string s) {
	int a[7] = { 0 };
	int res = 0;
	for (int i = 0; i < s.size(); i++)
	{
 		switch (s[i])
		{
		case 'I':
		{
			if (i + 1 < s.size() && s[i + 1] == 'V')
			{
				res += 4;
				i++;
				break;
			}
			else if (i + 1 < s.size() && s[i + 1] == 'X')
			{
				res += 9;
				i++;
				break;
			}
			else a[0] += 1; break;
		}
		case 'V':a[1] += 1; break;
		case 'X':
		{
			if (i + 1 < s.size() && s[i + 1] == 'L')
			{
				res += 40;
				i++;
				break;
			}
			else if (i + 1 < s.size() && s[i + 1] == 'C')
			{
				res += 90;
				i++;
				break;
			}
			else a[2] += 1; break;
		}
		case 'L':a[3] += 1; break;
		case 'C':
		{
			if (i + 1 < s.size() && s[i + 1] == 'D')
			{
				res += 400;
				i++;
				break;
			}
			else if (i + 1 < s.size() && s[i + 1] == 'M')
			{
				res += 900;
				i++;
				break;
			}
			else a[4] += 1; break;
		}
		case 'D':a[5] += 1; break;
		case 'M':a[6] += 1; break;
		}
	}
	return res + a[0] + a[1] * 5 + a[2] * 10 + a[3] * 50 + a[4] * 100 + a[5] * 500 + a[6] * 1000;
}
int main() {
	string s;
	cin >> s;
	cout << romanToInt(s) << endl;
	return 0;
}