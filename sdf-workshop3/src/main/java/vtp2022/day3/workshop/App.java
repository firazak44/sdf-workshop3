package vtp2022.day3.workshop;

public class App 
{
    private static String defaultDB="db";
    public static void main( String[] args ){
        if(args.length > 0)
            if(args[0] != null){
                System.out.println( args[0] );
                App.defaultDB = args[0];
            }
        System.out.println( defaultDB );
        Repos repo = new Repos(defaultDB);
        Session session = new Session(repo);
        session.start();
    }

}
