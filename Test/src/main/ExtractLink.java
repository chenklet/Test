package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractLink {
	public static void main(String[] args) throws IOException {
		// File input = new File("E:\\git\\LuckyDogApp\\test.txt");
		File input = new File("E:\\git\\LuckyDogApp\\test1.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(input), "UTF-8"));
		String testString = br.readLine();
		if(testString.charAt(0) == 65279)
			testString = testString.substring(1);
		System.out.println(testString);
		br.close();
	}
}
