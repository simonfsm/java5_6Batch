package Day3;

public class modifier {
    public static void main(String[] args) {
        //public
//        A a=new A("Try to create the instance of public constructor outside the class");
//        System.out.println(a.msg);
//        a.display();

        //private
//        B b = new B();
//        System.out.println(b.msg);

        //abstract
//        Honda obj=new Honda();
//        obj.bike();

        //Synchronized
//        Table obj = new Table();//only one object
//        MyThread1 t1=new MyThread1(obj);
//        MyThread2 t2=new MyThread2(obj);
//        t1.start();
//        t2.start();
    }
}

class Table{
    synchronized void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

class A {

    public String msg="Try to access a public variable outside the class";
    String info;
    public void display()
    {
        System.out.println("Try to access a public method outside the class");
        System.out.println(info);
    }

    public A(String info)
    {
        this.info=info;
    }

}

class B
{
    private String msg = "Try to access the private variable outside the class";

}

abstract class Vehicle
{
    abstract void bike();

}
class Honda extends Vehicle
{

    @Override
    void bike() {
        System.out.println("Bike is running");

    }

}
