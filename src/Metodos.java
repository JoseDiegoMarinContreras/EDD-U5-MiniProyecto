
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

    public int[] mezclaDirecta(int [] arreglo){
        int i,j,k;
        if(arreglo.length>1){
            int elementosIzq=arreglo.length/2;
            int elementosDer=arreglo.length-elementosIzq;
            int arregloIzq[] = new int[elementosIzq];
            int arregloDer[] = new int[elementosDer];
            
            for(i=0;i<elementosIzq; i++){
                arregloIzq[i]=arreglo[i];
            }
            for(i=elementosIzq; i<elementosIzq+elementosDer;i++){
                arregloDer[i-elementosIzq] = arreglo[i];
            }
            
            arregloIzq=mezclaDirecta(arregloIzq);
            arregloDer=mezclaDirecta(arregloDer);
            i=0;
            j=0;
            k=0;
            while(arregloIzq.length!=j && arregloDer.length!=k){
                if(arregloIzq[j]<arregloDer[k]){
                    arreglo[i]=arregloIzq[j];
                    i++;
                    j++;
                }else{
                    arreglo[i]=arregloDer[k];
                    i++;
                    k++;
                }
            }
            
            while(arregloIzq.length!=j){
                arreglo[i]  = arregloIzq[j];
                i++;
                j++;
            }
            while(arregloDer.length!=k){
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }
        return arreglo;
    }
    
    public void mezclaDirecta2(int [] arreglo){
        int i,j,k;
        if(arreglo.length>1){
            int nElementosIzq=arreglo.length/2;
            int nElementosDer=arreglo.length-nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            
            for(i=0;i<nElementosIzq; i++){
                arregloIzq[i]=arreglo[i];
            }
            for(i=nElementosIzq; i<nElementosIzq+nElementosDer;i++){
                arregloDer[i-nElementosIzq] = arreglo[i];
            }
            
            arregloIzq=mezclaDirecta(arregloIzq);
            arregloDer=mezclaDirecta(arregloDer);
            i=0;
            j=0;
            k=0;
            while(arregloIzq.length!=j && arregloDer.length!=k){
                if(arregloIzq[j]<arregloDer[k]){
                    arreglo[i]=arregloIzq[j];
                    i++;
                    j++;
                }else{
                    arreglo[i]=arregloDer[k];
                    i++;
                    k++;
                }
            }
            
            while(arregloIzq.length!=j){
                arreglo[i]  = arregloIzq[j];
                i++;
                j++;
            }
            while(arregloDer.length!=k){
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }
        
    }
    
    public void mezclaNatural(int[] arr){
        int izquierda =0,izq = 0,derecha=arr.length-1,der=derecha;
        boolean ordenado = false;
        do{
            ordenado = true;
            izquierda = 0;
            while(izquierda <derecha){
                izq = izquierda;
                while(izq <derecha && arr[izq]<=arr[izq+1]){
                    izq++;
                }
                der=izq+1;
                while(der==derecha-1 || der<derecha && arr[der]<=arr[der+1]){
                    der++;
                }
                if(der<derecha){
                    mezclaDirecta2(arr);
                    ordenado=false;
                }
                izquierda = izq;
            }
        }while(!ordenado);
        
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
