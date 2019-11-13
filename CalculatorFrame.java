import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author CS2334. Modified by: Stephen
 * @version 2018-03-25
 *          <P>
 *          Lab 10
 *          <P>
 *          This class creates a GUI for simple calculator
 *          application
 * 
 */

public class CalculatorFrame extends JFrame
{
    /** Use default UID */
    private static final long serialVersionUID = 1L;

    /** panel for slider */
    JPanel panel0 = new JPanel();
    /** panel for the binary inputs */
    JPanel panel1 = new JPanel(new GridLayout(5,0));
    /** panel for the error message */
    JPanel panel2 = new JPanel();
    /** panel for the calculate result button */
    JPanel panel3 = new JPanel();
    /** panel for the radio buttons */
    JPanel panel4 = new JPanel();

    /** Group of operation buttons */
    ButtonGroup ops = new ButtonGroup();

    /** Calculate result button */
    JButton button = new JButton("Calculate Result");

    /** Text that describes which operator is being used */
    JLabel opSign = new JLabel();
    /** Text that display an equals sign*/
    JLabel equalsSign = new JLabel("=  ");
    /** Text that display an error message */
    JLabel errorMessage = new JLabel();

    /** JSlider for the user's first input */
    JSlider slider = new JSlider(0, 20, 10);
    /** Text field for the user's first input */
    JTextField firstBox = new JTextField(5);
    /** Text field for the user's second input */
    JTextField secondBox = new JTextField(5);
    /** Text field for the computed result */
    JTextField computeResult = new JTextField();

    /** add operation radio button */
    JRadioButton add = new JRadioButton("+");
    /** multiply operation radio button */
    JRadioButton multiply = new JRadioButton("*");
    /** exponentiate operation radio button */
    JRadioButton exponentiate = new JRadioButton("^");
    /** modulus operation radio button */
    JRadioButton modulus = new JRadioButton("%");

