
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cherne
 */
public class Metodos {
    
    
    
    
    public void burbuja(int[] arr){
        if(arr.length==0)return;
        boolean bandera=true;
        for(;bandera;){
            bandera=false;
            for(int i =0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    int aux = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=aux;
                    bandera=true;
                }
            }
        }
    }
    
    public void quickSort(int[] arr, int izq, int der) {
		if (arr == null || arr.length == 0)return;
 
		if (izq >= der)return;
 
//poner el pivote en el inicio,asignar punteros izquierdo y derecho
                int pivot = arr[izq];
		int i = izq, d = der;
		while (i <= d) {
			while (arr[i] < pivot) {
				i++;       
			}
			while(arr[d] > pivot) {
				d--;
			}
			if (i <= d) {
				int temp = arr[i];
				arr[i] = arr[d];
				arr[d] = temp;
				i++;d--;
			}
		}
		if (izq < d) quickSort(arr, izq, d); //izquierdo
		if (der > i) quickSort(arr, i, der);//derecho
	}
    
    
    public void shellsort(int  arr[]){
        boolean bandera= true;
        int x = arr.length/2;
        for(;bandera;){
            bandera=false;
            for(int i=0;(i+x<arr.length);i++){
                if(arr[i]>arr[i+x]){
                    int aux= arr[i];
                    arr[i]=arr[i+x];
                    arr[i+x] = aux;
                    bandera = true;
                }
            }
            if(x!=1)x=x/2;
        }
        
    }
    
    public void radix(int arr[], int maxDigits){
		int exp = 1;//10^0;
		for(int i =0; i < maxDigits; i++){
			ArrayList bucketList[] = new ArrayList[10];
			for(int k=0; k < 10; k++){
				bucketList[k] = new ArrayList();
			}
			for(int j =0; j < arr.length; j++){
				int number = (arr[j]/exp)%10;
				bucketList[number].add(arr[j]);
			}
			exp *= 10;
			int index =0;
			for(int k=0; k < 10; k++){
                            for (Iterator it = bucketList[k].iterator(); it.hasNext();) {
                                int num = (int)it.next();
                                arr[index] = num;
                                index++;
                            }
			}
		}
	}

    public int[] mezclaDirecta (int[] L) {
      int n = L.length;
      if (n > 1){ int m = (int) (Math.ceil(n/2.0));
         int [] L1 = new int[m];
         int [] L2 = new int[n-m];
         for (int i = 0; i < m; i++) {
           L1[i] = L[i];
         }
         for (int i = m; i < n; i++) {
            L2[i-m] = L[i];
         }
         L = Mezcla(mezclaDirecta(L1), mezclaDirecta(L2));
      }
      return L;
   }

   public int[] eliminar (int [] l) {
      int [] L = new int[l.length-1];
      for(int i = 1; i < l.length; i++){
         L[i-1] = l[i];
      }
      return L;
   }

   public int[] Mezcla(int[] L1, int[] L2) {
      int[] L = new int[L1.length+L2.length];
      int i = 0;
      while ((L1.length != 0) && (L2.length != 0)) {
         if (L1[0] < L2[0]) {
            L[i++] = L1[0];
            L1 = eliminar(L1);
            if (L1.length == 0){ while (L2.length != 0) {
               L[i++] = L2[0];
               L2 = eliminar(L2);
            }
         }
      }
      else {
         L[i++] = L2[0];
         L2 = eliminar(L2);
         if (L2.length == 0) {
            while (L1.length != 0) {
               L[i++] = L1[0];
               L1 = eliminar(L1);
            }
         }
      }
   }
   return L;
    }
    
    public int[] mezclaNatural(int[] arr){
        return null;
    }
    
    public int[] generar(int n ){
        int  arreglo[];
        arreglo=new int[n];
        for(int i=0;i<n;i++){
            arreglo[i]=(int)(Math.random()*1000);
        }
        return arreglo;
    }
}
