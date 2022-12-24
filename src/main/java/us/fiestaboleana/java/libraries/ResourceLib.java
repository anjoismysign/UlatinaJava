package us.fiestaboleana.java.libraries;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author anjoismysign
 */
public class ResourceLib {

    /**
     * Obtiene un recurso de la carpeta resources
     *
     * @param fileName nombre del archivo
     * @return el recurso
     */
    public InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            System.out.println("File not found");
        }
        return inputStream;
    }

    /**
     * Obtiene una imagen de la carpeta resources
     *
     * @param fileName nombre del archivo
     * @return la imagen
     */
    public BufferedImage getImageFromResourceAsStream(String fileName) {

        BufferedImage img = null;
        try {
            img = ImageIO.read(getFileFromResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;

    }
}
