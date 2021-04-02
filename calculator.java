package calculator;

import java.util.Stack;

public class Solution {
	public int calculate(String s) {
		Stack<Integer> num = new Stack<>();
		Stack<Character> opt = new Stack<>();
		for (int i = 0; i < s.length();) {
			if (s.charAt(i) == ' ')
				continue;
			String temp = "";
			if (s.charAt(i) >= '0') {
				while (i < s.length() && s.charAt(i) >= '0') {
					temp += s.charAt(i);
					i++;
				}
				num.push(Integer.parseInt(String.valueOf(temp)));
			} else {
				while (!opt.isEmpty() && !priority(s.charAt(i), opt.peek())) {
					int x = num.pop();
					int y = num.pop();
					char c = opt.pop();
					num.push(operator(x, y, c));
				}
				opt.push(s.charAt(i));
				i++;
			}
		}
		while (!opt.isEmpty()) {
			int x = num.pop();
			int y = num.pop();
			char c = opt.pop();
			num.push(operator(x, y, c));
		}
		return num.peek();
	}

	public boolean priority(char c1, char c2) {
		if (c1 == '+' || c1 == '-') // 优先级低
			return false;
		if ((c1 == '*' || c1 == '/') && (c2 == '*' || c2 == '/'))
			return false;
		return true;
	}

	public int operator(int x, int y, char c) {
		int ans = 0;
		switch (c) {
		case '+':
			ans = x + y;
			break;
		case '-':
			ans = y - x;
			break;
		case '*':
			ans = x * y;
			break;
		case '/':
			ans = y / x;
			break;
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.calculate(" 3/2 "));
	}
}
