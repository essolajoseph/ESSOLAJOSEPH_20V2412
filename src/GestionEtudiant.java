import java.util.Scanner;

public class GestionEtudiant {
    public static void main(String[] args) {
        char conti='0',reini='0';
        double bonus=0;
        do {
            System.out.println("Entrer l'effectif de la salle: ");
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            System.out.println("Remplisser les informations des etudiants : ");
            Etudiant[] tableau = new Etudiant[n];
            for (int i = 0; i < n; i++) {
                System.out.println("etudiant" + (i + 1));
                tableau[i] = new Etudiant("", "", '0', null, 0);
                tableau[i].AjoutEtudiannt();
                System.out.println("Bonus :");
                bonus=scan.nextDouble();
                tableau[i] = new Etudiant(tableau[i].nom, tableau[i].Matricule, tableau[i].genre, tableau[i].DateDeNaissance, tableau[i].moyenne);
            }

            //affichage du menu
            do {
                System.out.println("Quelle Action voulez-vous excuter?\n1.Afficher les étudiants par ordre de mérite\n2.Afficher les informations sur le premier étudiant\n3.Afficher les informations du dernier étudiant\n4.Réinitialiser la liste de la classe\n5.Sortir du programme\nVotre Choix");
                int menu = scan.nextInt();
                int i = 0, j , tmp1;
                int[] ta = new int[n];
                double[] tab = new double[n];
                double tmp2;
                switch  (menu) {
                    case 1:
                        while (i < n) {
                            tab[i] = tableau[i].moyenne;
                            ta[i] = i;
                            i++;
                        }
                        for (i = 0; i < n; i++) {
                            for (j = 0; j < n; j++) {
                                if (tab[i] < tab[j]) {
                                    tmp2 = tab[i];
                                    tab[i] = tab[j];
                                    tab[j] = tmp2;
                                    tmp1 = ta[i];
                                    ta[i] = ta[j];
                                    ta[j] = tmp1;
                                }
                            }
                        }
                        System.out.println("Les etudiants par ordre de merite sont ");
                        for (i = 0; i < n; i++) {
                            tableau[ta[i]].Afficher(bonus);
                        }
                        break;
                    case 2:
                        j = 1;
                        for (i = 0; i < n; i++) {
                            if (tableau[i].moyenne > tableau[j].moyenne) {
                                j = i;
                            }
                        }
                        tableau[j].Afficher(bonus);
                        break;
                    case 3:
                        j = 1;
                        for (i = 0; i < n; i++) {
                            if (tableau[i].moyenne < tableau[j].moyenne) {
                                j = i;
                            }
                        }
                        tableau[j].Afficher(bonus);
                        break;
                    case 4:
                        for (i = 0; i < n; i++) {
                            tableau[i] = null;
                        }
                        reini='1';
                        System.out.println("Listes reinitialisée! ");
                        break;
                    case 5:
                        conti = '1';
                        break;
                    default:
                        System.out.println("Vous avez fait un mauvais choix ");
                        break;
                }
            } while (conti!='1'&&reini!='1');
        } while ( conti != '1'&&reini=='1');
    }
}
