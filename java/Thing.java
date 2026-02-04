class Thing {
	public static void main(String[] args) {
		int a = 5, b = 10, c = 3, answer = a++ + --b + c++;
		System.out.println(answer);
		answer = ++a + b-- + ++c;
		System.out.println(answer);
		answer = a++ + --b + c--;
		System.out.println(answer);
		/// kapag x++, i-increment si x pagkatapos i-save ang value sa integer
		/// kapag ++x, i-increment si x bago i-save ang value sa integer
	}
}
