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

public class ExtrasPanel extends JPanel {

  public final double FLAVOR = 0.50;
  public final double ESPRESSO_SHOT = 0.80;
  public final double SOY_MILK = 0.60;

  //checkboxes
  private JCheckBox flavor, espressoShot, soyMilk;
  JCheckBox[] checkBoxes = {flavor = new JCheckBox("Add Flavor"),
    espressoShot = new JCheckBox("Add Espresso Shot"),
    soyMilk = new JCheckBox("Add Soy Milk")};

  public ExtrasPanel() {

    setLayout(new GridLayout(3, 1));

    setBorder(BorderFactory.createTitledBorder("Extras"));

    for (int i = 0; i < checkBoxes.length; i++) {
      add(checkBoxes[i]);
    }

  }

  public double getExtrasCost() {
    double extrasCost = 0.0;

    if (flavor.isSelected()) {
      extrasCost += FLAVOR;
    }
    if (espressoShot.isSelected()) {
      extrasCost += ESPRESSO_SHOT;
    }
    if (soyMilk.isSelected()) {
      extrasCost += SOY_MILK;
    }
    return extrasCost;
  }
}
