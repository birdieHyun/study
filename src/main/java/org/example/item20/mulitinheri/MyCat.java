package org.example.item20.mulitinheri;

public class MyCat extends AbstractCat implements Flyable {

    private MyFlyable myFlyable = new MyFlyable();

    @Override
    protected String sound() {
        return "인싸 고양이 두마리가 나가신다.";
    }

    @Override
    protected String name() {
        return "유미";
    }

    @Override
    public void fly() {
        this.myFlyable.fly();
    }

    private class MyFlyable extends AbstractFlyable {

        @Override
        public void fly() {
            System.out.println("날아라.");
        }
    }

    public static void main(String[] args) {
        MyCat myCat = new MyCat();
        System.out.println(myCat.sound());
        System.out.println(myCat.name());
        myCat.fly();
    }

}
