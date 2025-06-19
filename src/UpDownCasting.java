public class UpDownCasting {
    public static void main(String[] args) {

        //Up Casting (Child -> Parent)
        Animal animal = new Dog();
        animal.sound();
//        animal.walk()  //Error

        //Down Casting (Parent -> child)
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.walk();
        }

    }
}
class Animal {
    void sound() {
        System.out.println("Animal Sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Dog Sound");
    }
    void walk() {
        System.out.println("Dog Walk");
    }
}