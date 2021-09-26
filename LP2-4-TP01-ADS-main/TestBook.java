import java.util.Arrays;

public class TestBook {
  public static void main(String[] args)
	{
    Author[] authors = new Author[2];
    authors[0] = new Author("Antonio","antonio.rodrdj@gmail.com",'m');
    authors[1] = new Author("Vitor","vitor_hc@hotmail.com.br",'m');

    Book theBook = new Book("O livro", authors, 50.5, 59);

    System.out.println("Name: "+theBook.getName());
    System.out.println("Price: "+theBook.getPrice());
    System.out.println("Qty: "+theBook.getQty());
    System.out.println("Authors Array: "+ Arrays.toString(theBook.getAuthors()));
    System.out.println("Authors names: "+theBook.getAuthorNames());
    System.out.println("Book: "+theBook.toString());


    theBook.setPrice(100.99);
    theBook.setQty(200);

    System.out.println("Price: "+theBook.getPrice());
    System.out.println("Qty: "+theBook.getQty());

    System.out.println("============================");
      Student student = new Student("Antonio","antonio.rodrdj@gmail.com","ADS",25,2.30);
      System.out.println(student.toString());

      Staff staff = new Staff("Vitor","vitor_hc@hotmail.com.br","IFSP-Cubatão",200 );
      System.out.println(staff.toString());




  }
}
