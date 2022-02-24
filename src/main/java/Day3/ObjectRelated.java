package Day3;

public class ObjectRelated {
    public static void main(String[] args) {
        //new
//        NewExample1 obj=new NewExample1();
//        obj.display();

        //instanceof
//        Dog d=new Dog();
//        System.out.println(d instanceof Animal);//true

        //super
//        Dog d=new Dog();

        //this
//        Student s1=new Student(111,"ankit",5000f);
//        Student s2=new Student(112,"sumit",6000f);
//        s1.display();
//        s2.display();
    }
}

class NewExample1 {
    void display() {
        System.out.println("Invoking Method");
    }
}

class Animal{
    Animal(){System.out.println("animal is created");}
}
class Dog extends Animal{
    Dog(){
        super();
        System.out.println("dog is created");
    }
}

class Student{
    int rollno;
    String name;
    float fee;
    Student(int rollno,String name,float fee){
        this.rollno=rollno;
        this.name=name;
        this.fee=fee;
    }
    void display(){System.out.println(rollno+" "+name+" "+fee);}
}