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

public class ColdCoffeesPanel extends JPanel {

  public final double NO_COLD_COFFEE = 0.00;

  public final double ICED_CAFFE_LATTE_GRANDE = 4.65;
  public final double ICED_CAFFE_LATTE_VENTI = 4.95;

  public final double ICED_CAFFE_AMERICANO_GRANDE = 2.65;
  public final double ICED_CAFFE_AMERICANO_VENTI = 3.15;

  public final double ICED_CARAMEL_MACCHIATO_GRANDE = 4.65;
  public final double ICED_CARAMEL_MACCHIATO_VENTI = 4.95;

  public final double ICED_FLAVOR_LATTE_GRANDE = 4.45;
  public final double ICED_FLAVOR_LATTE_VENTI = 4.95;

  public final double ICED_COFFEE_GRANDE = 2.65;
  public final double ICED_COFFEE_VENTI = 2.95;

  public final double ICED_COFFEE_WITH_MILK_GRANDE = 2.65;
  public final double ICED_COFFEE_WITH_MILK_VENTI = 2.95;

  //checkboxes
  private JCheckBox noColdCoffee, icedCaffeLatte, icedCaffeAmericano,
      icedCaramelMacchiato, icedFalvorLatte, icedCoffee, icedCoffeWithMilk;
  JCheckBox[] checkBoxes = {icedCaffeLatte = new JCheckBox("Iced Caffé Latte"),
    icedCaffeAmericano = new JCheckBox("Iced Caffé Americano"),
    icedCaramelMacchiato = new JCheckBox("Iced Caramel Macchiato"),
    icedFalvorLatte = new JCheckBox("Iced Flavor Latte"),
    icedCoffee = new JCheckBox("Iced Coffee"),
    icedCoffeWithMilk = new JCheckBox("Iced Coffee With Milk"),
    noColdCoffee = new JCheckBox("None")};

  //comboboxes
  private JComboBox<String> cb, cb1, cb2, cb3, cb4, cb5;

  String[] sizes = {"GRANDE 16 OZ", "VENTI 20 OZ"};
  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes),
    cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes), cb3 = new JComboBox<String>(sizes),
    cb4 = new JComboBox<String>(sizes), cb5 = new JComboBox<String>(sizes)};

  public ColdCoffeesPanel() {

    setLayout(new GridLayout(7, 2));
    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }
    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }
// Create the check boxes. 

// Add a border around the panel. 
    setBorder(BorderFactory.createTitledBorder("Cold Coffee"));

    for (int i = 0; i < comboBoxes.length; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noColdCoffee);
  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == icedCaffeLatte) {

        if (icedCaffeLatte.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == icedCaffeAmericano) {
        if (icedCaffeAmericano.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == icedCaramelMacchiato) {
        if (icedCaramelMacchiato.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }
      else if (source == icedFalvorLatte) {
        if (icedFalvorLatte.isSelected()) {
          cb3.setVisible(true);
        }
        else {
          cb3.setVisible(false);
        }

      }
      else if (source == icedCoffee) {
        if (icedCoffee.isSelected()) {
          cb4.setVisible(true);
        }
        else {
          cb4.setVisible(false);
        }

      }
      else if (source == icedCoffeWithMilk) {
        if (icedCoffeWithMilk.isSelected()) {
          cb5.setVisible(true);
        }
        else {
          cb5.setVisible(false);
        }

      }
      if (source == noColdCoffee) {
        if (noColdCoffee.isSelected()) {
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

  public double getColdCoffeeCost() {
    double coldCoffeeCost = 0.0;

    if (noColdCoffee.isSelected()) {
      coldCoffeeCost += NO_COLD_COFFEE;
    }

    if (icedCaffeLatte.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldCoffeeCost += ICED_CAFFE_LATTE_GRANDE;
    }
    if (icedCaffeLatte.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldCoffeeCost += ICED_CAFFE_LATTE_VENTI;
    }

    if (icedCaffeAmericano.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldCoffeeCost += ICED_CAFFE_AMERICANO_GRANDE;
    }
    if (icedCaffeAmericano.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldCoffeeCost += ICED_CAFFE_AMERICANO_VENTI;
    }

    if (icedCaramelMacchiato.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldCoffeeCost += ICED_CARAMEL_MACCHIATO_GRANDE;
    }
    if (icedCaramelMacchiato.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldCoffeeCost += ICED_CARAMEL_MACCHIATO_VENTI;
    }

    if (icedFalvorLatte.isSelected() && cb3.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldCoffeeCost += ICED_FLAVOR_LATTE_GRANDE;
    }
    if (icedFalvorLatte.isSelected() && cb3.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldCoffeeCost += ICED_FLAVOR_LATTE_VENTI;
    }

    if (icedCoffee.isSelected() && cb4.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldCoffeeCost += ICED_COFFEE_GRANDE;
    }
    if (icedCoffee.isSelected() && cb4.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldCoffeeCost += ICED_COFFEE_VENTI;
    }

    if (icedCoffeWithMilk.isSelected() && cb5.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coldCoffeeCost += ICED_COFFEE_WITH_MILK_GRANDE;
    }
    if (icedCoffeWithMilk.isSelected() && cb5.getSelectedItem().toString() == "VENTI 20 OZ") {
      coldCoffeeCost += ICED_COFFEE_WITH_MILK_VENTI;
    }

    return coldCoffeeCost;
  }
}
