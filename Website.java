import java.util.Scanner;
import java.util.ArrayList;

public class Website {
	
	ArrayList<String> fName = new ArrayList<>();
	ArrayList<String> lName = new ArrayList<>();
	ArrayList<Integer> age = new ArrayList<>();
	ArrayList<String> email = new ArrayList<>();
	ArrayList<String> phoneNumber = new ArrayList<>();
	ArrayList<String> music = new ArrayList<>();
	ArrayList<String> gender = new ArrayList<>();
	ArrayList<ArrayList<String>> messages = new ArrayList<>();
	ArrayList<String> passwords = new ArrayList<>();
	
	String user;
	boolean loggedIn;
	int x = 0;
	int q = 0;
	
	public void login() throws InterruptedException {
		Scanner log = new Scanner(System.in);
		System.out.println("           Welcome\n");
		Thread.sleep(2000);
		System.out.println("For existing user, enter 1 to login.\nFor new user, enter 2 to create a profile.");
		String choice = log.next();
		if (choice.equals("1")) {
			System.out.println("Welcome back");
			Thread.sleep(2000);
			System.out.print("Input Email: ");
			String emaily = log.next();
			Thread.sleep(2000);
			if (email.contains(emaily)) {
				System.out.println("Found " + fName.get(email.indexOf(emaily)) + "\n");
				Thread.sleep(2000);
				System.out.print("Input Password for " + email.get(email.indexOf(emaily)) + ": ");
				String pass = log.next();
				if (pass.equals(passwords.get(email.indexOf(emaily)))) {
					System.out.println("Welcome back, " + fName.get(email.indexOf(emaily)));
					user = fName.get(email.indexOf(emaily));
					loggedIn = true;
					//Thread.sleep(1000);
					//ArrayList<String> messag = messages.get(messages.indexOf(x));
					//System.out.println("You have " + messag.size() + " new messages.");
					Thread.sleep(2000);
					//for (int i = 0; i <= messages.size(); i++) {
						//System.out.println(messages.get(messages.indexOf(x)));
					System.out.println(messages.get(messages.indexOf(q)));
					//}
					Thread.sleep(5000);
					this.menu();
				} else {
					System.out.println("Incorrect password");
					loggedIn = false;
					Thread.sleep(2000);
					this.login();
				}
			} else {
				System.out.println("We did not find that user");
				Thread.sleep(2000);
				this.login();
			}
		} else if (choice.equals("2")) {
			this.info();
		} else {
			System.out.println("Invalid option");
			Thread.sleep(2000);
			this.menu();
		}
	}
	
	public void menu() throws InterruptedException {
		Scanner menu = new Scanner(System.in);
		System.out.println("	Menu\n\nEnter '1' to Add Profile\nEnter '2' to Search Profiles\nEnter '3' to Login to existing user\nEnter '4' to send a Message to someone\n");
		System.out.print("Input: ");
		Integer option = menu.nextInt();
		if (option == 1) {
			this.info();
		} else if (option == 2) {
			this.search();
		} else if (option == 3){
			this.login();
		} else if (option == 4) {
			this.message();
		} else {
			System.out.println("The chosen option is not valid.");
		}
	}
	
	public void info() throws InterruptedException {
		//Take input from user
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		//Questions
		System.out.println("What is your first name?");
		String namey = scan.next();
		fName.add(namey);
		System.out.println("What is your last name?");
		String lname = scan.next();
		lName.add(lname);
		System.out.println("What is your age?");
		int agey = scan.nextInt();
		age.add(agey);
		System.out.println("What is your email?");
		String emaily = scan.next();
		email.add(emaily);
		System.out.println("What is your phone number?(In the form of (000)000-0000)");
		String pn = scan.next();
		phoneNumber.add(pn);
		System.out.println("What is you favorite type of music?");
		String muzic = scan1.nextLine();
		music.add(muzic);
		System.out.println("What is your gender?");
		String gende = scan1.nextLine();
		gender.add(gende);
		System.out.println("What is your new password?");
		String pass = scan.next();
		System.out.print("Verify your password: ");
		String pass1 = scan.next();
		int x = fName.indexOf(namey);
		if (pass.equals(pass1)) {
			passwords.add(pass1);
		} else {
			System.out.println("Passwords do not match");
			Thread.sleep(2000);
			fName.remove(x);
			lName.remove(x);
			age.remove(x);
			email.remove(x);
			phoneNumber.remove(x);
			music.remove(x);
			gender.remove(x);
			this.info();
		}
		
		//Wait 2 seconds
		Thread.sleep(2000);
		
		//Prints out details
		System.out.println("Name: " + fName.get(fName.size() - 1) + " " + lName.get(lName.size() - 1));
		System.out.println("Email: " + email.get(email.size() - 1));
		System.out.println("Age: " + age.get(age.size() - 1));
		System.out.println("Gender: " + gender.get(gender.size() - 1));
		System.out.println("Phone Number: " + phoneNumber.get(phoneNumber.size() - 1));
		System.out.println("Favorite type of music: " + music.get(music.size() -1));
		Thread.sleep(5000);
		this.menu();
	}
	
