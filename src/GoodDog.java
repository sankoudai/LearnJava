class GoodDog{
    private int size;

    public int getSize(){
        return size;
    }

    public void setSize(int s){
        size = s;
    }


    public  void bark(){

        if(size > 60){
            System.out.println("Woof Wroof!");
        }else if(size > 14){
            System.out.println("Ruff Ruff!");
        }else {
            System.out.println("Yip Yip!");
        }
    }
}


