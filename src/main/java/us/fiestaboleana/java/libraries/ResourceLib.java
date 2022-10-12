package us.fiestaboleana.java.libraries;

import com.mongodb.lang.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLib {

    @Nullable
    public InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            System.out.println("File not found");
        }
        return inputStream;

    }

    @Nullable
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
