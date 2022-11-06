package helpers;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.fail;

public class OCRHelper {

	/*
	Function to get string from image
	 */
	public static String getStringFromImageElement ( RemoteWebElement element ) {
		try {
			Tesseract tesseract = new Tesseract( );

			String ocrImagesFolder = Files.createDirectories( Paths.get( "target/ocrImages" ) ).toFile( ).getAbsolutePath( );
			File documentImage = element.getScreenshotAs( OutputType.FILE );
			File targetImage = new File( ocrImagesFolder + "/image.png" );

			FileUtils.copyFile( documentImage, targetImage );

			tesseract.setDatapath( LoadLibs.extractTessResources( "tessdata" ).getAbsolutePath( ) );
			return tesseract.doOCR( targetImage );
		} catch ( IOException e ) {
			fail( "There was an error taking screenshot of the element" );
		} catch ( TesseractException e ) {
			fail( "There was an error reading the image" );
		}
		return null;
	}

}
