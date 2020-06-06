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

public class HotDrinkPanel extends JPanel {
  // The following constants are used to indicate
  // the cost of toppings. 

  public final double NO_HOT_DRINK = 0.00;

  public final double HOT_CHOCOLATE_TALL = 2.75;
  public final double HOT_CHOCOLATE_GRANDE = 3.25;
  public final double HOT_CHOCOLATE_VENTI = 3.45;

  public final double WHITE_HOT_CHOCOLATE_TALL = 3.25;
  public final double WHITE_HOT_CHOCOLATE_GRANDE = 3.75;
  public final double WHITE_HOT_CHOCOLATE_VENTI = 3.95;

  public final double STEAMER_TALL = 2.75;
  public final double STEAMER_GRANDE = 3.25;
  public final double STEAMER_VENTI = 3.45;

  //checkboxes
  private JCheckBox noHotDrink, hotChocolate, whiteHotChocolate, steamer;
  JCheckBox[] checkBoxes = {hotChocolate = new JCheckBox("Hot Chocolate"),
    whiteHotChocolate = new JCheckBox("White Hot Chocolate"), steamer = new JCheckBox("STEAMER"),
    noHotDrink = new JCheckBox("None")};

  //comboboxes
  private JComboBox<String> cb, cb1, cb2;

  String[] sizes = {"TALL 12 OZ", "GRANDE 16 OZ", "VENTI 20 OZ"};
  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes), cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes)};

  /**
   * Constructor
   */
  public HotDrinkPanel() {
    // Create a GridLayout manager with 
    // four rows and one column. 
    setLayout(new GridLayout(4, 2));

    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }
    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }
// Create the check boxes. 

// Add a border around the panel. 
    setBorder(BorderFactory.createTitledBorder("Hot Drinks"));

    for (int i = 0; i < comboBoxes.length; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noHotDrink);

  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == hotChocolate) {

        if (hotChocolate.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == whiteHotChocolate) {
        if (whiteHotChocolate.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == steamer) {
        if (steamer.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }
      if (source == noHotDrink) {
        if (noHotDrink.isSelected()) {
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

// Add the check boxes to the panel. 
  /**
   * getToppingCost method
   *
   * @return The cost of the selected toppings.
   */
  public double getHotDrinkCost() {
    double hotDrinkCost = 0.0;

    if (noHotDrink.isSelected()) {
      hotDrinkCost += NO_HOT_DRINK;
    }
    if (hotChocolate.isSelected() && cb.getSelectedItem().toString() == "TALL 12 OZ") {
      hotDrinkCost += HOT_CHOCOLATE_TALL;
    }
    if (hotChocolate.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotDrinkCost += HOT_CHOCOLATE_GRANDE;
    }
    if (hotChocolate.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotDrinkCost += HOT_CHOCOLATE_VENTI;
    }

    if (whiteHotChocolate.isSelected() && cb1.getSelectedItem().toString() == "TALL 12 OZ") {
      hotDrinkCost += WHITE_HOT_CHOCOLATE_TALL;
    }
    if (whiteHotChocolate.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotDrinkCost += WHITE_HOT_CHOCOLATE_GRANDE;
    }
    if (whiteHotChocolate.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotDrinkCost += WHITE_HOT_CHOCOLATE_VENTI;
    }

    if (steamer.isSelected() && cb2.getSelectedItem().toString() == "TALL 12 OZ") {
      hotDrinkCost += STEAMER_TALL;
    }
    if (steamer.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      hotDrinkCost += STEAMER_GRANDE;
    }
    if (steamer.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      hotDrinkCost += STEAMER_VENTI;
    }

    return hotDrinkCost;

  }
}
