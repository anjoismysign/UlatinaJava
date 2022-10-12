package us.fiestaboleana.java.swing;

import us.fiestaboleana.java.libraries.SwingLib;

import javax.swing.*;
import java.awt.*;

public class AnjoConfirmDialog {
    private int result;

    public AnjoConfirmDialog(JPanel jPanel, String title, int optionType, Image image) {
        run(jPanel, title, optionType, image);
    }

    public void run(JPanel jPanel, String title, int optionType, Image image)
            throws IllegalStateException {
        this.result = -1;
        JPanel master = new JPanel(new BorderLayout());
        master.add(jPanel, BorderLayout.CENTER);
        JPanel foot;
        JDialog dialog = new JDialog();
        dialog.setTitle(title);
        if (image != null) {
            if (Taskbar.isTaskbarSupported())
                Taskbar.getTaskbar().setIconImage(image);
            dialog.setIconImage(image.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        }
        dialog.add(master);
        switch (optionType) {
            case 0 -> {
                foot = new JPanel(new GridLayout(1, 2));
                master.add(foot, BorderLayout.PAGE_END);
                JButton no = new JButton((String) UIManager.get("OptionPane.noButtonText"));
                JButton yes = new JButton((String) UIManager.get("OptionPane.yesButtonText"));
                foot.add(no);
                foot.add(yes);
                dialog.pack();
                dialog.setResizable(false);
                no.addActionListener(e -> {
                    this.result = 1;
                    dialog.dispose();
                });
                yes.addActionListener(e -> {
                    this.result = 0;
                    dialog.dispose();
                });
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                SwingLib.center(dialog);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            case 1 -> {
                foot = new JPanel(new GridLayout(1, 3));
                master.add(foot, BorderLayout.PAGE_END);
                JButton cancel = new JButton((String) UIManager.get("OptionPane.cancelButtonText"));
                cancel.addActionListener(e -> {
                    this.result = 2;
                    dialog.dispose();
                });
                JButton no = new JButton((String) UIManager.get("OptionPane.noButtonText"));
                JButton yes = new JButton((String) UIManager.get("OptionPane.yesButtonText"));
                foot.add(cancel);
                foot.add(no);
                foot.add(yes);
                dialog.pack();
                no.addActionListener(e -> {
                    this.result = 1;
                    dialog.dispose();
                });
                yes.addActionListener(e -> {
                    this.result = 0;
                    dialog.dispose();
                });
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                SwingLib.center(dialog);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            case 2 -> {
                foot = new JPanel(new GridLayout(1, 2));
                master.add(foot, BorderLayout.PAGE_END);
                JButton cancel = new JButton((String) UIManager.get("OptionPane.cancelButtonText"));
                JButton ok = new JButton((String) UIManager.get("OptionPane.okButtonText"));
                foot.add(cancel);
                foot.add(ok);
                dialog.pack();
                cancel.addActionListener(e -> {
                    this.result = 2;
                    dialog.dispose();
                });
                ok.addActionListener(e -> {
                    this.result = 0;
                    dialog.dispose();
                });
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                SwingLib.center(dialog);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            case -1 -> {
                foot = new JPanel(new GridLayout(1, 1));
                master.add(foot, BorderLayout.PAGE_END);
                JButton ok = new JButton((String) UIManager.get("OptionPane.okButtonText"));
                foot.add(ok);
                dialog.pack();
                ok.addActionListener(e -> {
                    this.result = 0;
                    dialog.dispose();
                });
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                SwingLib.center(dialog);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            default -> {
                throw new IllegalStateException("Unexpected optionType: " + optionType);
            }
        }
    }

    /**
     * @return 0 = yes/ok, 1 = no, 2 = cancel, -1 = close
     * 0 = si/ok, 1 = no, 2 = cancelar, -1 = cerrar
     */
    public int getResult() {
        return result;
    }
}
