public class Main {

    public static void main(String[] args) {

        Airplane airplane = new Airplane();
        int choice = 0;

        while (true)
        {
            System.out.println("-------------");
            System.out.println("1 – Start motor\n2 – Take off\n3 – Stop motor\n4 – Increase altitude\n5 – Decrease altitude\n6 – Exit");

            choice = IO.getInt();

            switch(choice) {
                case 1:
                    //airplane.start();
                    break;


            }
        }


    }



}
