public class Prueba {

    int n1=1;
    int n2=0; 
    int n3=0;


    public int prueba (int n){
        for (int i = 0; i < 5; i++){
            n3 = n1 + n2;
            n1 = n3 + n2;
        }
        return n;
    }
    
}
