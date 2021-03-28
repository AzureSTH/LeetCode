#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stack>
using namespace std;
bool isValid(string s) {
	stack<char> left;
	if (s.size() % 2 != 0) return false;
	else {
		for (int i = 0; i < s.size(); i++)
		{
			if (s[i] == '(' || s[i] == '[' || s[i] == '{')
				left.push(s[i]);
			else
			{
				if (left.empty()) return false; //s�ﻹ���ַ������Ѿ�û�п�ƥ�����
				else if (string(1, left.top()) + string(1, s[i]) == "()" || string(1, left.top()) + string(1, s[i]) == "[]" || string(1, left.top()) + string(1, s[i]) == "{}") //���ֱ��if-else�ж��ٶȻ����
					left.pop();
				else return false;
			}
		}
		if (!left.empty()) return false;
		return true;
	}
}
int main() {
	string s;  //1 <= s.length <= 10^4
	cin >> s;
	string a=string(1, s[0]) + string(1, s[1]);
	cout << isValid(s) << endl;
	return 0;
}