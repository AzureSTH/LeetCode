#include<iostream>
#include<vector>
#include<map>
#include<string>
using namespace std;
vector<string> findRepeatedDnaSequences(string s) {
	vector<string> dna;
	map<string, int> temp;
	if (s.size() < 10) return dna;
	for (int i = 0; i < s.size(); i++)
		temp[s.substr(i, 10)]++;
	map<string, int>::reverse_iterator iter;
	for (iter = temp.rbegin(); iter != temp.rend(); iter++)
		if(iter->second > 1) 
			dna.push_back(iter->first);
	return dna;
}
int main()
{
	string s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
	vector<string> dna = findRepeatedDnaSequences(s);
	for (int i = 0; i < dna.size(); i++)
		cout << dna[i] << endl;
	system("pause");
	return 0;
}
