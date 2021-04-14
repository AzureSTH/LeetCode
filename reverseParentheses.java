class Solution {
    public String reverse(String s) // 反转一段字符串
	{
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			stk.add(s.charAt(i));
		}
		String res = "";
		while (!stk.empty()) {
			res += stk.peek();
			stk.pop();
		}
		return res;
	}
    public String reverseParentheses(String s) {
        //Main m = new Main();
		// Scanner in = new Scanner(System.in);
		// String s = in.nextLine();
		String temp = "";
		String news = s;
		String res = "";
		Stack<Character> stk2 = new Stack<>(); // 存括号
		Stack<Integer> a = new Stack<>(); // 存每对括号里面第一个字符的位置
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == ')') {
				if (c == '(') {
					a.add(i + 1);
					stk2.add(c);
				}
				if (c == ')' && stk2.peek() == '(') {
					stk2.pop();
					temp = news.substring(a.peek(), i); // 取括号内子串
					temp = reverse(temp);
					int k = 0;
					// news="";
					news = news.substring(0, a.peek()) + temp + news.substring(i, s.length()); // 更新字符串
					a.pop();
				}
			} // if
		}
		for (int i = 0; i < news.length(); i++) {
			if (news.charAt(i) == '(' || news.charAt(i) == ')')
				continue;
			else
				res += news.charAt(i);
		}
		return res;
    }
}