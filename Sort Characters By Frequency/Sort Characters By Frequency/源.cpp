#include <iostream>
#include <string>
using namespace std;
void findmax(int letter[],int &result)
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
	int result = 0;//���Ƶ����ĸ���
	string word;
	for (int i = 0; i < s.size(); i++)
	{//Сд��ǰ ��д�ں�
		if (s[i] > 'Z'&&s[i] <= 'z') {
			letter[s[i] - 32]++; 
			continue;
		}
		if (s[i] <= 'Z'&&s[i] >= 'A') letter[s[i] + 32]++;
		else letter[s[i]]++;
	}
	for (int i = 0; i < s.size(); i++)
	{
		findmax(letter,result);
		if (result < 91 && result > 64)//Сд
			word.append(letter[result], result + 32);
		if (result < 123 && result > 96) 
			word.append(letter[result], result - 32);
			if (result > 96 && result < 123 && letter[result - 32] == letter[result])
			{
				word.append(letter[result], result);
					letter[result - 32] = 0;
			}
		if(result < 65 || (result > 90 && result < 97) || result > 122)
			word.append(letter[result], result);
		letter[result] = 0;
	}
	return word;
}
int main()
{
	string s;
	cin >> s;
	string word = frequencySort(s);
	for (int i = 0; i < word.size(); i++)
		cout << word[i];
	system("pause");
	return 0;
}