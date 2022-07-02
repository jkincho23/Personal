/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Diana
 */

package logic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Service {

    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    HashMap<String,Word> SpaWords;
    HashMap<String,Word> EngWords;

    
    private Service(){

        SpaWords = new HashMap<String, Word>();
        SpaWords.put("1", new Word("1","arroz"));
        SpaWords.put("2", new Word("2","perro"));
        SpaWords.put("3", new Word("3","gato"));
        SpaWords.put("4", new Word("4","pajaro"));
        SpaWords.put("5", new Word("5","carro"));
        SpaWords.put("6", new Word("6","correr"));
        SpaWords.put("7", new Word("7","abeja"));
        
        EngWords = new HashMap<String, Word>();
        EngWords.put("1", new Word("1","rice"));
        EngWords.put("2", new Word("2","dog"));
        EngWords.put("3", new Word("3","cat"));
        EngWords.put("4", new Word("4","bird"));
        EngWords.put("5", new Word("5","car"));
        EngWords.put("6", new Word("6","run"));
        EngWords.put("7", new Word("7","bee"));

    }
          

    
    public Word SpaWordsCREATE(Word pac)throws Exception {
        if (SpaWords.get(pac.id)!=null){
            throw new Exception ("Palabraya existe");
        }
        else{
            SpaWords.put(pac.id,pac);
            return pac;
        }
    }
    
    public List<Word> SpaWordsREAD() {
        return new ArrayList(SpaWords.values());
    } 
    
    public Word SpaWordsREAD(String word)throws Exception {
        Word aux = new Word();
        String id = "";
        try{
            for (Word p : SpaWords.values()){
                if(p.palabra.equals(word)){
                    id = p.id;
                    break;
                }
            }
            if(id.isEmpty()){
                for (Word p : EngWords.values()){
                    if(p.palabra.equals(word)){
                        id = p.id;
                        break;
                    }
                } 
                if(id.isEmpty()){
                   throw new Exception ("Palabra no existe");      
                }
                else{//buscar en espanol
                    if (SpaWords.get(id)!=null){
                        return SpaWords.get(id);
                    }
                    else{
                        throw new Exception ("Palabra no existe");
                    }
                }
            }
            else{ 
                if (EngWords.get(id)!=null){
                    return EngWords.get(id);
                }
                else{
                    throw new Exception ("Palabra no existe");
                }
                
            }            
        } catch (Exception ex) {
            throw new Exception ("Paciente no existe"); 
        }
    }
    
    public void SpaWordsUPDATE(Word pac)throws Exception {
        if (SpaWords.get(pac.id)==null){
            throw new Exception ("Paciente no existe");
        }
        else{
            SpaWords.replace(pac.id, pac);
        }
    }
    
    public void SpaWordsDELETE(String idPaciente)throws Exception {
        if (SpaWords.get(idPaciente)==null){
            throw new Exception ("Paciente no existe");
        }
        else{
            SpaWords.remove(idPaciente);
        }
    }

    
    public Word EngWordsCREATE(Word pac)throws Exception {
        if (EngWords.get(pac.id)!=null){
            throw new Exception ("Palabraya existe");
        }
        else{
            EngWords.put(pac.id,pac);
            return pac;
        }
    }
    
    public List<Word> EngWordsREAD() {
        return new ArrayList(EngWords.values());
    } 
    
    public Word EngWordsREAD(String idWord)throws Exception {
        if (EngWords.get(idWord)!=null){
            return EngWords.get(idWord);
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }
    
    public void EngWordsUPDATE(Word pac)throws Exception {
        if (EngWords.get(pac.id)==null){
            throw new Exception ("Paciente no existe");
        }
        else{
            EngWords.replace(pac.id, pac);
        }
    }
    
    public void EngWordsDELETE(String idPaciente)throws Exception {
        if (EngWords.get(idPaciente)==null){
            throw new Exception ("Paciente no existe");
        }
        else{
            EngWords.remove(idPaciente);
        }
    }


    
//    public static void main(String args[]){
//        
//        try {
//            List<Paciente> pac = Service.instance().pacientesREADbyDoctor("111");
//            for(Paciente p : pac){
//                System.out.println(p.getNombre());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//    }

}

