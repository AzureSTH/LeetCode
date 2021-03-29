#include <iostream>
#include <string>
using namespace std;
int strStr(string haystack, string needle) {
	if (needle.empty()) return 0;
	else {
		int pos = haystack.find(needle);
		int flag = pos;
		if (pos == -1) return pos; //haystack中不存在needle
		else {
			while (pos != -1 && !needle.empty())
			{
				if (haystack.substr(pos + 1).find(needle.substr(1)) == 0) {
					pos++;
					needle = needle.substr(1);
				}
				else { //找到的第一个needle首字符后面的内容跟needle不匹配，再找第二个（如果有）
					pos = haystack.substr(pos + 1).find(needle);
					flag = pos;
				}
			}
			if (needle.empty()) return flag;
			else return -1;
		}
	}
}
int main() {
	string haystack;
	string needle;
	cin >> haystack >> needle;
	cout << strStr(haystack, needle) << endl;
}