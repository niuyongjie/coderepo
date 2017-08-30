/**
 * 演示了表达式中自动类型转换
 * 从每个子表达式进行自动类型转换到整个表达式进行自动类型转换
 */
class Promote{
	public static void main(String[] args){
		byte b = 42;
		char c = 'a';
		short s = 1024;
		int i = 50000;
		float f = 5.67f;
		double d = .1234;

		double result = (f * b) + (i / c) - (d * s);
		System.out.println((f * b) + " + " + (i / c) + " - " + (d * s));
		System.out.println("result = " + result);
	}
}
