

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GamerInfoDialog extends JDialog{
	
	private JLabel nomLabel, sexeLabel, cheveuxLabel, ageLabel, tailleLabel,taille2Label, icon;
	private JRadioButton tranche1, tranche2, tranche3, tranche4;
	private JComboBox<String> sexe, cheveux;
	private JTextField nom, taille;
	private BufferedImage img;
	private File selectedFile;
	
	public GamerInfoDialog () {
		super();
	    initDialog();
	}

	private void initDialog() {
		this.setTitle("Entrez Vos Informations");
		this.setSize(550, 270);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    
	    //Icône 
		img = null;
		selectedFile = new File("C:/Users/Ordinateur/workspace/ExerciceGamerInfos/src/creed.jpg");
	    try {
	         img = ImageIO.read(selectedFile);
	    } catch (IOException e) {
	          e.printStackTrace();
	    }  
	    icon = new JLabel(new ImageIcon(img.getScaledInstance(80, 100, Image.SCALE_SMOOTH)));
	    icon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getName());
					try {
				         img = ImageIO.read(selectedFile);
				     } catch (IOException ex) {
				          ex.printStackTrace();
				     }  
				     icon.setIcon(new ImageIcon(img.getScaledInstance(80, 100, Image.SCALE_SMOOTH)));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub		
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub		
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub		
			}});
	    icon.setToolTipText("Cliquez ici pour changer votre PP");
	    JPanel panIcon = new JPanel();
	    panIcon.setBackground(Color.white);
	    panIcon.setLayout(new BorderLayout());
	    panIcon.add(icon);
	    
	    //Le nom
	    JPanel panNom = new JPanel();
	    panNom.setBackground(Color.white);
	    panNom.setPreferredSize(new Dimension(220, 60));
	    nom = new JTextField();
	    nom.setPreferredSize(new Dimension(100, 25));
	    panNom.setBorder(BorderFactory.createTitledBorder("Nom du Gamer"));
	    nomLabel = new JLabel("Saisir un nom :");
	    panNom.add(nomLabel);
	    panNom.add(nom);

	    //Le sexe
	    JPanel panSexe = new JPanel();
	    panSexe.setBackground(Color.white);
	    panSexe.setPreferredSize(new Dimension(220, 60));
	    panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du Gamer"));
	    sexe = new JComboBox<String>();
	    sexe.addItem("Masculin");
	    sexe.addItem("Féminin");
	    sexe.addItem("Aucun");
	    sexeLabel = new JLabel("Sexe : ");
	    panSexe.add(sexeLabel);
	    panSexe.add(sexe);

	    //L'âge 
	    JPanel panAge = new JPanel();
	    panAge.setBackground(Color.white);
	    panAge.setBorder(BorderFactory.createTitledBorder("Age du Gamer"));
	    panAge.setPreferredSize(new Dimension(440, 60));
	    tranche1 = new JRadioButton("15 - 25 ans");
	    tranche1.setSelected(true);
	    tranche2 = new JRadioButton("26 - 35 ans");
	    tranche3 = new JRadioButton("36 - 50 ans");
	    tranche4 = new JRadioButton("+ de 50 ans");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(tranche1);
	    bg.add(tranche2);
	    bg.add(tranche3);
	    bg.add(tranche4);
	    panAge.add(tranche1);
	    panAge.add(tranche2);
	    panAge.add(tranche3);
	    panAge.add(tranche4);

	    //La taille
	    JPanel panTaille = new JPanel();
	    panTaille.setBackground(Color.white);
	    panTaille.setPreferredSize(new Dimension(220, 60));
	    panTaille.setBorder(BorderFactory.createTitledBorder("Taille du Gamer"));
	    tailleLabel = new JLabel("Taille : ");
	    taille2Label = new JLabel(" cm");
	    taille = new JTextField("180");
	    taille.setPreferredSize(new Dimension(90, 25));
	    panTaille.add(tailleLabel);
	    panTaille.add(taille);
	    panTaille.add(taille2Label);

	    //La couleur des cheveux
	    JPanel panCheveux = new JPanel();
	    panCheveux.setBackground(Color.white);
	    panCheveux.setPreferredSize(new Dimension(220, 60));
	    panCheveux.setBorder(BorderFactory.createTitledBorder("Couleur de cheveux du Gamer"));
	    cheveux = new JComboBox<String>();
	    cheveux.addItem("Blond");
	    cheveux.addItem("Brun");
	    cheveux.addItem("Roux");
	    cheveux.addItem("Blanc");
	    cheveuxLabel = new JLabel("Cheveux");
	    panCheveux.add(cheveuxLabel);
	    panCheveux.add(cheveux);

	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panNom);
	    content.add(panSexe);
	    content.add(panAge);
	    content.add(panTaille);
	    content.add(panCheveux);
	    
	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("OK");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {        
	          JOptionPane jop = new JOptionPane();
		      jop.showMessageDialog(null, toString(), "Informations Gamer", JOptionPane.INFORMATION_MESSAGE);
	    	  setVisible(false);
	      }

	      public String getAge(){
	        return (tranche1.isSelected()) ? tranche1.getText() : 
	               (tranche2.isSelected()) ? tranche2.getText() : 
	               (tranche3.isSelected()) ? tranche3.getText() : 
	               (tranche4.isSelected()) ? tranche4.getText() : 
	                tranche1.getText();  
	      }

	      public String getTaille(){
	        return (taille.getText().equals("")) ? "180" : taille.getText();
	      }
	      
	      public String toString(){
			    String str;
			    String nomStr = nom.getText();
			    String sexeStr = (String)sexe.getSelectedItem();
			    String ageStr = getAge(); 
			    String cheveuxStr = (String)cheveux.getSelectedItem();
			    String tailleStr =getTaille();
			    if(nomStr != null && sexeStr != null && tailleStr != null && ageStr != null && cheveux != null){
			      str = "Description du Gamer : \n";
			      str += "Nom : " + nomStr + "\n";
			      str += "Sexe : " + sexeStr + "\n";
			      str += "Age : " + ageStr + "\n";
			      str += "Cheveux : " + cheveuxStr + "\n";
			      str += "Taille : " + tailleStr + "\n";
			    }
			    else{
			      str = "Aucune information !";
			    }
			    return str;
		  }
	    });

	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        setVisible(false);
	      }      
	    });

	    control.add(okBouton);
	    control.add(cancelBouton);
	    
	    this.getContentPane().add(panIcon, BorderLayout.WEST);
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	}

}
