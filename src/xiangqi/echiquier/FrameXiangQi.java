package xiangqi.echiquier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import xiangqi.piece.*;

public class FrameXiangQi extends JFrame {

	private JPanel contentPane;
	JPanel panelConteneur;
	JLabel labelImage, labelCouleur;
	JLabel grille[][]; //90 JLabels transparents supperposés aux intersections
	JPanel panelNoirs, panelRouges, panelControle;
	JButton boutonDebuter, boutonRecommencer;
	Ecouteur ec;
	Echiquier echiquier; //Échiquier faisant le lien avec la logique du jeu

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameXiangQi frame = new FrameXiangQi();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *constructeur
	 */
	public FrameXiangQi() {

		// Initialiser les variables (tableaux) pour conserver l'état du jeu (où sont les pièces) ET son affichage graphique
		echiquier = new Echiquier(); // État du jeu: création de l'échiquier et des 90 JLabels
		grille = new JLabel[10][9];  // État de l'affichage graphique du jeu: création d'une grille de JLabels pour afficher les pièces
		
		//  Fenêtre complète du jeu
		setTitle("XiangQi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 900);  //height original: 759
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//  Panneau du plateau de jeu (Échiquier)
		panelConteneur= new JPanel();
		panelConteneur.setBackground(new Color(255, 228, 196));
		panelConteneur.setBounds(26, 77, 675, 750);  //Original witdh: 675, height 643
		panelConteneur.setLayout(new GridLayout(10, 9, 0, 0));
		panelConteneur.setOpaque(false);
		contentPane.add(panelConteneur);

		// Graphique de l'échiquier (la grille, lignes, colonnes, rivière, palais etc.)
		labelImage= new JLabel("");
		labelImage.setBounds(30, 105, 690, 700);  // Original width=690, height=627
		contentPane.add(labelImage);
		labelImage.setIcon(( new ImageIcon( "icones/fond.png")));

		//  Panneau pour afficher les pièces noires qui ont été mangées
		panelNoirs = new JPanel();
		panelNoirs.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		panelNoirs.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNoirs.setBounds(772, 77, 68, 751);
		contentPane.add(panelNoirs);

		//  Panneau pour afficher les pièces rouges qui ont été mangées
		panelRouges = new JPanel();
		panelRouges.setBackground(new Color(255, 102, 102));
		panelRouges.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRouges.setBounds(850, 77, 68, 751);
		contentPane.add(panelRouges);

		//  Panneau pour menu du haut avec texte et boutons Débuter et Recommencer
		panelControle = new JPanel();
		panelControle.setBackground(new Color(255, 228, 196));
		panelControle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelControle.setBounds(0, 11, 918, 58);
		contentPane.add(panelControle);
		panelControle.setLayout(null);

		//  Bouton Recommencer
		boutonRecommencer = new JButton("Recommencer");
		boutonRecommencer.setBounds(744, 22, 152, 23);
		boutonRecommencer.setBackground(new Color(255,239,213));
		boutonRecommencer.setContentAreaFilled(false);
		boutonRecommencer.setOpaque(true);
		panelControle.add(boutonRecommencer);
		boutonRecommencer.setFont(new Font("Tahoma", Font.BOLD, 15));

		// Bouton Débuter
		boutonDebuter = new JButton("D\u00E9buter");
		boutonDebuter.setBackground(new Color(255, 239, 213));
		boutonDebuter.setBounds(610, 22, 119, 23);
		boutonDebuter.setContentAreaFilled(false);
		boutonDebuter.setOpaque(true);
		panelControle.add(boutonDebuter);
		boutonDebuter.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCouleur = new JLabel("");
		labelCouleur.setBackground(new Color(255, 239, 213));
		labelCouleur.setOpaque(true);
		labelCouleur.setBounds(53, 11, 475, 41);
		
		panelControle.add(labelCouleur);
		labelCouleur.setFont(new Font("Tahoma", Font.BOLD, 20));

		//  Création de l'écouteur: c'est cet élément du Frame qui permet de détecter des clics de souris
		//  sur des éléments précis comme des boutons, des JLabels etc.
		//  C'est la gestion des événements
		ec = new Ecouteur();

		// C'est ici que les JLabels transparents de la grille sont initialisés
		//  On affichera les pièces sur les JLabels en leur associant un graphique
		//  On ajoute un écouteur pour détecter un clic de souris sur chaque JLabel de la grille
		for ( int i = 0 ; i < 10 ; i ++ )
			for ( int j = 0 ; j < 9 ; j ++ )
			{
				grille[i][j] = new JLabel();
				grille[i][j].addMouseListener( ec );
				panelConteneur.add( grille[i][j]);
				grille[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			}

		// On ajouter aussi des écouteurs pour détecter des clics de souris sur chacun des 2 boutons
		boutonDebuter.addMouseListener(ec);
		boutonRecommencer.addMouseListener(ec);
	}

	// La classe écouteur contient tout le code qui traite les actions à entreprendre
	// lorsqu'un clic de souris est détecté sur un des éléments spécifiés
	private class Ecouteur extends MouseAdapter
	{
		int ligneClic, colonneClic;
		Piece pieceTampon, pieceEnlevee;
		ImageIcon iconeTampon;
		Position depart, arrivee;
		String couleurControle; //valeur rouge ou noir ;
		
		//  Cette méthode suit les tours de jeu pour s'assurer qu'un joueur ne peut jouer en dehors de son tour
		public void alterne ()
		{
		if (couleurControle == "rouge")
			couleurControle = "noir";
		else
			couleurControle = "rouge";
		labelCouleur.setText("C'est aux " + couleurControle + "s à jouer ");
		}

		// Enlève toutes les pièces de l'affichage graphique, sur l'échiqiuer et dans les panneaux de pièces mangées
		public void enleverToutesLesPieces()
		{
			// Vider les panneaux de pièces mangées
			panelRouges.removeAll();
			panelNoirs.removeAll();

			// Enlever toutes les pièces de l'affichage de l'échiquier
			for ( int i = 0; i < 10 ; i++ ) {
				for ( int j = 0; j < 9 ; j ++) {
					grille[i][j].setIcon (null);
				}
			}
		}

		public void afficherPiecesPourDebut()
		{
			grille[0][0].setIcon(new ImageIcon ( "icones/charNoir.png"));
			grille[0][1].setIcon( new ImageIcon ( "icones/cavalierNoir.png"));
			grille[0][2].setIcon( new ImageIcon( "icones/elephantNoir.png"));
			grille[0][3].setIcon( new ImageIcon ( "icones/mandarinNoir.png"));
			grille[0][4].setIcon( new ImageIcon("icones/roiNoir.png"));
			grille[0][5].setIcon(new ImageIcon("icones/mandarinNoir.png"));
			grille[0][6].setIcon( new ImageIcon( "icones/elephantNoir.png"));
			grille[0][7].setIcon( new ImageIcon ( "icones/cavalierNoir.png"));
			grille[0][8].setIcon(new ImageIcon ( "icones/charNoir.png"));
			grille[2][1].setIcon( new ImageIcon( "icones/bombardeNoir.png"));
			grille[2][7].setIcon(new ImageIcon("icones/bombardeNoir.png"));
			grille[3][0].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][2].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][4].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][6].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][8].setIcon(new ImageIcon("icones/pionNoir.png"));

