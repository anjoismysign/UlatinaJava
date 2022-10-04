package us.fiestaboleana.java.objects;

import us.fiestaboleana.java.swing.AnjoComponent;
import us.fiestaboleana.java.swing.AnjoPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sample {
    private String minecraftUsername;
    private String discordUsername;

    public Sample(String minecraftUsername, String discordUsername) {
        this.minecraftUsername = minecraftUsername;
        this.discordUsername = discordUsername;
    }

    public static Sample build() {
        List<AnjoComponent> components = new ArrayList<>();
        components.add(new AnjoComponent("Nombre de usuario (Minecraft)", new JTextField(20)));
        components.add(new AnjoComponent("Nombre de usuario (Discord)", new JTextField(20)));
        AnjoPane pane = AnjoPane.build(components, "WHITELIST", 0,
                new ImageIcon("src/main/resources/minecraft.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        String minecraftUsername = pane.getTextFieldText(0);
        System.out.println(minecraftUsername);
        String discordUsername = pane.getTextFieldText(1);
        System.out.printf(discordUsername);
        return new Sample(minecraftUsername, discordUsername);
    }

    public String getMinecraftUsername() {
        return minecraftUsername;
    }

    public void setMinecraftUsername(String minecraftUsername) {
        this.minecraftUsername = minecraftUsername;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public void setDiscordUsername(String discordUsername) {
        this.discordUsername = discordUsername;
    }
}
