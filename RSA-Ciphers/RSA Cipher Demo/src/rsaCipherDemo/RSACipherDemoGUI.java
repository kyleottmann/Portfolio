/******************************************
*RSA Mathematics Demonstration Program
*@author Kyle Ottmann & Cole Polychronis
*Date: December 1, 2015
*
*Westminster College
*Discrete Mathematics 210
*Final Project
******************************************/

package rsaCipherDemo;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class RSACipherDemoGUI extends JDialog {
	public static JTextField primeNumber1TextField;
	public static JTextField primeNumber2TextField;
	public static int prime1;
	public static int prime2;
	public JTextPane txtpnNtextpane;
	public JTextPane txtpnTotienttextpane;
	public JTextPane txtpnEquationtextpane;
	public JTextPane txtpnEtextpane;
	public JTextPane txtpnDtextpane;
	public JTextPane txtpnEncryptiontextpane;
	public JTextPane txtpnDecryptiontextpane;
	public JTextPane txtpnMessagetextpane;
	public static int n;
	public static int tot;
	public static int e;
	public static String equation;
	public static int d;
	public static double enc;
	public static double dec;
	public static int m;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RSACipherDemoGUI dialog = new RSACipherDemoGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RSACipherDemoGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RSACipherDemoGUI.class.getResource("/rsaCipherDemo/duck.png")));
		setTitle("RSA Cipher Mathematics Demo by Cole Polychronis & Kyle Ottmann");
		setBounds(100, 100, 750, 600);
		getContentPane().setLayout(new BorderLayout());
				
		JLabel lblTitle = new JLabel("RSA Cipher Mathematics");
		lblTitle.setBorder(new EmptyBorder(15, 0, 15, 0));
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle, BorderLayout.NORTH);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(leftPanel, BorderLayout.WEST);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{50, 0};
		gbl_leftPanel.rowHeights = new int[]{87, 87, 87, 87, 87, 87, 0};
		gbl_leftPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		JLabel lblPrimeNumber1 = new JLabel("Prime Number 1:");
		lblPrimeNumber1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimeNumber1.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblPrimeNumber1 = new GridBagConstraints();
		gbc_lblPrimeNumber1.fill = GridBagConstraints.BOTH;
		gbc_lblPrimeNumber1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrimeNumber1.gridx = 0;
		gbc_lblPrimeNumber1.gridy = 0;
		leftPanel.add(lblPrimeNumber1, gbc_lblPrimeNumber1);
		
		primeNumber1TextField = new JTextField();
		primeNumber1TextField.setHorizontalAlignment(SwingConstants.CENTER);
		primeNumber1TextField.setMinimumSize(new Dimension(50, 50));
		primeNumber1TextField.setMaximumSize(new Dimension(100, 100));
		primeNumber1TextField.setPreferredSize(new Dimension(50, 50));
		primeNumber1TextField.setSize(new Dimension(50, 50));
		primeNumber1TextField.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		primeNumber1TextField.setName("Prime Number 1");
		primeNumber1TextField.setToolTipText("Please enter a prime number");
		GridBagConstraints gbc_primeNumber1TextField = new GridBagConstraints();
		gbc_primeNumber1TextField.anchor = GridBagConstraints.WEST;
		gbc_primeNumber1TextField.fill = GridBagConstraints.VERTICAL;
		gbc_primeNumber1TextField.insets = new Insets(0, 0, 5, 0);
		gbc_primeNumber1TextField.gridx = 0;
		gbc_primeNumber1TextField.gridy = 1;
		leftPanel.add(primeNumber1TextField, gbc_primeNumber1TextField);
		primeNumber1TextField.setColumns(4);
		
		JLabel lblPrimeNumber2 = new JLabel("Prime Number 2:");
		lblPrimeNumber2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrimeNumber2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimeNumber2.setToolTipText("Please enter a prime number");
		GridBagConstraints gbc_lblPrimeNumber2 = new GridBagConstraints();
		gbc_lblPrimeNumber2.fill = GridBagConstraints.BOTH;
		gbc_lblPrimeNumber2.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrimeNumber2.gridx = 0;
		gbc_lblPrimeNumber2.gridy = 2;
		leftPanel.add(lblPrimeNumber2, gbc_lblPrimeNumber2);
		
		primeNumber2TextField = new JTextField();
		primeNumber2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		primeNumber2TextField.setMinimumSize(new Dimension(50, 50));
		primeNumber2TextField.setMaximumSize(new Dimension(100, 100));
		primeNumber2TextField.setPreferredSize(new Dimension(50, 50));
		primeNumber2TextField.setSize(new Dimension(50, 50));
		primeNumber2TextField.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		primeNumber2TextField.setToolTipText("Please enter a prime number");
		primeNumber2TextField.setName("Prime Number 1");
		primeNumber2TextField.setColumns(4);
		GridBagConstraints gbc_primeNumber2TextField = new GridBagConstraints();
		gbc_primeNumber2TextField.anchor = GridBagConstraints.WEST;
		gbc_primeNumber2TextField.fill = GridBagConstraints.VERTICAL;
		gbc_primeNumber2TextField.insets = new Insets(0, 0, 5, 0);
		gbc_primeNumber2TextField.gridx = 0;
		gbc_primeNumber2TextField.gridy = 3;
		leftPanel.add(primeNumber2TextField, gbc_primeNumber2TextField);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.anchor = GridBagConstraints.WEST;
		gbc_verticalStrut.fill = GridBagConstraints.VERTICAL;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 4;
		leftPanel.add(verticalStrut, gbc_verticalStrut);
		
		JButton btnCalculatebtn = new JButton("Calculate");
		btnCalculatebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent calc) {
				prime1 = Integer.parseInt(primeNumber1TextField.getText());
				prime2 = Integer.parseInt(primeNumber2TextField.getText());
				CalculateRSA();
				txtpnNtextpane.setText(Integer.toString(n));
				txtpnTotienttextpane.setText(Integer.toString(tot));
				txtpnEquationtextpane.setText(equation);
				txtpnEtextpane.setText(Integer.toString(e));
				txtpnDtextpane.setText(Integer.toString(d));
				txtpnMessagetextpane.setText(Integer.toString(m));
				txtpnEncryptiontextpane.setText(Double.toString(enc));
				txtpnDecryptiontextpane.setText(Double.toString(dec));
			}
		});
		GridBagConstraints gbc_btnCalculatebtn = new GridBagConstraints();
		gbc_btnCalculatebtn.fill = GridBagConstraints.BOTH;
		gbc_btnCalculatebtn.gridx = 0;
		gbc_btnCalculatebtn.gridy = 5;
		leftPanel.add(btnCalculatebtn, gbc_btnCalculatebtn);
		
		JPanel rightPanel = new JPanel();
		getContentPane().add(rightPanel, BorderLayout.CENTER);
		rightPanel.setLayout(new GridLayout(9, 2, 15, 15));
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		rightPanel.add(verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		rightPanel.add(verticalStrut_2);
		
		JLabel lblNlabel = new JLabel("N:");
		lblNlabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblNlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNlabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNlabel.setVerticalAlignment(SwingConstants.TOP);
		rightPanel.add(lblNlabel);
		
		txtpnNtextpane = new JTextPane();
		txtpnNtextpane.setSize(new Dimension(10, 10));
		txtpnNtextpane.setEditable(false);
		txtpnNtextpane.setOpaque(false);
		txtpnNtextpane.setText(" ");
		rightPanel.add(txtpnNtextpane);
		
		JLabel lblTotientlabel = new JLabel("Totient:");
		lblTotientlabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblTotientlabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTotientlabel.setVerticalAlignment(SwingConstants.TOP);
		lblTotientlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblTotientlabel);
		
		txtpnTotienttextpane = new JTextPane();
		txtpnTotienttextpane.setEditable(false);
		txtpnTotienttextpane.setOpaque(false);
		txtpnTotienttextpane.setText(" ");
		rightPanel.add(txtpnTotienttextpane);
		
		JLabel lblEquationlabel = new JLabel("Equation:");
		lblEquationlabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblEquationlabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblEquationlabel.setVerticalAlignment(SwingConstants.TOP);
		lblEquationlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblEquationlabel);
		
		txtpnEquationtextpane = new JTextPane();
		txtpnEquationtextpane.setEditable(false);
		txtpnEquationtextpane.setOpaque(false);
		txtpnEquationtextpane.setText(" ");
		rightPanel.add(txtpnEquationtextpane);
		
		JLabel lblElabel = new JLabel("E:");
		lblElabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblElabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblElabel.setVerticalAlignment(SwingConstants.TOP);
		lblElabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblElabel);
		
		txtpnEtextpane = new JTextPane();
		txtpnEtextpane.setEditable(false);
		txtpnEtextpane.setOpaque(false);
		txtpnEtextpane.setText(" ");
		rightPanel.add(txtpnEtextpane);
		
		JLabel lblDlabel = new JLabel("D:");
		lblDlabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblDlabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDlabel.setVerticalAlignment(SwingConstants.TOP);
		lblDlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblDlabel);
		
		txtpnDtextpane = new JTextPane();
		txtpnDtextpane.setEditable(false);
		txtpnDtextpane.setOpaque(false);
		txtpnDtextpane.setText(" ");
		rightPanel.add(txtpnDtextpane);
		
		JLabel lblMessagelabel = new JLabel("Message:");
		lblMessagelabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblMessagelabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMessagelabel.setVerticalAlignment(SwingConstants.TOP);
		lblMessagelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblMessagelabel);
		
		txtpnMessagetextpane = new JTextPane();
		txtpnMessagetextpane.setEditable(false);
		txtpnMessagetextpane.setOpaque(false);
		txtpnMessagetextpane.setText(" ");
		rightPanel.add(txtpnMessagetextpane);
		
		JLabel lblEncryptionlabel = new JLabel("Encrypted Message:");
		lblEncryptionlabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblEncryptionlabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblEncryptionlabel.setVerticalAlignment(SwingConstants.TOP);
		lblEncryptionlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblEncryptionlabel);
		
		txtpnEncryptiontextpane = new JTextPane();
		txtpnEncryptiontextpane.setEditable(false);
		txtpnEncryptiontextpane.setOpaque(false);
		txtpnEncryptiontextpane.setText(" ");
		rightPanel.add(txtpnEncryptiontextpane);
		
		JLabel lblDecryptionlabel = new JLabel("Decrypted Message:");
		lblDecryptionlabel.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblDecryptionlabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDecryptionlabel.setVerticalAlignment(SwingConstants.TOP);
		lblDecryptionlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblDecryptionlabel);
		
		txtpnDecryptiontextpane = new JTextPane();
		txtpnDecryptiontextpane.setEditable(false);
		txtpnDecryptiontextpane.setOpaque(false);
		txtpnDecryptiontextpane.setText(" ");
		rightPanel.add(txtpnDecryptiontextpane);
		
	
	}