	public void search() throws InterruptedException {
		Scanner search = new Scanner(System.in);
		System.out.println("Please search for the first name of the person.");
		String searchname = search.next();
		if (fName.contains(searchname)) {
			System.out.println("Name: " + fName.get(fName.indexOf(searchname)) + " " + lName.get(fName.indexOf(searchname)));
			System.out.println("Email: " + email.get(fName.indexOf(searchname)));
			System.out.println("Age: " + age.get(fName.indexOf(searchname)));
			System.out.println("Gender: " + gender.get(fName.indexOf(searchname)));
			System.out.println("Phone Number: " + phoneNumber.get(fName.indexOf(searchname)));
			System.out.println("Favorite type of music: " + music.get(fName.indexOf(searchname)));
			Thread.sleep(3000);
		} else {
			System.out.println("Sorry, you either have typed it incorrectly, or \nthe indicated person is not entered in our database.");
			Thread.sleep(1000);
			this.menu();
		} this.menu();
	}
	
	public void message() throws InterruptedException {
		Scanner mess = new Scanner(System.in);
		System.out.println("Here you can send messages to your friends");
		Thread.sleep(2000);
		System.out.println("Who would you like to send a message to?\nInput first name");
		System.out.print("Input: ");
		String searchname = mess.nextLine();
		if (fName.contains(searchname)) {
			System.out.println("To: " + fName.get(fName.indexOf(searchname)));
			System.out.println("From: " + user);
			System.out.print("Message: ");
			String message = mess.nextLine();
			for (q = x; q < 1; q++) {
				ArrayList<String> messa = new ArrayList<String>();
				messages.add(q, messa);
				messa.add(message);
				x = q;
				Thread.sleep(2000);
				this.menu();
					/*messages.add(messages.indexOf(i), new ArrayList<String>(i));
					ArrayList<String> test = messages.get(messages.indexOf(i));
					test = new ArrayList<>();
					test.add(message);
					
					Node childNode =  PropertyNode.item(i);
	                NodeList Children = childNode.getChildNodes();

	                if(Children!=null){
	                    nodes.clear();
	                    nodes.add("PropertyStart");
	                    nodes.add(Children.item(3).getTextContent());
	                    nodes.add(Children.item(7).getTextContent());
	                    nodes.add(Children.item(9).getTextContent());
	                    nodes.add(Children.item(11).getTextContent());
	                    nodes.add(Children.item(13).getTextContent());
	                    nodes.add("PropertyEnd");

	                }   
	                NodeList.addAll(nodes);
	                list.add(NodeList);
	                */
			}
				// method 1?
				/*if (messages.contains(user)) {
					ArrayList user1 = messages.get(messages.indexOf(user));
					user1.add(message);
				} else {
					ArrayList username = null;
					username.add(message);
					messages.add(username);
				}
				*/
				// method 2?
				/*for (ArrayList u : messages) {
					if (u.equals(user)) {
						u.add(message);
					} else {
						messages.add(u);
						u.add(message);
					}
				}
				*/
				Thread.sleep(2000);
				this.login();
			}
			else if(!fName.contains(searchname)){
				System.out.println("Sorry, you either have typed it incorrectly, or \nthe indicated person is not entered in our database.");
				Thread.sleep(1000);
				this.menu();
			}
			else {
				System.out.println("Sorry, you either have typed it incorrectly, or \nthe indicated person is not entered in our database.");
				Thread.sleep(1000);
				this.menu();
			}
		}

	public static void main(String[] args) throws InterruptedException {
		new Website().menu();
	}

}
