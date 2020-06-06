package calculatorgui;

/**
 *
 * @author ryanm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeePanel extends JPanel {


  public final double NO_COFFEE = 0.0;

  public final double BREWED_COFFEE_TALL = 1.85;
  public final double BREWED_COFFEE_VENTI = 2.10;
  public final double BREWED_COFFEE_GRANDE = 2.45;

  public final double CAFFE_LATTE_TALL = 3.15;
  public final double CAFFE_LATTE_VENTI = 3.75;
  public final double CAFFE_LATTE_GRANDE = 4.15;

  public final double CAFFE_MOCHA_TALL = 3.65;
  public final double CAFFE_MOCHA_VENTI = 4.25;
  public final double CAFFE_MOCHA_GRANDE = 4.65;

  public final double CAPPUCCINO_TALL = 3.15;
  public final double CAPPUCCINO_VENTI = 3.75;
  public final double CAPPUCCINO_GRANDE = 4.15;

  public final double CARAMEL_MACCHIATO_TALL = 3.75;
  public final double CARAMEL_MACCHIATO_VENTI = 4.45;
  public final double CARAMEL_MACCHIATO_GRANDE = 4.75;

  public final double VANILLA_LATTE_TALL = 3.65;
  public final double VANILLA_LATTE_VENTI = 4.25;
  public final double VANILLA_LATTE_GRANDE = 4.65;

  public final double WHITE_CHOCOLATE_MOCHA_TALL = 3.75;
  public final double WHITE_CHOCOLATE_MOCHA_VENTI = 4.45;
  public final double WHITE_CHOCOLATE_MOCHA_GRANDE = 4.75;

  public final double CAFFE_AMERICANO_TALL = 2.25;
  public final double CAFFE_AMERICANO_VENTI = 2.75;
  public final double CAFFE_AMERICANO_GRANDE = 3.25;
  
  //checkboxes
  private JCheckBox noCoffee, brewedCoffee, caffeLatte, caffeMocha, cappuccino,
      caramelMacchiato, vanillaLatte, whiteChocolateMocha,
      caffeAmericano;
  JCheckBox[] checkBoxes = {brewedCoffee = new JCheckBox("Brewed Coffee"),
    caffeLatte = new JCheckBox("Caffé Latte"), caffeMocha = new JCheckBox("Caffé Mocha"), cappuccino = new JCheckBox("Cappuccino"),
    caramelMacchiato = new JCheckBox("Caramel Macchiato"), vanillaLatte = new JCheckBox("Vanilla Latte"),
    whiteChocolateMocha = new JCheckBox("White Chocolate Mocha"), caffeAmericano = new JCheckBox("Caffé Americano"),
    noCoffee = new JCheckBox("None")};
  
  
  //comboboxes
  private JComboBox<String> cb, cb1, cb2, cb3, cb4, cb5, cb6, cb7;

  String[] sizes = {"TALL 12 OZ", "GRANDE 16 OZ", "VENTI 20 OZ"};
  JComboBox[] comboBoxes = {cb = new JComboBox<String>(sizes), cb1 = new JComboBox<String>(sizes),
    cb2 = new JComboBox<String>(sizes), cb3 = new JComboBox<String>(sizes), cb4 = new JComboBox<String>(sizes),
    cb5 = new JComboBox<String>(sizes), cb6 = new JComboBox<String>(sizes), cb7 = new JComboBox<String>(sizes)};

  /**
   * Constructor
   */
  public CoffeePanel() {

    setLayout(new GridLayout(8, 2));
   

    //create ActionListener, add comboboxes and checkboxes to it
    ActionListener actionListener = new ActionHandler();
    for (JCheckBox checkBoxe : checkBoxes) {
      checkBoxe.addActionListener(actionListener);
    }

    for (int i = 0; i < comboBoxes.length; i++) {
      comboBoxes[i].addActionListener(actionListener);
    }

// Add a border around the panel. 
    setBorder(BorderFactory.createTitledBorder("Hot Coffee"));

    for (int i = 0; i < comboBoxes.length-1; i++) {
      add(checkBoxes[i]);
      add(comboBoxes[i]);
      comboBoxes[i].setVisible(false);
    }
    add(noCoffee);
  }

  class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      if (source == brewedCoffee) {

        if (brewedCoffee.isSelected()) {
          cb.setVisible(true);
        }
        else {
          cb.setVisible(false);
        }
      }
      else if (source == caffeLatte) {
        if (caffeLatte.isSelected()) {
          cb1.setVisible(true);
        }
        else {
          cb1.setVisible(false);
        }
      }
      else if (source == caffeMocha) {
        if (caffeMocha.isSelected()) {
          cb2.setVisible(true);
        }
        else {
          cb2.setVisible(false);
        }

      }
      else if (source == cappuccino) {
        if (cappuccino.isSelected()) {
          cb3.setVisible(true);
        }
        else {
          cb3.setVisible(false);
        }

      }
      else if (source == caramelMacchiato) {
        if (caramelMacchiato.isSelected()) {
          cb4.setVisible(true);
        }
        else {
          cb4.setVisible(false);
        }

      }
      else if (source == vanillaLatte) {
        if (vanillaLatte.isSelected()) {
          cb5.setVisible(true);
        }
        else {
          cb5.setVisible(false);
        }

      }
      else if (source == whiteChocolateMocha) {
        if (whiteChocolateMocha.isSelected()) {
          cb6.setVisible(true);
        }
        else {
          cb6.setVisible(false);
        }

      }
      else if (source == caffeAmericano) {
        if (caffeAmericano.isSelected()) {
          cb7.setVisible(true);
        }
        else {
          cb7.setVisible(false);
        }

      }
      if (source == noCoffee) {
        if (noCoffee.isSelected()) {
          for (int i = 0; i < comboBoxes.length; i++) {
            checkBoxes[i].setSelected(false);
            checkBoxes[i].setEnabled(false);
            comboBoxes[i].setVisible(false);
          }
        }
        else{
          for (int i = 0; i < comboBoxes.length; i++) {
            checkBoxes[i].setEnabled(true);
          }
        }
      }
    }
  }

  /**
   * getCoffeeCost method
   *
   * @return The cost of the selected coffee.
   */
  public double getCoffeeCost() {
    double coffeeCost = 0.0;
    if (noCoffee.isSelected()) {
      coffeeCost += NO_COFFEE;
    }
    if (brewedCoffee.isSelected() && cb.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += BREWED_COFFEE_TALL;
    }
    if (brewedCoffee.isSelected() && cb.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += BREWED_COFFEE_GRANDE;
    }
    if (brewedCoffee.isSelected() && cb.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += BREWED_COFFEE_VENTI;
    }
    if (caffeLatte.isSelected() && cb1.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += CAFFE_LATTE_TALL;
    }
    if (caffeLatte.isSelected() && cb1.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += CAFFE_LATTE_GRANDE;
    }
    if (caffeLatte.isSelected() && cb1.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += CAFFE_LATTE_VENTI;
    }
    if (caffeMocha.isSelected() && cb2.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += CAFFE_MOCHA_TALL;
    }
    if (caffeMocha.isSelected() && cb2.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += CAFFE_MOCHA_GRANDE;
    }
    if (caffeMocha.isSelected() && cb2.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += CAFFE_MOCHA_VENTI;
    }
    if (cappuccino.isSelected() && cb3.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += CAPPUCCINO_TALL;
    }
    if (cappuccino.isSelected() && cb3.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += CAPPUCCINO_GRANDE;
    }
    if (cappuccino.isSelected() && cb3.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += CAPPUCCINO_VENTI;
    }
    if (caramelMacchiato.isSelected() && cb4.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += CARAMEL_MACCHIATO_TALL;
    }
    if (caramelMacchiato.isSelected() && cb4.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += CARAMEL_MACCHIATO_GRANDE;
    }
    if (caramelMacchiato.isSelected() && cb4.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += CARAMEL_MACCHIATO_VENTI;
    }
    if (vanillaLatte.isSelected() && cb5.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += VANILLA_LATTE_TALL;
    }
    if (vanillaLatte.isSelected() && cb5.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += VANILLA_LATTE_GRANDE;
    }
    if (vanillaLatte.isSelected() && cb5.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += VANILLA_LATTE_VENTI;
    }
    if (whiteChocolateMocha.isSelected() && cb6.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += WHITE_CHOCOLATE_MOCHA_TALL;
    }
    if (whiteChocolateMocha.isSelected() && cb6.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += WHITE_CHOCOLATE_MOCHA_GRANDE;
    }
    if (whiteChocolateMocha.isSelected() && cb6.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += WHITE_CHOCOLATE_MOCHA_VENTI;
    }
    if (caffeAmericano.isSelected() && cb7.getSelectedItem().toString() == "TALL 12 OZ") {
      coffeeCost += CAFFE_AMERICANO_TALL;
    }
    if (caffeAmericano.isSelected() && cb7.getSelectedItem().toString() == "GRANDE 16 OZ") {
      coffeeCost += CAFFE_AMERICANO_GRANDE;
    }
    if (caffeAmericano.isSelected() && cb7.getSelectedItem().toString() == "VENTI 20 OZ") {
      coffeeCost += CAFFE_AMERICANO_VENTI;
    }
    return coffeeCost;
  }
}