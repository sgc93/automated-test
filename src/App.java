import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("select the website you want test: ");
        System.out.println("1. ingit (search github user and see details): ");
        System.out.println("2. garix (search movie): ");
        System.out.println("3. youtube (search video in youtube): ");
        System.out.println("4. google (search for something): ");
        System.out.println("5. have chat with AI");
        String webName = scan.nextLine();
        String query = "";
        if (!webName.toString().equals("5")) {
            System.out.println("Enter search query: ");
            query = scan.nextLine();
        }
        scan.close();

        switch (webName) {
            case "1":
                Test testIngit = new Test("ingit",  query);
                testIngit.test();
                break;
            case "2":
                Test testGarix = new Test("garix",  query);
                testGarix.test();
                break;
            case "3":
                Test testYoutube = new Test("youtube",  query);
                testYoutube.test();
                break;
            case "4":
                Test testGoogle = new Test("google",  query);
                testGoogle.test();
                break;
            case "5":
                Chat chat = new Chat();
                chat.startChat();
                break;
            default:
                System.out.println("you have entered wrong choice");
                break;
        }
    }
}
