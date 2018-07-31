#include <iostream>
#include <string>
using namespace std;
void findmax(int letter[], int &result)
{
	int max = 0;
	for (int i = 0; i < 256; i++)
		if (letter[i] >= max) {
			max = letter[i];
			result = i;
		}
}
string frequencySort(string s) {
	int letter[256] = { 0 };
	int result = 0;//最大频率字母编号
	string word;
	for (int i = 0; i < s.size(); i++)
	{
		letter[s[i]]++;
	}
	for (int i = 0; i < s.size(); i++)
	{
		findmax(letter, result);
		word.append(letter[result], result);
		letter[result] = 0;
	}
	return word;
}
