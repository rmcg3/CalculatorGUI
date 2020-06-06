/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorgui;

/**
 *
 * @author ryanm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpressoPanel extends JPanel {

  public final double NO_EXPRESSO = 0.00;

  public final double EXPRESSO_SOLO_GRANDE = 1.75;
  public final double EXPRESSO_SOLO_VENTI = 1.95;

  public final double EXPRESSO_CON_PANNA_GRANDE = 1.85;
  public final double EXPRESSO_CON_PANNA_VENTI = 2.05;

  public final double EXPRESSO_MACCHIATO_GRANDE = 1.75;
  public final double EXPRESSO_MACCHIATO_VENTI = 1.95;

  //checkboxes
  private JCheckBox noExpresso, expressoSolo, expressoConPanna,
      expressoMacchiato;
  JCheckBox[] checkBoxes = {expressoSolo = new JCheckBox("Expresso Solo"),
    expressoConPanna = new JCheckBox("Expresso Con Panna"),
    expressoMacchiato = new JCheckBox("Expresso Macchiato"),
    noExpresso = new JCheckBox("None")};

  //comboboxes
  private JComboBox<String> cb, cb1, cb2;

  String[] sizes = {"GRANDE 16 OZ", "VENTI 20 OZ"};
  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes), cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes)};

  public ExpressoPanel() {
    
    setLayout(new GridLayout(4, 2));
    setBorder(BorderFactory.createTitledBorder("Expresso"));
    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }
    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }
// Create the check boxes. 

// Add a border around the panel. 
//    setBorder(BorderFactory.createTitledBorder("Expresso"));

    for (int i = 0; i < comboBoxes.length; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noExpresso);
  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == expressoSolo) {

        if (expressoSolo.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == expressoConPanna) {
        if (expressoConPanna.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == expressoMacchiato) {
        if (expressoMacchiato.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }

      if (source == noExpresso) {
        if (noExpresso.isSelected()) {
          for (int i = 0; i < comboBoxes.length; i++) {
            checkBoxes[i].setSelected(false);
            checkBoxes[i].setEnabled(false);
            comboBoxes[i].setVisible(false);
          }
        }
        else {
          for (int i = 0; i < comboBoxes.length; i++) {
            checkBoxes[i].setEnabled(true);
          }
        }
      }
    }
  }

  public double getExpressoCost() {
    double expressoCost = 0.0;

    if (noExpresso.isSelected()) {
      expressoCost += NO_EXPRESSO;
    }

    if (expressoSolo.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      expressoCost += EXPRESSO_SOLO_GRANDE;
    }
    if (expressoSolo.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      expressoCost += EXPRESSO_SOLO_VENTI;
    }

    if (expressoConPanna.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      expressoCost += EXPRESSO_CON_PANNA_GRANDE;
    }
    if (expressoConPanna.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      expressoCost += EXPRESSO_CON_PANNA_VENTI;
    }

    if (expressoMacchiato.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      expressoCost += EXPRESSO_MACCHIATO_GRANDE;
    }
    if (expressoMacchiato.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      expressoCost += EXPRESSO_MACCHIATO_VENTI;
    }
    return expressoCost;

  }
}