public static void CalculateRSA(){
	
		//Get N
	 	n = (prime1 * prime2);
	
	
		//Create totient
		tot = ((prime1 - 1) * (prime2 - 1));
		
		//Determine Public Key e
		e = 3;
		
		while ((tot % e) == 0) {
			e++;
		}
		
		//Build Equation
		equation = (e + " * d(mod " + tot + ") = 1");
		
		//Get private key d
		int[] ans = new int[3];
		ans = ExtendedEuclid(e, tot);
		d = ans[1];
		if (d < 0) { d = (tot + d); }
		
		//Encrypt Message
		m = 2;
		enc = ((Math.pow(m, e)) % n);
		
		//Decrypt Message
		dec = ((Math.pow(enc, d)) % n);
		
	}
	
	public static int[] ExtendedEuclid(int a, int b)
	    /*  This function will perform the Extended Euclidean algorithm
	        to find the GCD of a and b.  We assume here that a and b
	        are non-negative (and not both zero).  This function also
	        will return numbers j and k such that 
	               d = j*a + k*b
	        where d is the GCD of a and b.
	    */
	    { 
	        int[] ans = new int[3];
	        int q;

	        if (b == 0)  {  /*  If b = 0, then we're done...  */
	            ans[0] = a;
	            ans[1] = 1;
	            ans[2] = 0;
	        }
	        else
	            {     /*  Otherwise, make a recursive function call  */ 
	               q = a/b;
	               ans = ExtendedEuclid (b, a % b);
	               int temp = ans[1] - ans[2]*q;
	               ans[1] = ans[2];
	               ans[2] = temp;
	            }

	        return ans;
	    }
}
