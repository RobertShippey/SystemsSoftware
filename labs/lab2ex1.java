
public class lab2ex1 {
    
    public static void main (String[] args){
        
        if(args.length!=3){
            System.err.println("Incorrect usage: -[a,m,s,d] 1 2");
        } else {

            String op = args[0];
            float x = Float.parseFloat(args[1]);
            float y = Float.parseFloat(args[2]);
            float z;
            
            System.out.println(op);
            System.out.println(x);
            System.out.println(y);
            
            if(op.equals("-a")){
                z = x+y;
                System.out.println(z);
            }else if(op.equals("-m")) {
                z = x*y;
                System.out.println(z);    
            }else if(op.equals("-s")) {
                z = x-y;
                System.out.println(z);    
            }else if(op.equals("-d")) {
                z = x/y;
                System.out.println(z);
            } else {
                System.err.println("Something bad happened");
            }
            
        }
    }
    
}