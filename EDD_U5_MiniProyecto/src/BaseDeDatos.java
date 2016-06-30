
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BaseDeDatos {
    protected int [] ord;
    protected int [] org;
    
    BaseDeDatos(){
    try{
    ObjectInputStream io = new ObjectInputStream(new FileInputStream("Arreglo.EDD_U5"));
    ord = (int [])io.readObject();
    org = (int [])io.readObject();
    io.close();
    }catch(FileNotFoundException err){} 
    catch (IOException | ClassNotFoundException ex) {}     
    }
    
    public boolean guardar(){
    try{    
    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Arreglo.EDD_U5"));
    os.writeObject(ord);
    os.writeObject(org);
    os.close();
    }catch(FileNotFoundException err){} catch (IOException ex) {return false;}
    return true;
}
}
