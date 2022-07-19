package ex18.omok;

public class Program1 {

	public static void main(String[] args) {

		final int OMOK_COLUMN = 16;
		final int OMOK_ROW = 20;

		for (int j = 0; j < OMOK_COLUMN; j++) {

			for (int i = 0; i < OMOK_ROW; i++)
				if (i == 4 && j == 3)
					System.out.printf("%c", '○');
				else if (i == 0 && j == 0)
					System.out.printf("%c", '┌');
				else if (i == OMOK_ROW - 1 && j == 0)
					System.out.printf("%c", '┐');
				else if (i == 0 && j == OMOK_COLUMN - 1)
					System.out.printf("%c", '└');
				else if (i == OMOK_ROW - 1 && j == OMOK_COLUMN - 1)
					System.out.printf("%c", '┘');
				else if (i == 0)
					System.out.printf("%c", '├');
				else if (j == 0)
					System.out.printf("%c", '┬');
				else if (i == OMOK_ROW - 1)
					System.out.printf("%c", '┤');
				else if (j == OMOK_COLUMN - 1)
					System.out.printf("%c", '┴');
				else
					System.out.printf("%c", '┼');

			System.out.println();
		}

	}

}
