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

public class ColdTeasPanel extends JPanel {

  public final double NO_COLD_TEA = 0.00;

  public final double ICED_TEA_GRANDE = 2.45;
  public final double ICED_TEA_VENTI = 2.95;

  public final double ICED_TEA_LEMONADE_GRANDE = 3.25;
  public final double ICED_TEA_LEMONADE_VENTI = 3.75;

  public final double ICED_CHAI_TEA_LATTE_GRANDE = 3.95;
  public final double ICED_CHAI_TEA_LATTE_VENTI = 4.25;

  public final double ICED_CHOCOLATE_CHAI_TEA_LATTE_GRANDE = 3.95;
  public final double ICED_CHOCOLATE_CHAI_TEA_LATTE_VENTI = 4.25;

  public final double ICED_VANILLA_CARAMEL_CHAI_TEA_LATTE_GRANDE = 3.95;
  public final double ICED_VANILLA_CARAMEL_CHAI_TEA_LATTE_VENTI = 4.25;

  //checkboxes
  private JCheckBox noColdTea, icedTea, icedTeaLemonade, icedChaiTeaLatte, icedChocolateChaiTeaLatte,
      icedVanillaCaramelChaiTeaLatte;
  JCheckBox[] checkBoxes = {icedTea = new JCheckBox("Iced Tea"),
    icedTeaLemonade = new JCheckBox("Iced Tea Lemonade"), icedChaiTeaLatte = new JCheckBox("Iced Chai Tea Latte"),
    icedChocolateChaiTeaLatte = new JCheckBox("Iced Chocolate Chai Tea Latte"),
    icedVanillaCaramelChaiTeaLatte = new JCheckBox("Iced Vanilla Caramel Chai Tea Latte"),
    noColdTea = new JCheckBox("None")};

  //comboboxes
  private JComboBox<String> cb, cb1, cb2, cb3, cb4;

  String[] sizes = {"GRANDE 16 OZ", "VENTI 20 OZ"};
  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes), cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes), cb3 = new JComboBox<String>(sizes), cb4 = new JComboBox<String>(sizes)
    };

  public ColdTeasPanel() {

    setLayout(new GridLayout(6, 2));
    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }
    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }
// Create the check boxes. 

// Add a border around the panel. 
    setBorder(BorderFactory.createTitledBorder("Cold Teas"));

    for (int i = 0; i < comboBoxes.length; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noColdTea);

  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == icedTea) {

        if (icedTea.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == icedTeaLemonade) {
        if (icedTeaLemonade.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == icedChaiTeaLatte) {
        if (icedChaiTeaLatte.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }
      else if (source == icedChocolateChaiTeaLatte) {
        if (icedChocolateChaiTeaLatte.isSelected()) {
          cb3.setVisible(true);
        }
        else {
          cb3.setVisible(false);
        }

      }
      else if (source == icedVanillaCaramelChaiTeaLatte) {
        if (icedVanillaCaramelChaiTeaLatte.isSelected()) {
          cb4.setVisible(true);
        }
        else {
          cb4.setVisible(false);
        }

      }
    
      if (source == noColdTea) {
        if (noColdTea.isSelected()) {
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

  public double getColdTeaCost() {
    double coldTeaCost = 0.0;

    if (noColdTea.isSelected()) {
      coldTeaCost += NO_COLD_TEA;
    }

    if (icedTea.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldTeaCost += ICED_TEA_GRANDE;
    }
    if (icedTea.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldTeaCost += ICED_TEA_VENTI;
    }

    if (icedTeaLemonade.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldTeaCost += ICED_TEA_LEMONADE_GRANDE;
    }
    if (icedTeaLemonade.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldTeaCost += ICED_TEA_LEMONADE_VENTI;
    }

    if (icedChaiTeaLatte.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldTeaCost += ICED_CHAI_TEA_LATTE_GRANDE;
    }
    if (icedChaiTeaLatte.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldTeaCost += ICED_CHAI_TEA_LATTE_VENTI;
    }

    if (icedChocolateChaiTeaLatte.isSelected() && cb3.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldTeaCost += ICED_CHOCOLATE_CHAI_TEA_LATTE_GRANDE;
    }
    if (icedChocolateChaiTeaLatte.isSelected() && cb3.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldTeaCost += ICED_CHOCOLATE_CHAI_TEA_LATTE_VENTI;
    }

    if (icedVanillaCaramelChaiTeaLatte.isSelected() && cb4.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldTeaCost += ICED_VANILLA_CARAMEL_CHAI_TEA_LATTE_GRANDE;
    }
    if (icedVanillaCaramelChaiTeaLatte.isSelected() && cb4.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldTeaCost += ICED_VANILLA_CARAMEL_CHAI_TEA_LATTE_GRANDE;
    }

    return coldTeaCost;

  }
}
