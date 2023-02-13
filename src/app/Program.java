package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);

	//	String path = "D:\\temporaria\\arquivo.csv";

		System.out.println("Enter a number of products: ");
		int n = sc.nextInt();
		sc.nextLine();

		while (n != 0) {
		//	sc.nextLine();
			System.out.print("Enter data product (Product, Price, Qtd): ");
			String product = sc.nextLine();
			String[] parts = product.split(", ");

			double str1 = Double.parseDouble(parts[1]);
			int str2 = Integer.parseInt(parts[2]);

			double str3 = str1 * str2;

			String line = parts[0] + ", " + String.format("%.2f", str3);
		
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

				bw.write(line);
				bw.newLine();

			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

			n--;
		}
		System.out.println("Created! End...");

		sc.close();
	}

}
