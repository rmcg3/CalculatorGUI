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


public class GreetingPanel extends JPanel {

  private JLabel greeting; //to display a greeting

  public GreetingPanel() {
    // Create the label. 
    greeting = new JLabel("Starbucks Drinks");
    
// Add the label to this panel. 
    add(greeting);
    add(new JLabel(new ImageIcon("C:\\Users\\ryanm\\Documents\\NetBeansProjects\\CalculatorGUI\\src\\calculatorgui\\logo.jpg")));
  }
}
