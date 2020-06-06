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

public class FrappuccinoPanel extends JPanel {

  public final double NO_FRAPP = 0.00;

  public final double COFFEE_GRANDE = 3.95;
  public final double COFFEE_VENTI = 4.45;

  public final double CARAMEL_GRANDE = 4.65;
  public final double CARAMEL_VENTI = 4.85;

  public final double MOCHA_GRANDE = 4.65;
  public final double MOCHA_VENTI = 4.95;

  public final double WHITE_CHOCOLATE_MOCHA_GRANDE = 4.65;
  public final double WHITE_CHOCOLATE_MOCHA_VENTI = 4.95;

  public final double JAVA_CHIP_GRANDE = 4.65;
  public final double JAVA_CHIP_VENTI = 4.95;

  public final double VANILLA_BEAN_CREME_GRANDE = 3.95;
  public final double VANILLA_BEAN_CREME_VENTI = 4.45;

  public final double STRAWBERRY_CREME_GRANDE = 4.65;
  public final double STRAWBERRY_CREME_VENTI = 4.95;

  public final double MOCHA_CREME_GRANDE = 4.65;
  public final double MOCHA_CREME_VENTI = 4.95;

  public final double DOUBLE_CHOCOLATY_CHIP_CREME_GRANDE = 4.65;
  public final double DOUBLE_CHOCOLATY_CHIP_CREME_VENTI = 4.95;

  private JCheckBox noFrapp, coffee, caramel, mocha, whiteChocolateMocha,
      javaChip, vanillaBeanCreme, strawberryCreme,
      mochaCreme, doubleChocolatyChipCreme;
  JCheckBox[] checkBoxes = {coffee = new JCheckBox("Coffee"),
    caramel = new JCheckBox("Caramel"), mocha = new JCheckBox("Mocha"), whiteChocolateMocha = new JCheckBox("White Chocolate Mocha"),
    javaChip = new JCheckBox("Java Chip"), vanillaBeanCreme = new JCheckBox("Vanilla Bean Créme"),
    strawberryCreme = new JCheckBox("Strawberry Créme"), mochaCreme = new JCheckBox("Mocha Créme"),
    doubleChocolatyChipCreme = new JCheckBox("Double Chocolaty Chip Créme"), noFrapp = new JCheckBox("None")};

  //comboboxes
  private JComboBox<String> cb, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;

  String[] sizes = {"GRANDE 16 OZ", "VENTI 20 OZ"};

  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes), cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes), cb3 = new JComboBox<String>(sizes), cb4 = new JComboBox<String>(sizes),
    cb5 = new JComboBox<String>(sizes), cb6 = new JComboBox<String>(sizes), cb7 = new JComboBox<String>(sizes),
    cb8 = new JComboBox<String>(sizes)};

  /**
   * Constructor
   *
   */
  public FrappuccinoPanel() {

    setLayout(new GridLayout(10, 2));

    //create ActionListener, add comboboxes and checkboxes to it
    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }

    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }

// Add a border around the panel. 
    setBorder(BorderFactory.createTitledBorder("Frappuccinos"));

    for (int i = 0; i < comboBoxes.length; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noFrapp);
  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == coffee) {

        if (coffee.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == caramel) {
        if (caramel.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == mocha) {
        if (mocha.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }
      else if (source == whiteChocolateMocha) {
        if (whiteChocolateMocha.isSelected()) {
          cb3.setVisible(true);
        }
        else {
          cb3.setVisible(false);
        }

      }
      else if (source == javaChip) {
        if (javaChip.isSelected()) {
          cb4.setVisible(true);
        }
        else {
          cb4.setVisible(false);
        }

      }
      else if (source == vanillaBeanCreme) {
        if (vanillaBeanCreme.isSelected()) {
          cb5.setVisible(true);
        }
        else {
          cb5.setVisible(false);
        }

      }
      else if (source == strawberryCreme) {
        if (strawberryCreme.isSelected()) {
          cb6.setVisible(true);
        }
        else {
          cb6.setVisible(false);
        }

      }
      else if (source == mochaCreme) {
        if (mochaCreme.isSelected()) {
          cb7.setVisible(true);
        }
        else {
          cb7.setVisible(false);
        }

      }
      else if (source == doubleChocolatyChipCreme) {
        if (doubleChocolatyChipCreme.isSelected()) {
          cb8.setVisible(true);
        }
        else {
          cb8.setVisible(false);
        }

      }
      if (source == noFrapp) {
        if (noFrapp.isSelected()) {
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

  public double getFrappCost() {
    double frappCost = 0.0;

    if (noFrapp.isSelected()) {
      frappCost += NO_FRAPP;
    }
    if (coffee.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += COFFEE_GRANDE;
    }
    if (coffee.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += COFFEE_VENTI;
    }
    if (caramel.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += CARAMEL_GRANDE;
    }
    if (caramel.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += CARAMEL_VENTI;
    }
    if (mocha.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += MOCHA_GRANDE;
    }
    if (mocha.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += MOCHA_VENTI;
    }
    if (whiteChocolateMocha.isSelected() && cb3.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += WHITE_CHOCOLATE_MOCHA_GRANDE;
    }
    if (whiteChocolateMocha.isSelected() && cb3.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += WHITE_CHOCOLATE_MOCHA_VENTI;
    }
    if (javaChip.isSelected() && cb4.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += JAVA_CHIP_GRANDE;
    }
    if (javaChip.isSelected() && cb4.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += JAVA_CHIP_VENTI;
    }
    if (vanillaBeanCreme.isSelected() && cb5.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += VANILLA_BEAN_CREME_GRANDE;
    }
    if (vanillaBeanCreme.isSelected() && cb5.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += VANILLA_BEAN_CREME_VENTI;
    }
    if (strawberryCreme.isSelected() && cb6.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += STRAWBERRY_CREME_GRANDE;
    }
    if (strawberryCreme.isSelected() && cb6.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += STRAWBERRY_CREME_VENTI;
    }
    if (mochaCreme.isSelected() && cb7.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += MOCHA_CREME_GRANDE;
    }
    if (mochaCreme.isSelected() && cb7.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += MOCHA_CREME_VENTI;
    }
    if (doubleChocolatyChipCreme.isSelected() && cb8.getSelectedItem().toString() == "GRANDE 16 OZ") {
      frappCost += DOUBLE_CHOCOLATY_CHIP_CREME_GRANDE;
    }
    if (doubleChocolatyChipCreme.isSelected() && cb8.getSelectedItem().toString() == "VENTI 20 OZ") {
      frappCost += DOUBLE_CHOCOLATY_CHIP_CREME_VENTI;
    }
    return frappCost;
  }
}
