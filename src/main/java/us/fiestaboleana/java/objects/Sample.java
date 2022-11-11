package us.fiestaboleana.java.objects;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anjoismysign
 */
public class Sample {
    private String minecraftUsername, discordUsername;

    /**
     * @param minecraftUsername the minecraft username
     * @param discordUsername   the discord username
     */
    public Sample(String minecraftUsername, String discordUsername) {
        this.minecraftUsername = minecraftUsername;
        this.discordUsername = discordUsername;
    }

    /**
     * builds a Sample object which makes use of AnjoPane &amp; AnjoComponent
     *
     * @return the Sample object
     */
    public static Sample constuir() {
        AnjoComponent componente1 = new AnjoComponent("Nombre de usuario de Minecraft:", new JTextField());
        AnjoComponent componente2 = new AnjoComponent("Nombre de usuario de Discord:", new JTextField());
        AnjoComponent componente3 = new AnjoComponent("Altura:", new JTextField());
        List<AnjoComponent> componentes = new ArrayList<>();
        componentes.add(componente1);
        componentes.add(componente2);
        componentes.add(componente3);
        AnjoPane anjoPane = AnjoPane.build(componentes, "Programa de prueba", 2, null);
        String minecraftUsername = anjoPane.getTextFieldText(0);
        String discordUsername = anjoPane.getTextFieldText(1);
        DoubleResult result = anjoPane.getDouble(2);
        if (!result.isValid()) {
            constuir();
            return null;
        }
        double height = result.value();
        System.out.println(minecraftUsername + ", " + discordUsername + ", " + height);

////
////        ResourceLib resourceLib = new ResourceLib();
////        List<AnjoComponent> components = new ArrayList<>();
////        components.add(new AnjoComponent("Nombre de usuario (Minecraft)", new JTextField(20)));
////        components.add(new AnjoComponent("Nombre de usuario (Discord)", new JTextField(20)));
////        AnjoPane pane = AnjoPane.build(components, "WHITELIST", -1,
////                resourceLib.getImageFromResourceAsStream("minecraft.png").getScaledInstance(128, 128, Image.SCALE_SMOOTH));
//        String minecraftUsername = pane.getTextFieldText(0);
//        System.out.println(minecraftUsername);
//        String discordUsername = pane.getTextFieldText(1);
//        System.out.printf(discordUsername);
        return new Sample(minecraftUsername, discordUsername);
    }

    /**
     * @return the minecraft username
     */
    public String getMinecraftUsername() {
        return minecraftUsername;
    }

    /**
     * sets the minecraft username
     *
     * @param minecraftUsername the username
     */
    public void setMinecraftUsername(String minecraftUsername) {
        this.minecraftUsername = minecraftUsername;
    }

    /**
     * @return the discord username
     */
    public String getDiscordUsername() {
        return discordUsername;
    }

    /**
     * sets the discord username
     *
     * @param discordUsername the username
     */
    public void setDiscordUsername(String discordUsername) {
        this.discordUsername = discordUsername;
    }
}
