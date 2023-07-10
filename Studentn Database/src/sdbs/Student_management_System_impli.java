package sdbs;



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomeExceptions.InvalidchoiceException;
import CustomeExceptions.StudentNotFoundException;
import custom_sorting.SortStudentByAge;
import custom_sorting.SortStudentById;
import custom_sorting.SortStudentByMarks;




public class Student_management_System_impli implements Student_management_System 
{

	//Scanner
		//                  <key(id),    value>
		// Map db =lhm --> <String, student>
		
		Scanner scan =new Scanner(System.in);
		Map<String,Student> db=new LinkedHashMap<String, Student>();
		
		
		

	@Override
	     public void addStudent()
	     {  //Accept age, name,marks  2)crete student object 
		// 3) add student obj int db --> map->keuy is id,value is stud obj 4)//print the student id
		
		System.out.println("enter student age");
		int age =scan.nextInt();
		
		System.out.println("enter student name");
		String s_name=scan.next();
		
		System.out.println("enter student marks");
		int marks= scan.nextInt();
		
		
		Student std= new Student(s_name,age, marks);
		System.out.println("student record inserted succesfully");
		db.put(std.getid(),std);
		
	     }
	//========================================================================================
		
	@Override
		public void displayStudent()
		{// axxepts Student id -->jsp1010 or 
		// toUppercase
		//check if id(key) present or not-->containskey();
		// if the key id is present  --> get the value(student obj);
		
		//getage()... agename()..getmarks()
	///else customexce[tion --> student notfoundexcpeption
		// invoke it using throw key
	    System.out.println("enter the student id");
		String id=scan.next();
	    id= id.toUpperCase();  // Strig name =scan.next().toUppercase());
	    
	    if(db.containsKey(id)) {
	    Student std = db.get(id); // getting the student object
	    	System.out.println("id :"+std.getid());
	    	System.out.println("age :"+std.getage());
	    	System.out.println("marks :"+std.getmarks());
	    	System.out.println("marks :"+std.getname());
	    	
	    }
	    else {
	    	try {
				
	    		String message="Student with the id "+id+"is not Found";
	        	throw new StudentNotFoundException(message);
	    		
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    }
		}
	//====================================================================================	

	@Override
	   public	void displayAllStudent() 
	   {
		// map(db) into set -> keyset(); 2, fir each loop travers key
			// db.get(key) ->(student object )--> tostring() ->print
			if(db.size()!=0) {
			System.out.println("student details are as follows");
			System.out.println("---------------------------");
			Set<String> keys= db.keySet();//jsp101,  jsp 102, jsp103
			
				
				for(String key :keys) {
					Student std=db.get(key);
					System.out.println(std);// System.out.println(db.get(key));
				}
			}
			else {
				try {
					
		    		String message="Student adatabase is Empty,nothing to display ";
		        	throw new StudentNotFoundException(message);
		    		
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
		    }
			}
			//============================================================================
			
	@Override
		public void removeStudent()
		{   // Accept id & toUpperCase
		//if id is present --> db.remove(id);
		//else -->snfe 0. handle 
		System.out.println("enter the Student id");
		String id=scan.next().toUpperCase(); //
		
		if(id.contains(id)) {
			System.out.println("Studebnt record Found!");
			System.out.println(db.get(id));		
			db.remove(id);
			System.out.println("Student Record Deleted  Succesfully");
		}
		
		else
		{
		
			try {
				
	    		String message="Student with the id "+id+"is Not Found" ;
	        	throw new StudentNotFoundException(message);
	    		
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			
		}//else clise
		
			
		}
		//===================================================================
	@Override
		public void removeAllStudent() 
		{
			if(db.size()!=0) {
				System.out.println("Student records avilabel is"+db.size());
				db.clear();
				System.out.println("All Student REcords are deleeted");
				System.out.println("student Records Aailable  :"+db.size());
			}
			else {
				
	          try {
		    		String message="Student adatabase is Empty,nothing to Delet";
		        	throw new StudentNotFoundException(message);
		    		
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
		    }//else  close
			}
		//==================================================================================
		
	@Override
		public void updateStudent()
		{// Accepts id & convert inton Upper case
		//if id is present --> get the value(student obj);
		//display 1: update name, 2.: update age....//
		//switch ; 1: setage();  2: setName();
		//else  --> snfe
		System.out.println("Enter The Student id");
		String id =scan.next().toUpperCase();
		if(db.containsKey(id)) {
			
			Student std =db.get(id);
			
			System.out.println("1 : UpdateName");
			System.out.println("2 : UpdateAge");
			System.out.println("3 : UpdateMarks");
			
			
			System.out.println("Enter the choice");
			int choice=scan.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter the Name");
				String  name=scan.next();
				std.setname(name);  //  std.setname(scan.next());
				break;
	  
			case 2 :
				System.out.println("Enter the Age");
				int  age=scan.nextInt();
				std.setage(age);  //  std.setname(scan.next());
				break;
				
			case 3:
				System.out.println("Enter the Marks");
				int  marks=scan.nextInt();
				std.setmarks(marks);  //  std.setname(scan.next());
				break;
			
			default:
				 try {
			    		String message="Invalid choice, kindly Enter a valid choice ";
			        	throw new InvalidchoiceException(message);
			    		
					} catch (Exception e1)
				    {
						System.out.println(e1.getMessage());
					}	  
				
			}//switch
		
		}//if close
		else
		{
			 try {
		    		String message="Student id with "+id+" is Not Found";
		        	throw new StudentNotFoundException(message);
		    		
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}	
		}//else close
		
		}
	//===========================================================================	

	@Override
		public void countStudent() {
		System.out.println("no of Student records :"+db.size());
		}
	//==================================================================================	

	@Override
		public void sotStudent() 
	  {
		//map into set -->ketSet()-->keys
		//List list =new AL();--> Student obj  -->generics
		//foor each loop --> traverse keys-->
		// get the values (Student obj) & add it into AL
		
		//display 1 : sort byid , 2: soort by age....
		//switch --. Collections.sort(list,new SortStudentByid());
		// travers
		
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		
		List<Student> list= new ArrayList<Student>();
		
		  for(String key : keys) 
		 {
			  list.add(db.get(key)); 	
		 }
		  
		  System.out.println("enter the choice to sort");
		//-------------------------------------------
		  System.out.println("1 : Sort Student by id");
		  System.out.println("2 : Sort Student by name");
		  System.out.println("3 : Sort Student by age");
		  System.out.println("4 : Sort Student by marks");
		//----------------------------------------
		  int choice =scan.nextInt();
		  
		  
		  
		  
		  switch (choice) {
		  
		case 1:
			Collections.sort(list,new SortStudentById()); 
			 display(list);
			break;
			
	    case 2:
		    Collections.sort(list,new SortStudentById()); 
		     display(list);
			  break;
			
	     case 3:
		      Collections.sort(list,new SortStudentByAge()); 
		      display(list);
		      break;
		
	      case 4:
		     Collections.sort(list,new SortStudentByMarks()); 
		     display(list);
	        	//	for(Student s: list)
	        //	{
	      //		System.out.println(s);
	       //	}
		break;


		default:
			try {
				throw new  InvalidchoiceException("invalid choice");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				updateStudent();
			}
			break;
			
		}//switch
		  
		}
		else
		{
						try {
					throw new  StudentNotFoundException("no sufficient records to compre");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					updateStudent();
				}	
		}//else closed
		   
		}

	   private static void display(List<Student>list) {
			for(Student s: list)
		    {
		      		System.out.println(s);  //this is common method in switch statement so instead of calling in
		      		// every switch case make it method and call in the switch casess
		   	}   
	        }
	   


	//=================================================================================

	@Override
		public void getStudentWithHighesMaarks() {
			if(db.size()>= 2) {
		Set<String> keys =db.keySet();
		List<Student> list1 =new ArrayList<Student>();
		for(String key : keys)
		{
			list1.add(db.get(key));
		}
		Collections.sort(list1,new SortStudentById());
		System.out.println(list1.get(list1.size()-1));
		
		}
	else
	{
		try {
			throw new  StudentNotFoundException("no sufficient records to compre");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			updateStudent();
		}	
		}// else close
	} // method close
	//=======================================================================================	

	@Override
		public void getStudentWithLowesMaarks() {
			if(db.size() >=2) {
		Set<String> keys =db.keySet();
		List<Student> list =new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
		
		
		}
			
			else
			{
				try {
					throw new  CustomeExceptions.StudentNotFoundException("no sufficient records to compre");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					updateStudent();
				}	
			
	}
		//=====================================================
	}
	}
	  

	//comparartor provid multiple soting 
	//comparable --> override compareto();
	//compare ---> override compre();

	
	
