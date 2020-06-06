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

public class HotTeasPanel extends JPanel {

  public final double NO_HOT_TEA = 0.00;

  public final double CHAI_TEA_LATTE_TALL = 2.75;
  public final double CHAI_TEA_LATTE_GRANDE = 3.25;
  public final double CHAI_TEA_LATTE_VENTI = 3.45;

  public final double CHOCOLATE_CHAI_TEA_LATTE_TALL = 3.25;
  public final double CHOCOLATE_CHAI_TEA_LATTE_GRANDE = 3.75;
  public final double CHOCOLATE_CHAI_TEA_LATTE_VENTI = 4.25;

  public final double VANILLA_CHAI_TEA_LATTE_TALL = 3.25;
  public final double VANILLA_CHAI_TEA_LATTE_GRANDE = 3.75;
  public final double VANILLA_CHAI_TEA_LATTE_VENTI = 4.25;

  public final double TAZO_HOT_TEA_TALL = 2.25;
  public final double TAZO_HOT_TEA_GRANDE = 2.45;
  public final double TAZO_HOT_TEA_VENTI = 2.65;

  //checkboxes
  private JCheckBox noHotTea, chaiTeaLatte, chocolateChaiTeaLatte, vanillaChaiTeaLatte,
      tazoHotTea;
  JCheckBox[] checkBoxes = {chaiTeaLatte = new JCheckBox("Chai Tea Latte"),
    chocolateChaiTeaLatte = new JCheckBox("Chocolate Chai Tea Latte"),
    vanillaChaiTeaLatte = new JCheckBox("Vanilla Chai Tea Latte"),
    tazoHotTea = new JCheckBox("Tazo Hot Tea"), noHotTea = new JCheckBox("None")};

  //comboboxes
  private JComboBox<String> cb, cb1, cb2, cb3, cb4;

  String[] sizes = {"TALL 12 OZ", "GRANDE 16 OZ", "VENTI 20 OZ"};
  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes), cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes), cb3 = new JComboBox<String>(sizes)};

  public HotTeasPanel() {

    setLayout(new GridLayout(5, 2));

    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }
    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }
// Create the check boxes. 

// Add a border around the panel. 
    setBorder(BorderFactory.createTitledBorder("Hot Teas"));

    for (int i = 0; i < comboBoxes.length; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noHotTea);
  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == chaiTeaLatte) {

        if (chaiTeaLatte.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == chocolateChaiTeaLatte) {
        if (chocolateChaiTeaLatte.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == vanillaChaiTeaLatte) {
        if (vanillaChaiTeaLatte.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }
      else if (source == tazoHotTea) {
        if (tazoHotTea.isSelected()) {
          cb3.setVisible(true);
        }
        else {
          cb3.setVisible(false);
        }

      }
      if (source == noHotTea) {
        if (noHotTea.isSelected()) {
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

  public double getHotTeaCost() {
    double hotTeaCost = 0.0;

    if (noHotTea.isSelected()) {
      hotTeaCost += NO_HOT_TEA;
    }
    if (chaiTeaLatte.isSelected() && cb.getSelectedItem().toString() == "TALL 12 OZ") {
      hotTeaCost += CHAI_TEA_LATTE_TALL;
    }
    if (chaiTeaLatte.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotTeaCost += CHAI_TEA_LATTE_GRANDE;
    }
    if (chaiTeaLatte.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotTeaCost += CHAI_TEA_LATTE_VENTI;
    }

    if (chocolateChaiTeaLatte.isSelected() && cb1.getSelectedItem().toString() == "TALL 12 OZ") {
      hotTeaCost += CHOCOLATE_CHAI_TEA_LATTE_TALL;
    }
    if (chocolateChaiTeaLatte.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotTeaCost += CHOCOLATE_CHAI_TEA_LATTE_GRANDE;
    }
    if (chocolateChaiTeaLatte.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotTeaCost += CHOCOLATE_CHAI_TEA_LATTE_VENTI;
    }

    if (vanillaChaiTeaLatte.isSelected() && cb2.getSelectedItem().toString() == "TALL 12 OZ") {
      hotTeaCost += VANILLA_CHAI_TEA_LATTE_TALL;
    }
    if (vanillaChaiTeaLatte.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotTeaCost += VANILLA_CHAI_TEA_LATTE_GRANDE;
    }
    if (vanillaChaiTeaLatte.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotTeaCost += VANILLA_CHAI_TEA_LATTE_VENTI;
    }
    
    if (tazoHotTea.isSelected() && cb3.getSelectedItem().toString() == "TALL 12 OZ") {
      hotTeaCost += TAZO_HOT_TEA_TALL;
    }
    if (tazoHotTea.isSelected() && cb3.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotTeaCost += TAZO_HOT_TEA_GRANDE;
    }
    if (tazoHotTea.isSelected() && cb3.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotTeaCost += TAZO_HOT_TEA_VENTI;
    }
    return hotTeaCost;

  }
}
