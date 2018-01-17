package main;

public class TestEnum {
	enum Color {
		RED, BLUE, YELLOW;
	}

	enum Color1 {
		RED, BLUE, YELLOW;
	}

	public static void main(String[] args) {
		Color color = Color.BLUE;
		switch (color) {
		case RED:
			System.out.println(color);
			break;
		case BLUE:
			System.out.println(color);
			break;
		case YELLOW:
			System.out.println(color);
			break;
		}
	}
}
