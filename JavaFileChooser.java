package project; //package name



import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
This program chooses files from a directory of choice
It is set to user's home directory when using the program for the first time
 
*/
public class SimpleFileChooser {

	private JFileChooser dialog;  // The dialog, which is created when needed.

	/**
	 * Reset the default directory in the dialog box to the user's home 
	 * directory.  The next time the dialog appears, it will show the 
	 * contents of that directory.
	 */
	public void setDefaultDirectory() {
		if (dialog != null)
			dialog.setCurrentDirectory(null);
	}

	/**
	 * Set the default directory for the dialog box.  The next time the 
	 * dialog appears, it will show the contents of that directory.
	 * @param directoryName A File object that specifies the directory name.
	 * If this name is null, then the user's home directory will be used.
	 */
	public void setDefaultDirectory(String directoryName) {
		if (dialog == null)
			dialog = new JFileChooser();
		dialog.setCurrentDirectory(new File(directoryName));
	}

	/**
	 * Set the default directory for the dialog box.  The next time the 
	 * dialog appears, it will show the contents of that directory.
	 * @param directoryName The name of the new default directory.  If the 
	 * name is null, then the user's home directory will be used.
	 */
	public void setDefaultDirectory(File directory) {
		if (dialog == null)
			dialog = new JFileChooser();
		dialog.setCurrentDirectory(directory);
	}
	
	/**
	 * Show a dialog box where the user can select a file for reading.
	 * This method simply returns <code>getInputFile(null,null)</code>.
	 * @see #getInputFile(Component, String)
	 * @return the selected file, or null if the user did not select a file.
	 */
	public File getInputFile() {
		return getInputFile(null,null);
	}

	/**
	 * Showing a dialog box to select file for reading
	 * Returns null if the user did not select any file
	 */
	public File getInputFile(Component parent) {
		return getInputFile(parent,null);
	}

	
	public File getInputFile(Component parent, String dialogTitle) {
		if (dialog == null)
			dialog = new JFileChooser();
		if (dialogTitle != null)
			dialog.setDialogTitle(dialogTitle);
		else
			dialog.setDialogTitle("Select Input File");
		int option = dialog.showOpenDialog(parent);
		if (option != JFileChooser.APPROVE_OPTION)
			return null;  // User canceled or clicked the dialog's close box.
		File selectedFile = dialog.getSelectedFile();
		return selectedFile;
	}
	
	
	public File getOutputFile() {
		return getOutputFile(null,null,null);
	}

	/**
	 * Showing a dialog box where the user can select a file for writing.
	 
	 */
	public File getOutputFile(Component parent) {
		return getOutputFile(parent,null,null);
	}

	
	public File getOutputFile(Component parent, String dialogTitle) {
		return getOutputFile(parent,dialogTitle,null);
	}


	
	public File getOutputFile(Component parent, 
	                                 String dialogTitle, String defaultFile) {
		if (dialog == null)
			dialog = new JFileChooser();
		if (dialogTitle != null)
			dialog.setDialogTitle(dialogTitle);
		else
			dialog.setDialogTitle("Select Output File");
		if (defaultFile == null)
			dialog.setSelectedFile(null);
		else
			dialog.setSelectedFile(new File(defaultFile));
		while (true) {
			int option = dialog.showSaveDialog(parent);
			if (option != JFileChooser.APPROVE_OPTION)
				return null;  // User canceled or clicked the dialog's close box.
			File selectedFile = dialog.getSelectedFile();
			if ( ! selectedFile.exists() ) 
				return selectedFile;
			else {  // Ask the user whether to replace the file.
				int response = JOptionPane.showConfirmDialog( parent,
						"The file \"" + selectedFile.getName()
						+ "\" already exists.\nDo you want to replace it?", 
						"Confirm Save",
						JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.WARNING_MESSAGE );
				if (response == JOptionPane.CANCEL_OPTION)
					return null;  // User does not want to select a file.
				if (response == JOptionPane.YES_OPTION)
					return selectedFile;  // User wants to replace the file
				// A "No" response will cause the file dialog to be shown again.
			}
		}
	}

}
