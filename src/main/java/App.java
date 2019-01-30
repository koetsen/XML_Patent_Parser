import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Vector;

public class App {

    public static void main(String[] args) {

        String parentDirStr = null;

        if (SystemUtils.IS_OS_LINUX) {
            parentDirStr = "/home/koet/programmieren/patente/xml/xml-Patente";
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            parentDirStr = "C:\\zeug\\Programmieren\\xml-Patente";
        }


        File xmlPatentDir = new File(parentDirStr);
        FilenameFilter xmlFilter = (File dir, String name) -> {
            if (name.endsWith(".xml")) {
                return true;
            }
            return false;
        };



       /* Vector<FileInputStream> fileStreams = new Vector<>();
        for (String filename : xmlPatentDir.list(xmlFilter)) {
            String file = new File(FilenameUtils.concat(parentDirStr, filename)).getPath();
            try {
                fileStreams.add(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream inStream = new SequenceInputStream(fileStreams.elements());

        XML_Patent_Parse xmlParser = new XML_Patent_Parse();
        xmlParser.devideDescriptionAndClaims(inStream, "/home/koet/programmieren/patente/xml/xml-Patente/outTest.xml");*/


        System.out.println("bla");
    }
}