			grille[9][0].setIcon(new ImageIcon ( "icones/charRouge.png"));
			grille[9][1].setIcon( new ImageIcon ( "icones/cavalierRouge.png"));
			grille[9][2].setIcon( new ImageIcon( "icones/elephantRouge.png"));
			grille[9][3].setIcon( new ImageIcon ( "icones/mandarinRouge.png"));
			grille[9][4].setIcon( new ImageIcon("icones/roiRouge.png"));
			grille[9][5].setIcon(new ImageIcon("icones/mandarinRouge.png"));
			grille[9][6].setIcon( new ImageIcon( "icones/elephantRouge.png"));
			grille[9][7].setIcon( new ImageIcon ( "icones/cavalierRouge.png"));
			grille[9][8].setIcon(new ImageIcon ( "icones/charRouge.png"));
			grille[7][1].setIcon( new ImageIcon( "icones/bombardeRouge.png"));
			grille[7][7].setIcon(new ImageIcon("icones/bombardeRouge.png"));
			grille[6][0].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][2].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][4].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][6].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][8].setIcon(new ImageIcon("icones/pionRouge.png"));
		}

		public void recommencer(){
			echiquier = new Echiquier ();
		    echiquier.debuter();

			enleverToutesLesPieces();
			afficherPiecesPourDebut();

		    couleurControle = "noir";
		    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer ");

		    // Rafraichir l'affichage en fonction des desrniers changements
			repaint();
		    panelRouges.updateUI();
		    panelNoirs.updateUI();

			//reset la piece tampon
			pieceTampon = null;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if ( e.getSource() == boutonDebuter)
			{
				echiquier.debuter();
				//icones
				afficherPiecesPourDebut();

				couleurControle="rouge";  // rouges commencent en premier
				labelCouleur.setText("C'est aux " + couleurControle + "s à jouer ");
			}
			else if ( e.getSource() == boutonRecommencer)
			{
				recommencer();
			}
			else // il s'agit d'un label / intersection
			{
			    //trouver lequel
			    for ( int i = 0; i < 10 ; i++ )
			    {
			    	for ( int j = 0; j < 9; j++ )
			        {
			        	if (e.getSource() == grille[i][j])
			        	{
			        		ligneClic = i;  //  Numéro de la ligne de l'intersection qui a été cliquée
							colonneClic = j;  //  Numéro de la colonne de l'intersection qui a été cliquée
						}
					}
				}


				//  ************************
				//  CODER ICI
				//  ************************
				System.out.println(" ");

				//La position avec lequel le joueur tente d'intéragir
				Position positionClic = new Position(ligneClic, colonneClic);

				//Avons-nous les mains vide?
				if(pieceTampon ==null) {

					//Oui, donc le joueur tente de prendre une pièce
					System.out.println("Le joueur tente de prendre la pièce ["+ligneClic+", "+colonneClic+"]");

					//Y-a-t-il une piece? Bonne couleur?
					if(echiquier.estOccupeParCouleur(positionClic, couleurControle)) {

						Piece piece = echiquier.getIntersection(positionClic).getPiece();
						System.out.println("["+ligneClic+", "+colonneClic+"] contient la piece: "+piece.getNomComplet());

						//si oui, on la prend en main (sauvegarde la piece et son graphique)
						pieceTampon = piece;
						iconeTampon = (ImageIcon)grille[ligneClic][colonneClic].getIcon();

						//et on retire le graphique
						grille[ligneClic][colonneClic].setIcon(null);
						System.out.println(piece.getNomComplet()+" maintenant en main du joueur.");

						//Ceci sera la postion de départ
						depart = positionClic;
					}
					else
					{
						//Clic invalide
						System.out.println("Le joueur ne peut pas de prendre ["+ligneClic+", "+colonneClic+"]");
					}
				}
				else
				{
					//Non, donc le joueur tente de déplacé une pièce
					System.out.println("Le joueur tente de déplacé:"+pieceTampon.getNomComplet()+" vers ["+ligneClic+", "+colonneClic+"]");
					//Ceci sera la position d'arrivée
					arrivee = positionClic;
					boolean roiCapture = false;
					//Vérifions si le déplacement est valide:
					if(pieceTampon.estValide(depart, arrivee) && echiquier.cheminPossible(depart, arrivee) && echiquier.roisNePouvantPasEtreFaceAFace(depart, arrivee)) {

						//deplacement valide!
						System.out.println("Le déplacement vers ["+ligneClic+", "+colonneClic+"] est... VALIDE!");

						//faut-il capturé avant de se déplacé?
						if(echiquier.estOccupeParEnnemi(depart, arrivee))
						{
							roiCapture = echiquier.getIntersection(arrivee).getPiece() instanceof Roi;
							//capture avant de bouger
							executeCapture();
						}
						//Fait le déplacement
						executeDeplacement();

						//si la piece capturé est le roi, termine la partie
						if(roiCapture)
						{
							//informe le joueur que c'est fini
							System.out.println("Le joueur "+couleurControle+" a gagné! ");
							labelCouleur.setText("Le joueur "+ couleurControle+ " a gagné!");
							//bloc tous les déplacements en changeant la couleur de controle à une couleur invalide
							couleurControle = "QUE PERSONNE NE BOUGE CECI EST UNE SCÈNE DE CRIME";
						}
						//pas la meme position? alternons de joueur, sinon le joueur à simplement annulé son déplacement
						else if(!depart.equals(arrivee))
							alterne();

						//reset la piece tampon,
						pieceTampon = null;

					}
					else
					{
						//Déplacement invalide
						System.out.println("Le déplacement vers ["+ligneClic+", "+colonneClic+"] est invalide");
					}
				}

				//clic fini
				System.out.println(" ******************************************************************************* ");
			}
		}

		public void executeDeplacement()
		{

			//retire la piece du départ et place la pièce sur l'arrivée
			echiquier.getIntersection(depart).setPiece(null);
			echiquier.getIntersection(arrivee).setPiece(pieceTampon);
			//update graphique
			grille[ligneClic][colonneClic].setIcon(iconeTampon);
		}
		public void executeCapture(){
			//C'est une capture! supprimons la piece ennemi avant d'effectuer le déplacement
			//ajoute la piece capturé au panneau des captures du joueur actuel
			if(couleurControle.equals("noir"))
				panelNoirs.add(new JLabel((ImageIcon)grille[ligneClic][colonneClic].getIcon()));
			else
				panelRouges.add(new JLabel((ImageIcon)grille[ligneClic][colonneClic].getIcon()));

			//retire la piece capturer de l'échiquier
			grille[ligneClic][colonneClic].setIcon(null);
			echiquier.getIntersection(arrivee).setPiece(null);

		}
	}
}

