package calculatorgui;

/**
 *
 * @author ryanm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Order calculator GUI for Starbucks drink menu.
 */
public class CalculatorGUI extends JFrame {

  private FrappuccinoPanel frapps;     // Frappuccinos panel
  private HotDrinkPanel hotDrinks; // Topping panel     
  private CoffeePanel coffee;    // Coffee panel     
  private GreetingPanel banner;  // To display a greeting 
  private ColdTeasPanel coldTeas; //Cold Teas Panel
  private HotTeasPanel hotTeas;  //Hot Teas Panel
  private ExpressoPanel expressos; //Expressos Panel
  private ColdCoffeesPanel coldCoffees; //Cold Coffees Panel
  private ExtrasPanel extras;    //Extras Panel
  private JPanel buttonPanel;    // To hold the buttons  
  private JButton calcButton;    // To calculate the cost  
  private JButton exitButton;    // To exit the application    
  private final double TAX_RATE = 0.06; // Sales tax rate

  /**
   *
   * Constructor
   */
  public CalculatorGUI() {

    //Display a title
    setTitle("Starbucks Drink Order Calculator");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Create the custom panels.
    banner = new GreetingPanel();
    frapps = new FrappuccinoPanel();
    hotDrinks = new HotDrinkPanel();
    coffee = new CoffeePanel();
    coldTeas = new ColdTeasPanel();
    hotTeas = new HotTeasPanel();
    expressos = new ExpressoPanel();
    coldCoffees = new ColdCoffeesPanel();
    extras = new ExtrasPanel();

    //Set layout to a new 4x3 GridLayout
    setLayout(new GridLayout(4,3));

    // Add the components to the content pane.
    add(banner, BorderLayout.NORTH);
    add(frapps);
    add(hotDrinks);
    add(coffee); 
    add(coldTeas);
    add(hotTeas);
    add(expressos);
    add(coldCoffees);
    add(extras);

    // Create and add the button panel. 
    buildButtonPanel();
    add(buttonPanel);
    
    // Pack the contents of the window and display it.
    pack();
    setVisible(true);

  }

  private void buildButtonPanel() {

    // Create a panel for the buttons.
    buttonPanel = new JPanel();

    // Create the buttons. 
    calcButton = new JButton("Calculate");
    exitButton = new JButton("Exit");

    // Register the action listeners. 
    calcButton.addActionListener(new CalcButtonListener());
    exitButton.addActionListener(new ExitButtonListener());

    // Add the buttons to the button panel.
    buttonPanel.add(calcButton);
    buttonPanel.add(exitButton);
  }

  private class CalcButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      
      // Variables to hold the subtotal, tax, and total     
      double subtotal, tax, total;
      
      // Calculate the subtotal.
      subtotal = frapps.getFrappCost()
          + hotDrinks.getHotDrinkCost()
          + coldTeas.getColdTeaCost()
          + hotTeas.getHotTeaCost()
          + expressos.getExpressoCost()
          + coldCoffees.getColdCoffeeCost()
          + extras.getExtrasCost()
          + coffee.getCoffeeCost();
      
      //Calculate the sales tax.
      tax = subtotal * TAX_RATE;
      
      // Calculate the total.
      total = subtotal + tax;
      
      // Display the charges.
      JOptionPane.showMessageDialog(null,
          String.format("Subtotal: $%,.2f\n"
              + "Tax: $%,.2f\n"
              + "Total: $%,.2f", subtotal, tax, total),"Amount Due",
              JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private class ExitButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    new CalculatorGUI();
  }
}
