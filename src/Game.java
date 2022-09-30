import java.util.Scanner;

public class Game {
    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Macera Adasına Hoş geldiniz ! ");
        System.out.print("Adınızı giriniz : ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " can you survive on this adventure game full of dangers ?");
        player.selectChar();
        Location location = null;
        while (true) {
            System.out.println();
            player.getInfo();
            System.out.println();
            System.out.println("========= BÖLGELER ==========");
            System.out.println();

            System.out.println(" 1- Güvenli Ev ---> burası sizin için güvenli bir mekandır düşman yoktur.");
            System.out.println(" 2- Mağaza     ---> Silah ve zırh satın alabilirsiniz.");
            System.out.println(" 3- Mağara     ---> Mağaraya gir dikkatli ol canavar çıkabilir. ");
            System.out.println(" 4- Orman     ----> Ormana gir dikkatli ol karşına ayı çıkabilir. ");
            System.out.println(" 5- Nehir     ----> Nehire git dikkatli ol karşına vampir çıkabilir. ");
            System.out.println(" 0- Çıkış yap ");
            System.out.print("  lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selecLoc = scanner.nextInt();


            switch (selecLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location == null) {
                System.out.println(" Oyundan çıkılıyor... ");
                break;
            }
            else if(!location.onlocation()){
                System.out.println(" GAME OVER ");
                break;
            }
            location.onlocation();

        }


    }
}
