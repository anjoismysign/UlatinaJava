package us.fiestaboleana.java.objects;

import me.anjoismysign.anjo.entities.IntegerResult;
import me.anjoismysign.anjo.libraries.PanelLib;
import me.anjoismysign.anjo.swing.AnjoComponent;
import me.anjoismysign.anjo.swing.AnjoPane;
import me.anjoismysign.anjo.swing.components.AnjoTextField;
import me.anjoismysign.anjo.swing.listeners.TextInputType;
import us.fiestaboleana.java.libraries.ResourceLib;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anjoismysign
 */
public class Ejemplo {
    private String usuarioMinecraft, usuarioDiscord;

    /**
     * @param usuarioMinecraft el nombre de usuairo de Minecraft
     * @param usuarioDiscord   el nombre de usuario de discord
     */
    private Ejemplo(String usuarioMinecraft, String usuarioDiscord) {
        this.usuarioMinecraft = usuarioMinecraft;
        this.usuarioDiscord = usuarioDiscord;
    }

    /**
     * construye un objeto Ejemplo usando AnjoPane
     *
     * @return el objeto
     */
    public static Ejemplo construir() {
        ResourceLib recursos = new ResourceLib();

        AnjoComponent componenteMinecraft = new AnjoTextField("Nombre de usuario de Minecraft:");
        AnjoComponent componenteDiscord = new AnjoTextField("Nombre de usuario de Discord:");
        AnjoComponent componenteEdad = new AnjoTextField("Edad:")
                .addColorToText(TextInputType.INTEGER, Color.BLACK, true)
                .addColorToText(TextInputType.INTEGER, Color.RED, false);
        List<AnjoComponent> componentes = new ArrayList<>();
        componentes.add(componenteMinecraft);
        componentes.add(componenteDiscord);
        componentes.add(componenteEdad);
        AnjoPane anjoPane = AnjoPane.build(componentes, "Formulario de servidor de Minecraft", 2,
                recursos.getImageFromResourceAsStream("minecraft.png"));
        String usuarioMinecraft = anjoPane.getTextFieldText(0);
        String usuarioDiscord = anjoPane.getTextFieldText(1);
        IntegerResult resultadoEdad = anjoPane.getInteger(2);
        if (!resultadoEdad.isValid()) {
            construir();
            return null;
        }
        int edad = resultadoEdad.value();
        System.out.println("Usuario de Minecraft: " + usuarioMinecraft + "\n" +
                "Usuario de Discord: " + usuarioDiscord + "\n" +
                "Edad: " + edad);
        if (edad > 13) {
            PanelLib.showMessage("AVISO", "Recuerda que hay menores de edad en el servidor!");
        }
        return new Ejemplo(usuarioMinecraft, usuarioDiscord);
    }

    /**
     * @return el nombre de usuario de Minecraft
     */
    public String getUsuarioMinecraft() {
        return usuarioMinecraft;
    }

    /**
     * establece el nombre de usuario de Minecraft
     *
     * @param usuarioMinecraft el nombre de usuario de Minecraft
     */
    public void setUsuarioMinecraft(String usuarioMinecraft) {
        this.usuarioMinecraft = usuarioMinecraft;
    }

    /**
     * @return el nombre de usuario de Discord
     */
    public String getUsuarioDiscord() {
        return usuarioDiscord;
    }

    /**
     * establece el nombre de usuario de Discord
     *
     * @param usuarioDiscord el nombre de usuario de Discord
     */
    public void setUsuarioDiscord(String usuarioDiscord) {
        this.usuarioDiscord = usuarioDiscord;
    }
}
