/**
 * COMP 6481 : Assignment 2 
 * @author Garvit Kataria (40155647) and Shubhang Khattar (40163063)
 * @version : 1.0 
 */

package bibcreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	/*
	 * Driver method.
	 */

	public static void main(String[] args) {

		System.out.println("Welcome to BibCreater!\n");
		String path = "./Comp6481_F21_Assg2_Files";
		String fileName = "/Latex";
		String extention = ".bib";

		int validFiles = 0;
		int invalidFiles = 0;

		Scanner sc = null;
		for (int i = 1; i <= 10; i++) {
			String fileSrcPath = path + fileName + i + extention;
			try {
				sc = new Scanner(new FileInputStream(fileSrcPath));
			} catch (FileNotFoundException e) {
				System.out.format(
						"Could not open input file %s for reading. \n Please check if file exists! Program will terminate after closing any opened files.",
						fileSrcPath);
				System.exit(0);
			}

			try {
				boolean filesCreated = BibCreator.processFilesForValidation(sc, fileSrcPath, path, i);

				if (!filesCreated) {

					deleteFiles(path, i);

					System.exit(0);
				}

				validFiles++;
			} catch (FileInvalidException e) {
				invalidFiles++;
				System.out.println(e.getMessage());
			} catch (Exception e) {
				invalidFiles++;
				System.out.println(e.getMessage());
			}
			sc.close();
		}
		System.out.format(
				"A total of %s files were invalid, and could not be processed. All other %s \"Valid\" files have been created.",
				invalidFiles, validFiles);

		DisplayFile(path, 2);

		System.out.println("\nGoodbye! Hope you have enjoyed creating the needed files using BibCreator.");

	}

	/*
	 * DisplayFile method displays the file that the user provide.
	 * 
	 * @param path : Path to the directory containing files.
	 * 
	 * @param allowedTry : The number of maximum tries that should be given to the
	 * user.
	 */

	static void DisplayFile(String path, int allowedTry) {

		BufferedReader br = null;

		Scanner sc = new Scanner(System.in);

		if (allowedTry == 0) {

			System.out
					.println("\nCould not open input file again! Either file does not exist or could not be created.");
			System.out.println("Sorry! I am unable to display your desired files! PRogram will exit!");
			System.exit(0);

		}

		try {
			System.out.print("\n\nPlease enter the name of one of the files that you need to review: ");

			String fileName = sc.nextLine();

			System.out.println("Here are the contents of the succesfully created Jason File: " + fileName);

			br = new BufferedReader(new FileReader(path + "/" + fileName));

			String line = br.readLine();

			while (line != null) {

				System.out.println(line);

				line = br.readLine();

			}

		} catch (FileNotFoundException e) {
			System.out.println("\nCould not open input file. File does not exist; possibly it could not be created!");
			System.out.println("However, you will be allowed another chance to enter another file name.");
			DisplayFile(path, --allowedTry);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * deleteFiles method delete the files that might have been created till the
	 * index given
	 * 
	 * @param path : Path to the directory containing files.
	 * 
	 * @param index : Index to which the files to be deleted.
	 */

	static void deleteFiles(String path, int index) {

		String[] journals = { "/IEEE", "/ACM", "/NJ" };

		String extension = ".json";

		for (String journal : journals) {

			for (int i = 1; i <= index; i++) {

				String buildPath = path + journal + i + extension;

				File file = new File(buildPath);

				System.out.println(buildPath);

				if (file.exists()) {
					file.delete();
				}

			}

		}

	}

}
