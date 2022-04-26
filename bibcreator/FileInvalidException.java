/**
 * COMP 6481 : Assignment 2 
 * @author Garvit Kataria (40155647) and Shubhang Khattar (40163063)
 * @version : 1.0 
 */

package bibcreator;

public class FileInvalidException extends Exception {

	/**
	 * FileInvalidException is thrown when any Article file is missing some field.
	 */
	private static final long serialVersionUID = 1L;

	public FileInvalidException(String file, String fieldName)
	{
		super("Error Detected Empty Field!\n =========================\n" +
				"Problem detected with input field: " + file + "\n" +
				"File is Invalid: Field \"" + fieldName + "\" is Empty. Processing stopped ar this point. Other empty fields may be present as well!\n"
				);
	}
}
