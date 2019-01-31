import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class App {

    public static void main(String[] args) {

        String parentDirStr = null;
        String outdir = null;

        if (SystemUtils.IS_OS_LINUX) {
            parentDirStr = "/home/koet/programmieren/patente/xml/xml-Patente";
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            parentDirStr = "C:\\zeug\\Programmieren\\xml-Patente";
            outdir = "C:\\zeug\\Programmieren\\xml-Patente\\patente_aufbereitet";
        }

        FilenameFilter xmlFilter = (File dir, String name) -> {
            if (name.endsWith(".xml")) {
                return true;
            }
            return false;
        };

        XML_Patent_Parse xml = new XML_Patent_Parse();
        File xmlPatentDir = new File(parentDirStr);
        for (String file : xmlPatentDir.list(xmlFilter)) {
            Path fullPath = Paths.get(parentDirStr, file);
            String outFilename = FilenameUtils.getBaseName(fullPath.toString()) + "_aufbereitet.xml";
            Path fullOutFilename = Paths.get(outdir, outFilename);

            System.out.printf("Bearbeite %s\n", fullPath.getFileName());
            xml.devideDescriptionAndClaims(fullPath.toString(), fullOutFilename.toString());


        }
    }
}
