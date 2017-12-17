package main;

class MyException extends Exception {
	public MyException() {
	}

	public MyException(String msg) {
		super(msg);
	}

	public MyException(String msg, int x) {
		super(msg);
		i = x;
	}

	public int val() {
		return i;
	}

	private int i;
}

public class ExceptionDemo {
	/**
	 * <br>
	 * ����˵����ʹ��MyException����Ĭ�ϵĹ�����
	 */
	public static void a() throws MyException {
		System.out.println("Throwing MyException from a()");
		throw new MyException();// �׳��쳣����������
	}

	/**
	 * <br>
	 * ����˵����ʹ��MyException���д���Ϣ�Ĺ�����
	 */
	public static void b() throws MyException {
		System.out.println("Throwing MyException from b()");
		throw new MyException("error in b ()");
	}

	/**
	 * <br>
	 * ����˵����ʹ����MyException���б���Ĺ�����
	 */
	public static void c() throws MyException {
		System.out.println("Throwing MyException from c()");
		throw new MyException("error in c()", 404);
	}

	public static void main(String[] args) {
		try {
			a();
		} catch (MyException e) {
			System.out.println("Error=" + e.getMessage());
		}
		try {
			b();
		} catch (MyException e) {
			System.out.println("Error=" + e.getMessage());
			// e.toString();
		}
		try {
			c();
		} catch (MyException e) {
			System.out.println("Error=" + e.getMessage());
			e.printStackTrace();
			System.out.println("error code: " + e.val());
		}
	}
}