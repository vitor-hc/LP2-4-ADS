public class Author {

	protected String name;
	protected String email;
	protected char gender;

	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return this.gender;
	}

	public String toString() {
		return "Author[name="+this.name+",email="+this.email+",gender="+this.gender+"]";
	}

	
	public static void main(String[] args)
	{
		Author autor1 = new Author("Antonio","antonio.rodrdj@gmail.com",'m');
		System.out.println(autor1.toString());

		Author autor2 = new Author("Vitor","vitor_hc@hotmail.com.br",'m');
		System.out.println(autor2.toString());

		autor1.setEmail("antonio@antonio");
		autor2.setEmail("vitor@vitor");

		System.out.println("Autor 1: Name: "+autor1.getName()+" Email: "+autor1.getEmail()+" Gender: "+autor1.getGender());
		System.out.println("Autor 2: Name: "+autor2.getName()+" Email: "+autor2.getEmail()+" Gender: "+autor2.getGender());
	}
}
