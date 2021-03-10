package CollectionApiCoreJava;

public class Person {

	private int age;
	private String name;
	
	Person( int age, String name)
	{
		 this.name= name;
		 this.age= age;
	}
	
	public String getName( )
	{
		 return this.name;
		 
	}
	
public int getAge()
{
	 return this.age;
}
public void setName(String name)
{
	 this.name= name;
}

public void setAge(int age)
{
	 this.age= age;
}

}
