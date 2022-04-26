/**
 * COMP 6481 : Assignment 2 
 * @author Garvit Kataria (40155647) and Shubhang Khattar (40163063)
 * @version : 1.0 
 */

package bibcreator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;




public class BibCreator {
	
	/**
	 * It's method processFilesForValidation is the Main method responsible for creating the Article objects 
	 * creating and then creating all the corresponding JSON files.     
	 * 
	 * 	@param	sc : Scanner Object responsible for reading the files.
	 * 	@param	fileSrcPath : Source of the file.
	 *  @param	path : Path of the file.
	 *  @param	index : contains Latex index.
	 */
	
	
	static boolean processFilesForValidation(Scanner sc, String fileSrcPath, String path, int index)
			throws FileInvalidException {
		// System.out.format("Processing file:%s \n", fileSrcPath);
		List<Article> articleList = new ArrayList<>();
		String temp = "";
		while (sc.hasNextLine()) {
			Article article = new Article();

			temp = "";
			while (temp.length() == 0 && sc.hasNextLine())
				temp = sc.nextLine().trim();
			if (temp.length() == 0 && !sc.hasNextLine())
				break;

			temp = "";
			while (temp.length() == 0 && sc.hasNextLine())
				temp = sc.nextLine().trim();

			if (temp.length() == 0 && !sc.hasNextLine())
				break;

			for (int j = 1; j <= 11; j++) {
				temp = "";
				while (temp.length() == 0 && sc.hasNextLine())
					temp = sc.nextLine().trim();
				if (temp.length() == 0 && !sc.hasNextLine())
					break;
				String[] fieldAuthor = temp.split("=");

				if (fieldAuthor[0].equals("author")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "author");
					article.setAuthor(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("journal")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "journal");
					article.setJournal(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("title")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "title");
					article.setTitle(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("year")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "year");
					article.setYear(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("volume")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "volume");
					article.setVolume(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("number")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "number");
					article.setNumber(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("pages")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "pages");
					article.setPages(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("keywords")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "keywords");
					article.setKeywords(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("pages")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "pages");
					article.setPages(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("doi")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "doi");
					article.setDoi(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("ISSN")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "ISSN");
					article.setISSN(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				} else if (fieldAuthor[0].equals("month")) {
					if (fieldAuthor[1].length() == 3)
						throw new FileInvalidException(fileSrcPath, "month");
					article.setMonth(fieldAuthor[1].substring(1, fieldAuthor[1].length() - 2));
				}
			}

			temp = "";
			while (temp.length() == 0 && sc.hasNextLine())
				temp = sc.nextLine().trim();
			if (temp.length() == 0 && !sc.hasNextLine())
				break;

			articleList.add(article);

		}

		boolean boolIEEE = createIEEE(articleList, path, index);

		boolean boolACM = createACM(articleList, path, index);

		boolean boolNJ = createNJ(articleList, path, index);

		return boolIEEE && boolACM && boolNJ;

		/*
		 * System.out.println(articleList.size()); for(Article a: articleList)
		 * System.out.println(a); System.out.println("=================");
		 */

	}
	
	
	/**
	 *  Method createIEEE is responsible for creating all the IEEE format files. 
	 * 
	 * 	@param	articleList : List of Article objects.
	 *  @param	path : Path of the file.
	 *  @param	index : contains Latex index.
	 */

	static boolean createIEEE(List<Article> articleList, String path, int index) {

		PrintWriter pw = null;

		String extension = ".json";

		String journal = "/IEEE";

		String fileBuildPath = path + journal + index + extension;

		try {

			pw = new PrintWriter(new FileOutputStream(fileBuildPath));

			String articleEntry = "";

			for (Article paper : articleList) {

				articleEntry = "";

				String[] authors = paper.getAuthor().split("and");

				int i = 0;

				for (; i < authors.length - 1; i++) {

					articleEntry += authors[i].trim() + ", ";

				}

				articleEntry += authors[i] + ", ";

				articleEntry += "\"" + paper.getTitle() + "\", " + paper.getJournal() + ", vol. " + paper.getVolume()
						+ ", no. " + paper.getNumber() + ", p. " + paper.getPages() + ", " + paper.getMonth() + " "
						+ paper.getYear() + ".";

				pw.println(articleEntry);
				pw.println();

			}

			return true;

		} catch (IOException e) {
			System.out.println("Could not create File \"" + journal + index + extension + "\". Program will exir now.");

			return false;
		} finally {
			pw.close();
		}

	}
	
	/**
	 *  Method createACM is responsible for creating all the ACM format files. 
	 * 
	 * 	@param	articleList : List of Article objects.
	 *  @param	path : Path of the file.
	 *  @param	index : contains Latex index.
	 */

	static boolean createACM(List<Article> articleList, String path, int index) {

		PrintWriter pw = null;

		String extension = ".json";

		String journal = "/ACM";

		String fileBuildPath = path + journal + index + extension;

		try {

			int count = 0;

			pw = new PrintWriter(new FileOutputStream(fileBuildPath));

			String articleEntry = "";

			for (Article paper : articleList) {

				articleEntry = "[" + ++count + "] ";

				String[] authors = paper.getAuthor().split("and");

				articleEntry += authors[0].trim() + " et al. " + paper.getYear() + ". " + paper.getTitle() + ". "
						+ paper.getJournal() + ". " + paper.getVolume() + ", " + paper.getNumber() + " ("
						+ paper.getYear() + "), " + paper.getPages() + ". DOI:https://doi.org/" + paper.getDoi() + ".";

				pw.println(articleEntry);
				pw.println();

			}

			return true;

		} catch (IOException e) {
			System.out.println("Could not create File \"" + journal + index + extension + "\". Program will exir now.");

			return false;
		} finally {
			pw.close();

		}

	}
	
	/**
	 *  Method createNJ is responsible for creating all the NJ format files. 
	 * 
	 * 	@param	articleList : List of Article objects.
	 *  @param	path : Path of the file.
	 *  @param	index : contains Latex index.
	 */

	static boolean createNJ(List<Article> articleList, String path, int index) {

		PrintWriter pw = null;

		String extension = ".json";

		String journal = "/NJ";

		String fileBuildPath = path + journal + index + extension;

		try {

			pw = new PrintWriter(new FileOutputStream(fileBuildPath));

			String articleEntry = "";

			for (Article paper : articleList) {

				articleEntry = "";

				String[] authors = paper.getAuthor().split("and");

				int i = 0;

				for (; i < authors.length - 1; i++) {

					articleEntry += authors[i].trim() + " & ";

				}

				articleEntry += authors[i] + ". ";

				articleEntry += paper.getTitle() + ". " + paper.getJournal() + ". " + paper.getVolume() + ", "
						+ paper.getPages() + "(" + paper.getYear() + ").";

				pw.println(articleEntry);
				pw.println();

			}

			return true;

		} catch (IOException e) {
			System.out.println("Could not create File \"" + journal + index + extension + "\". Program will exir now.");

			return false;
		} finally {
			pw.close();
		}

	}

}
