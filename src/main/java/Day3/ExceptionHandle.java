package Day3;

import java.io.IOException;

public class ExceptionHandle {
    public static void main(String[] args) {
        //try, catch
//        try
//        {
//            int data=50/0; //may throw exception
//        }
//        //handling the exception
//        catch(ArithmeticException e)
//        {
//            System.out.println(e);
//        }
//        System.out.println("rest of the code");

        //finally
//        try{
////below code do not throw any exception
//            int data=25/5;
//            System.out.println(data);
//        }
////catch won't be executed
//        catch(NullPointerException e){
//            System.out.println(e);
//        }
////executed regardless of exception occurred or not
//        finally {
//            System.out.println("finally block is always executed");
//        }
//
//        System.out.println("rest of phe code...");

        //throw
//        validate(13);
//        System.out.println("rest of the code...");

        //throws
//        Testthrows1 obj=new Testthrows1();
//        obj.p();
//        System.out.println("normal flow...");

    }

    public static void validate(int age) {
        if(age<18) {
            //throw Arithmetic exception if not eligible to vote
            throw new ArithmeticException("Person is not eligible to vote");
        }
        else {
            System.out.println("Person is eligible to vote!!");
        }
    }
}


class Testthrows1 {
    void m() throws IOException {
        throw new IOException("device error");//checked exception
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
    }
}