/**
 * [[[copyright]]]
 */
package tests.search;

import edu.cmu.sphinx.model.acoustic.AcousticModel;

import edu.cmu.sphinx.search.Dictionary;
import edu.cmu.sphinx.search.Linguist;
import edu.cmu.sphinx.search.SimpleLinguist;

import edu.cmu.sphinx.util.SphinxProperties;

import java.io.File;

import java.net.URL;


/**
 * A test for SimpleLinguist class that reads in the connected-digits
 * dictionaries and dumps out the dictionary.
 */
public class SimpleLinguistTest {


    private String context = "SimpleLinguistTest";


    /**
     * Construct a SimpleLinguistTest with the given SphinxProperties file.
     *
     * @param propertiesFile a SphinxProperties file
     */
    public SimpleLinguistTest(String propertiesFile) throws Exception {
        
        String pwd = System.getProperty("user.dir");
        SphinxProperties.initContext
            (context, new URL
             ("file://" + pwd + File.separatorChar + propertiesFile));
        
        Linguist simpleLinguist = new SimpleLinguist
            (context, AcousticModel.getAcousticModel(context));

        System.out.print
            (((SimpleLinguist) simpleLinguist).getGrammar().toString());
    }


    /**
     * Main method of this Test.
     */
    public static void main(String[] argv) {
        try {
            SimpleLinguistTest test = new SimpleLinguistTest(argv[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
