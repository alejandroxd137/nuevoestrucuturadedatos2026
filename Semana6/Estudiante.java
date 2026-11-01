package Semana6;
import java.util.*;
 
public class Estudiante {
 
    public static void main(String[] args) {
 
        Map<Integer, String> estudiantes = new HashMap<>();
        estudiantes.put(856589, "Tom Cruz");
        estudiantes.put(547821, "Tom Holland");
        estudiantes.put(698536, "Hanna Montana");
        System.out.println(estudiantes.size()); //3
        System.out.println(estudiantes.isEmpty()); //false
        System.out.println(estudiantes); 
        //{856589=Tom Cruz, 698536=Hanna Montana, 547821=Tom Holland}
        System.out.println(estudiantes.containsKey(547821)); //true
        System.out.println(estudiantes.containsValue("Tom Holland")); //true
        System.out.println(estudiantes.remove(547821));
        System.out.println(estudiantes);
        System.out.println(estudiantes.replace(856589, "Tom Holland"));
        System.out.println(estudiantes);
 
        for (Integer key : estudiantes.keySet()) {
            System.out.println("Clave: " + key + " --> Valor: " + estudiantes.get(key));
        }
        /*
        Iterator est = estudiantes.keySet().iterator();
        while(est.hasNext()){
        Integer key = (Integer) est.next();
        System.out.println("Clave: " + key + " Valor: " + estudiantes.get(key));
        }
        */        
    }    
}