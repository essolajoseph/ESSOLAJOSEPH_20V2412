import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class Etudiant {
    String nom;
    String Matricule;
    char genre ;
    Date DateDeNaissance;
    double moyenne;
    //constructeur
    public Etudiant(String nom, String Matricule, char genre,Date DateDeNaissance,double moyenne) {
        this.nom = nom;
        this.Matricule=Matricule;
        this.genre=genre;
        this.DateDeNaissance=DateDeNaissance;
        this.moyenne=moyenne;

    }
    //AFFICHER LES INFORMATION DE L'ETUDIANT
    public void Afficher(double bonus) {
        SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(
                "nom='" + nom +
                        ", Matricule='" + Matricule+
                        ", genre=" + genre +
                        ", DateDeNaissance=" + s.format(DateDeNaissance) +
                        ", moyenne=" + moyenne+
                        ",bonus+moyenne="+Bonifier(moyenne,bonus));
    }
    public double Bonifier(double moyenne,double bonus){
        return moyenne+bonus;
    }
    //CALCULER AGE
    public int CalculAge(Date DateDeNaissance)
    {
        return new Date().getYear()-DateDeNaissance.getYear();
    }
    //ajouter d'un etudiant
    public  void  AjoutEtudiannt()
    {
        Scanner scan=new Scanner(System.in);
        //lecture du nom
        nom="";
        while (nom.length()<3)
        {
            System.out.println("Entrer le nom :");
            nom=scan.next();
        }
        //lecture du matricule
        Matricule ="";
        while (Matricule.length()!=7)
        {
            System.out.println("Entrer le matricule :");
            Matricule=scan.next().toUpperCase();
        }
        //lecture du genre
        genre ='0';
        while (genre!='F'&& genre!='M')
        {
            System.out.println("genre : ");
            genre=scan.next().charAt(0);
            if(genre=='m')
            {
                genre='M';
            }
            if(genre=='f')
            {
                genre='F';
            }
        }
        //lecture de la date de naissance
        DateDeNaissance=null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("entrer la date de naissance format JJ/MM/AAAA : ");

        boolean b;
        do{
            String dts=scan.next();
            try {
                b=true;
                DateDeNaissance= sdf.parse(dts);
            } catch (ParseException e) {
                System.out.println("Entrer la bonne date!");
                b=false;
            }
        }while (!b);
        //lecture de la moyenne
        moyenne=-1;
        try {
            while (moyenne > 20 || moyenne < 0) {
                System.out.println("entrer la moyenne : ");
                moyenne = scan.nextDouble();
            }
        } catch (Exception e) {
        }
    }
}
