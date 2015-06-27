/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.gamesearch;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Json {

 private static final String filePath = "http://localhost:3229/api/jeux";

//    public static void main(String[] args) {
//
//     try {
//        URL uneUrl = new URL(filePath);
//         // read the json file
//
////         FileReader reader = new FileReader(filePath);
//    InputStream is = uneUrl.openStream();
//      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//      String line;
//      StringBuffer response = new StringBuffer();
//      while((line = rd.readLine()) != null) {
//        response.append(line);
//        response.append('\r');
//      }
//      rd.close();
//
//      List<Jeu> lesJeux = new ArrayList<Jeu>();
//         JSONParser jsonParser = new JSONParser();
//         JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
//        JSONArray id = (JSONArray) jsonObject.get("$values");
//         for(int i=0; i<id.size(); i++){
//
//
//         }
//        Iterator i = id.iterator();
//         // take each value from the json array separately
//
//         while (i.hasNext())
//         {
//            Jeu unJeu = new Jeu();
//            JSONObject innerObj = (JSONObject) i.next();
//            unJeu.setIdJeu(Integer.parseInt(innerObj.get("$id").toString()));
//            unJeu.setNomJeu( innerObj.get("NOM_JEU").toString());
//
//            String s = innerObj.get("DATE_DE_SORTIE").toString();
//           // Date annee = new Date(Integer.parseInt(s.split("-",4).toString()),Integer.parseInt(s.split("-",6).toString()),Integer.parseInt( s.split("-",8).toString()));
//         // unJeu.dateDeSortie = ;
//
//           unJeu.setDescriptifJeu(innerObj.get("DESCRIPTIF").toString());
//
//          //  System.out.println("Nom du jeu : " + innerObj.get("NOM_JEU") +" Description du jeu : " + innerObj.get("DESCRIPTIF") +" Date de sortie : "+ innerObj.get("DATE_DE_SORTIE"));
//           JSONObject Norme = (JSONObject) innerObj.get("NORME");
//           Norme uneNorme = new  Norme();
//           uneNorme.setIdNorme(Integer.parseInt(Norme.get("ID_NORME").toString()));
//           uneNorme.setDescriptionNorme(Norme.get("DESCRIPTION").toString());
//          // System.out.println("Norme : "+Norme.get("DESCRIPTION"));
//
//            //Get list Genre
//            JSONObject lesGenres = (JSONObject) innerObj.get("GENREs");
//            JSONArray genre = (JSONArray)lesGenres.get("$values");
//            Iterator j = genre.iterator();
//            while (j.hasNext())
//              {
//                  Genre unGenre = new Genre();
//                  JSONObject genreObject = (JSONObject) j.next();
//                if(genreObject.get("ID_GENRE") != null){
//              //    System.out.println("Nom du genre : "+ genreObject.get("NOM_GENRE"));
//                  unGenre.setNomGenre(genreObject.get("NOM_GENRE").toString());
//                  unGenre.setIdGenre(Integer.parseInt(genreObject.get("ID_GENRE").toString()));
//                unJeu.Genre.add(unGenre);
//                }
//              }
//
//            //Get List Editeur
//            JSONObject lesEditeurs = (JSONObject) innerObj.get("EDITEURs");
//            JSONArray editeur = (JSONArray)lesEditeurs.get("$values");
//            Iterator z = editeur.iterator();
//            while (z.hasNext())
//              {
//                  Editeur unEditeur = new Editeur();
//
//                  JSONObject EditeurObject = (JSONObject) z.next();
//                  if(EditeurObject.get("ID_EDITEUR") != null)
//                  {
//                    unEditeur.setNom(EditeurObject.get("NOM_EDITEUR").toString());
//                    unEditeur.setId(Integer.parseInt(EditeurObject.get("ID_EDITEUR").toString()));
//                //  System.out.println("Nom du Editeur : "+ EditeurObject.get("NOM_EDITEUR"));
//                  }
//                    unJeu.Editeur.add(unEditeur);
//              }
//          lesJeux.add(unJeu);
//         }
//
//          // System.out.println(lesJeux.size());
//     } catch (FileNotFoundException ex) {
//
//         ex.printStackTrace();
//
//     } catch (IOException ex) {
//
//         ex.printStackTrace();
//
//     } catch (ParseException ex) {
//
//         ex.printStackTrace();
//
//     } catch (NullPointerException ex) {
//
//         ex.printStackTrace();
//
//        }
//    }
    
}
