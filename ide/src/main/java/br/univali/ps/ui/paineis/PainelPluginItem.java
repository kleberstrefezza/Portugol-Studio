/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.ps.ui.paineis;

import br.univali.ps.plugins.base.MetaDadosPlugin;
import br.univali.ps.ui.swing.ColorController;
import br.univali.ps.ui.swing.weblaf.WeblafUtils;
import br.univali.ps.ui.utils.IconFactory;
import com.alee.laf.button.WebButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Adson Esteves
 */
public class PainelPluginItem extends javax.swing.JPanel {

    /**
     * Creates new form PainelPluginItem
     */
    private MetaDadosPlugin metaDados;
    
    public PainelPluginItem(MetaDadosPlugin metaDados) {
        initComponents();
        this.metaDados = metaDados;
        configurarPainel();
    }
    private void configurarPainel()
    {
        final JLabel renderer = new JLabel();

        renderer.setIcon(new ImageIcon(metaDados.getIcone16x16()));
        renderer.setText(metaDados.getNome());
        renderer.setBorder(new EmptyBorder(5, 10, 5, 0));
        renderer.setForeground(ColorController.COR_LETRA);
        this.add(renderer);

        WebButton botaoDesinstalarPlugin = new WebButton(new AbstractAction("", IconFactory.createIcon(IconFactory.CAMINHO_ICONES_PEQUENOS, "remove.png")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Desinstalando "+ metaDados.getNome());
            }
        });

        WebButton botaoConfiguracoesPlugin = new WebButton(new AbstractAction("", IconFactory.createIcon(IconFactory.CAMINHO_ICONES_PEQUENOS, "gear_in.png")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Configuraçoes "+ metaDados.getNome());
            }
        });

        if (WeblafUtils.weblafEstaInstalado()) {
            WeblafUtils.configurarBotao(botaoDesinstalarPlugin, ColorController.COR_DESTAQUE, ColorController.COR_LETRA, ColorController.FUNDO_MEDIO, ColorController.COR_LETRA, 2, true);
            WeblafUtils.configurarBotao(botaoConfiguracoesPlugin, ColorController.COR_DESTAQUE, ColorController.COR_LETRA, ColorController.FUNDO_MEDIO, ColorController.COR_LETRA, 2, true);            
        }
        this.add(botaoDesinstalarPlugin);
        this.add(botaoConfiguracoesPlugin);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
