
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BaseDeDatos {
    protected int [] ord;
    protected int [] org;
    
    
    public void abrir(){
    try{
    ObjectInputStream io = new ObjectInputStream(new FileInputStream("Arreglo.EDD_U5"));
    org = (int [])io.readObject();
    io.close();
    ObjectInputStream i = new ObjectInputStream(new FileInputStream("ArregloOrdenado.EDD_U5"));
    ord = (int [])i.readObject();
    i.close();
    }catch(FileNotFoundException err){} 
    catch (IOException | ClassNotFoundException ex) {}  
}

   public void setOrg(int a[]){
      org = new int[a.length];
      for(int i = 0; i < a.length; i++){
         org[i] = a[i];
      }
   }
   
   public int[] getOrg(){
      int []temp = new int[org.length];
      for(int i = 0; i < org.length; i++){
         temp[i] = org[i];
      }
      return temp;   
   }   
   
   public void setOrd(int a[]){
      ord = new int[a.length];
      for(int i = 0; i < a.length; i++){
         ord[i] = a[i];
      }
   }
   
   public int[] getOrd(){
      int []temp = new int[ord.length];
      for(int i = 0; i < ord.length; i++){
         temp[i] = ord[i];
      }   
      return temp;
   }
    
    public boolean guardar(){
    try{    
    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Arreglo.EDD_U5"));
    os.writeObject(org);
    os.close();
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("ArregloOrdenado.EDD_U5"));
    o.writeObject(ord);
    o.close();
    }catch(FileNotFoundException err){} catch (IOException ex) {return false;}
    return true;
}

}
