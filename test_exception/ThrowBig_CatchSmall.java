public class ThrowBig_CatchSmall{

    public static void main(String[] args) {
        TestBigSmall t = new TestBigSmall();
        try{
            t.testThrow();
        }catch (SmallExeption se) {
            se.printDemo();
        }catch (BigException be) {
            be.printDemo();
        }
    }
}

class TestBigSmall {
    public void testThrow() throws BigException{
        throw new SmallExeption();
    }

}

class BigException extends Exception{

    public  void  printDemo(){
        System.out.println("This is Demo from BigException");
    }

}

class SmallExeption extends BigException{
    public  void printDemo(){
        System.out.println("This is Demo from SmallException");
    }
}
