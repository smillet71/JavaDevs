package stm.dev.game;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ini4j.Ini;

/**
 * 
 * @author smill
 *
 */
public class Options {

	//
	private static File iniFile = null;

	//
	private static Ini ini = null;

	/**
	 * 
	 * @param ini
	 */
	static void loadOptions(File file)
	{
		//
		iniFile = file;
		loadOptions();
	}

	/**
	 * 
	 */
	static void loadOptions()
	{
		//
		iniFile = new File(System.getenv("HOME")+File.separator+".eXplorer"+File.separator+"options.ini");
		//
		if (iniFile.exists()) {
			try {
				ini = new Ini(new FileReader(iniFile));
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		} else {
			createOptions();
		} 
	}

	/**
	 * 
	 */
	private static void createOptions() {
		iniFile.getParentFile().mkdirs();
		ini = new Ini();
		setDefaultOptions();
		saveOptions();
	}

	/**
	 * 
	 */
	private static void setDefaultOptions() {

	}

	/**
	 * 
	 */
	private static void saveOptions() {
		try {
			ini.store(iniFile);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
