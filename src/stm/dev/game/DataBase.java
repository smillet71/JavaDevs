package stm.dev.game;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.ini4j.Ini;

/**
 * 
 * @author smill
 *
 */
public class DataBase {
	
	//
	private static Hashtable<String, Object> databases = null;

	/**
	 * 
	 * @param ini
	 */
	static void loadDatabase(File file)
	{
		//
		databases = new Hashtable<String, Object>();
		//
		loadDatabase("stm/dev/resources/data/spacecrafts.ini");
	}

	/**
	 * 
	 */
	static void loadDatabase(String filename)
	{
		//
		File iniFile = new File(filename);
		//
		if (iniFile.exists()) {
			try {
				readIni(new Ini(new FileReader(iniFile)));
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		} 
	}

	/**
	 * 
	 */
	static void readIni(Ini ini) {
		
	}

}
