// Demostate the basic arithmetic operators.
class BasicMath{
	public static void main(String[] args){
		// arithmetic using integers
		System.out.println("Integer Arithmetic.");

		int a = 1 + 1;
		int b = a * 3;
		int c = b / 4;
		int d = c - a;
		int e = -d;
		int f = +d;
		int g = +e;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		System.out.println("g = " + g);

		// arithmetic using double
		
		System.out.println("\nFloating Point Arithmetic");
	        double da = 1 + 1;
		double db = da * 3;
		double dc = db / 4; //注意表达式类型自动转换
		double dd = dc - a;
	        double de = -dd;
		double df = +dd;
		double dg = +de;


		System.out.println("da = " + da);
		System.out.println("db = " + db);
		System.out.println("dc = " + dc);
		System.out.println("dd = " + dd);
		System.out.println("de = " + de);
		System.out.println("df = " + df);
		System.out.println("dg = " + dg);
	}
}
