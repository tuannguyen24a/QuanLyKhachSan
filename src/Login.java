import java.io.IOException;
import java.text.ParseException;

public class Login {
    public static void main(String[] args) throws IOException, ParseException {  
        listAccount a = new listAccount();
        a.docFile();
        account b = new account();
        b = a.log();
      //  a.deleteAll();
        menu.Main(b.getMa_tk(),b.getQuyen());
        a.Menu_END();
    }
}
