#include <iostream>
#include <vector>
using namespace std;
string longestCommonPrefix(vector<string>& strs) {
	if (strs.empty()) return "";
	else {
		string str = strs[0];
		string res = "";
		for (int i = 0; i < str.size(); i++)
		{
			res += str[i];
			for (int j = 1; j < strs.size(); j++)
			{
				int a = strs[j].find(res);
				if (strs[j].find(res) == string::npos)
				{
					if (res != "") res = res.substr(0, i); //»ØÍË1Î»
					return res;
				}
				else if (res != "" && res[0] != strs[j][0]) return "";
				else if (a != 0 && res[0] == strs[j][0])
				{
					res = res.substr(0, i);
					return res;
				}
			}
		}
	}
}
int main() {
	vector<string> strs;
	string s;
	char ch;
	while (cin >> s)
	{
		strs.push_back(s);
		if ((ch = getchar()) == '\n')
		break;
	}
	cout << longestCommonPrefix(strs) << endl;
	return 0;
}