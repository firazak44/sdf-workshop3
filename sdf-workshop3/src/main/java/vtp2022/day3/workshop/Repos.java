package vtp2022.day3.workshop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class Repos {
    private File repository; 
    
        public Repos(String repo){
            this.repository = new File(repo);
        }

        public List<String> getShoppingCarts(){
            List<String> carts = new LinkedList<>();
            for(String n : repository.list())
                carts.add(n.replace(".cart", ""));
            System.out.println(carts);
            return carts;
            
        }

        public void save(Cart cart){
            String cartName = cart.getUsername() + ".cart";
            System.out.println(repository.getPath());
            String saveLocation = repository.getPath() + File.separator + cartName;
            File saveFile = new File(saveLocation);
            OutputStream os = null;
            try{
                if(!saveFile.exists()){
                    System.out.println("create file");
                    
                    saveFile.createNewFile();
                }
                    

                os = new FileOutputStream(saveLocation);
                cart.save(os);
                os.flush();
                os.close();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        public Cart load(String username){
            String cartName = username + ".cart";
            Cart cart = new Cart(username);
            for(File cartFile: repository.listFiles())
                if(cartFile.getName().equals(cartName)){
                    try{
                        InputStream is = new FileInputStream(cartFile);
                        cart.load(is);
                        is.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
        return cart;
        }
}