    /**
     * This method builds and operates the GUI window.
     * @param title The title of the window.
     */
    public CalculatorFrame(String title) {
        super(title);
        /**************************************************/
        /** Setup Section: You should not change this... **/
        
        // Set Alignment of the JTextField and Jlabel
        firstBox.setHorizontalAlignment(JTextField.RIGHT);
        secondBox.setHorizontalAlignment(JTextField.RIGHT);
        opSign.setHorizontalAlignment(JLabel.RIGHT);
        equalsSign.setHorizontalAlignment(JLabel.RIGHT);
        computeResult.setHorizontalAlignment(JTextField.RIGHT);
        

        // Set the slider display configuration:
        slider.setMinorTickSpacing(1); 
        slider.setMajorTickSpacing(2); 
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        
        Hashtable<Integer, JLabel> labelTable  = new Hashtable<Integer, JLabel>(); 
        labelTable.put(0, new JLabel("0")); 
        labelTable.put(5, new JLabel("5"));
        labelTable.put(10,  new JLabel("10"));
        labelTable.put(15, new JLabel("15"));
        labelTable.put(20, new JLabel("20"));
        slider.setLabelTable(labelTable); 
        slider.setPaintLabels(true);
        
        firstBox.setText("10");

        // Change computeResult to be non-editable
        firstBox.setEditable(false);
        computeResult.setEditable(false);

        // DO NOT CHANGE THE NAMES OR YOU WILL BREAK OUR UNIT TESTING
        errorMessage.setName("errorMessageText");
        firstBox.setName("input1");
        secondBox.setName("input2");
        add.setName("opAdd"); 
        multiply.setName("opMultiply");
        exponentiate.setName("opExponentiate");
        modulus.setName("opModulus");
        computeResult.setName("total");
        button.setName("calculateButton");
        opSign.setName("opSign");

        //sets the layout grid for the GUI of dimension 4*5
        setLayout(new GridLayout(5, 0));
        
        /** End Setup Section: You should not change the code above... **/
        /****************************************************************/

        // add the JComponents in the correct places:
        panel1.add(slider);
        panel1.add(firstBox);
        panel1.add(opSign);
        panel1.add(secondBox); 
        panel1.add(equalsSign);
        panel1.add(computeResult);
        panel2.add(button);
        panel3.add(errorMessage); 
      
        //TODO: add the operations to the lower panel
        panel4.add(add);
        panel4.add(multiply);
        panel4.add(exponentiate);
        panel4.add(modulus);
        //add the operation radio buttons to the button group
        ops.add(add);//REMOVE
        ops.add(multiply);//REMOVE
        ops.add(exponentiate);//REMOVE
        ops.add(modulus);//REMOVE
        
        // TODO: add the panels into the frame
        // Remember that this class is a JFrame, so you should simply call
        // the add method of this object that is being constructed.
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        
        //default to and operator
        add.setSelected(true);
        opSign.setText("+  ");

        /*
         * When a button is pressed it should:
         * (1) change the opSign text to the name of the respective radio Button (+, *, /, ==)
         * (2) clear the computeResult text field
         * (3) clear the errorMessage text field
         * 
         * Note: pressing the button sets it to be selected. Because the buttons are in a button
         * group, when one button is selected all other buttons will be deselected. As such, you
         * should not add any code to explicitly set the buttons to be selected.
         * 
         * ActionListeners wait for the program to send them an event. In this case, an event
         * occurs when we press a button. Once that event happens, the code inside the actionPerformed
         * method is executed. Thus, we are coding here what the program should do when a button is
         * pressed. We add action listners to each of the radio buttons.
         * 
         * The action listener completes the 3 above tasks
         */
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// TODO: change the opSign, clear the error message and compute result.
            	opSign.setText("+  ");
            	computeResult.setText("");
            	errorMessage.setText("");
            } 
        });
        
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// TODO: change the opSign, clear the error message and compute result.
            	opSign.setText("*  ");
            	computeResult.setText("");
            	errorMessage.setText("");
            	
            }
        });
        
        // TODO: implement the actionlisteners for the divide and equality buttons the same way:
        modulus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// TODO: change the opSign, clear the error message and compute result.
            	opSign.setText("%  ");
            	computeResult.setText("");
            	errorMessage.setText("");
            }
        });
        exponentiate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// TODO: change the opSign, clear the error message and compute result.
            	opSign.setText("^  ");
            	computeResult.setText("");
            	errorMessage.setText("");
            	
            }
        });
        /*
         * Set the Change Listener for the Slider. When a change
         * occurs, the text in firstBox should be set to the slider value.
         * 
         * The text in the computeResult and errorMessage should also be cleared.
         * 
         * ChangeListener is a type of listener like ActionListener. Events are
         * sent to it when the slider is changed. The method called is stateChanged
         * instead of actionPerformed for this listener.
         */
        slider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		// TODO: change the text in the first JTextField. Clear error and result
        		Integer sliderVal = slider.getValue();
        		String text = String.valueOf(sliderVal);
        		firstBox.setText(text);
        		errorMessage.setText("");
        		computeResult.setText("");
            }
        });

        /*
         * When the Calculate Result Button is pressed, 
         * get the values from the text fields and calculate the 
         * appropriate result using the four different operators (+, *, /, ==).
         * 
         * You need to check which operation (button) is selected to decide what to do.
         * You may need to look at the JRadioButton API to determine how best to do this.
         * 
         * (1) + operation: add the integer values from firstBox and secondBox.
         * 					Set computeResult to the result.
         * (2) - operation: subtract the integer value of secondBox from firstBox.
         * 					Set computeResult to the result.
         * (3) / operation: divide the integer value of firstBox by secondBox.
         * 					Set computeResult to the result.
         * (4) == operation: if the integer value of firstBox == secondBox, set computeResult to
         * 					 the string "True". Else, set computeResult to the string "False".
         * 
         * You should reset errorMessage when the computation succeeds.
         * You should reset computeResult when you encounter an error.
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                    /*
                     * TODO: determine which radio button is selected (add, multiply,
                     * divide, equality).
                     * 
                     * Once you know which operation to perform, get the integer values from the
                     * text of the two input boxes (firstBox and secondBox).
                     * 
                     * Finally, perform the operation on the integers and write out the result as
                     * a String to the computeResult text field.
                     */
            		//System.out.println(opSign.getIcon());//KEEPS PRINTING NULL
            		//System.out.println(add.getIcon());//KEEPS PRINTING NULL
            		//System.out.println(add.getText());
            		int a = Integer.parseInt(firstBox.getText()); 
                	int b =	Integer.parseInt(secondBox.getText());
                	int result = 0;
                	//System.out.println(opSign.getText());
                	//System.out.println(add.getText() + "  ");
            		if (opSign.getText() == "+  ") {
                    	//System.out.println("+");
            			result = a + b;
            			computeResult.setText(String.valueOf(result));
                    }else if(opSign.getText() == "*  ") {
                    	//System.out.println("*");
                    	result = a * b; 
                    	computeResult.setText(String.valueOf(result));
                    }else if(opSign.getText() == "%  ") {
                    	//System.out.println("%");
                    	result = a % b; 
                    	computeResult.setText(String.valueOf(result));
                    }else if(opSign.getText() == "^  ") {
                    	//System.out.println("^");
                    	result = (int) Math.pow(a,b);
                    	computeResult.setText(String.valueOf(result));
                    }
                    
                    // Clear the error message text field:
                    errorMessage.setText("");
                }
                // Check for errors:
                // (1) A number entered is not an integer -> NumberFormatException
                // (2) Divide by zero -> ArithmeticException
                catch (NumberFormatException error) {
                	// TODO: display the error message "ERROR: Please enter a valid integer."
                    // in the error message text field.
                	errorMessage.setText("ERROR: Please enter a valid integer.");
                	// TODO: Clear computeResult
                	computeResult.setText("");
                }
                catch (ArithmeticException error) {
                	// TODO: display the error message "ERROR: Tried to divide by 0."
                    // in the error message text field.
                	errorMessage.setText("ERROR: Tried to divide by 0.");
                	// TODO: Clear computeResult
                	computeResult.setText("");
                }
            }
        });


        // Configuring of the frame
        setSize(400, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Used to create the Calculator Frame
     * @param args
     * command-line arguments - not used
     */
    public static void main(String[] args) {
        new CalculatorFrame("Calculator Window");
    }
}
