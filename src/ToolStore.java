public class ToolStore extends NormLoc {
    public ToolStore(Player player) {
        super(2,player, "MAĞAZA");
    }

    public boolean onlocation() {
        System.out.println("mağazaya hoş geldiniz");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silah");
            System.out.println("2- Zırh");
            System.out.println("3- Çıkış yap");
            System.out.print("Seçiminiz : ");

            int selecCase = Location.scanner.nextInt();

            while (selecCase < 1 || selecCase > 3) {
                System.out.print("Geçersiz bir değer girdiniz lütfen tekrar giriniz : ");

            }
            switch (selecCase) {
                case 1:
                    printWeapon();
                    byWeapon();
                    break;
                case 2:
                    printArmor();
                    byArmor();
                    break;
                case 3:
                    System.out.println("Mağazadan çıkış yaptınız bir daha bekleriz.");
                    showMenu = false;
                    break;
            }


        }
        return true;
    }


    public void printWeapon() {
        System.out.println(" Silahlar ");
        System.out.println();

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " Para : " + w.getPrice());

        }
        System.out.println(" 0- Çıkış yap ");
    }

    public void byWeapon() {
        System.out.println(" lütfen bir silah seçiniz : ");
        int selectedWeaponId = scanner.nextInt();
        while (selectedWeaponId < 0 || selectedWeaponId > Weapon.weapons().length) {
            System.out.println(" geçersiz bir seçim yaptınız , tekrar deneyiniz  ");
            selectedWeaponId = scanner.nextInt();


        }
        if(selectedWeaponId !=0 ){
            //buradan aşağı seçtiğimiz silahı artık alabiliyor olmamız için aşağıdan devam ettik
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectedWeaponId);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMony()) {
                    System.out.println(" Yeterli paranız bulunmamaktadır. Çıkış yapmak için 3' butonuna basın.");

                } else {
                }

                System.out.println(selectedWeapon.getPrice() + " TL' lik silah satın aldınız ");
                //satın alma işleminin gerçekleştiği alan
                int balance = this.getPlayer().getMony() - selectedWeapon.getPrice();
                this.getPlayer().setMony(balance);
                System.out.println(" kalan paranız " + this.getPlayer().getMony());
                System.out.println("önceki silahınız " + getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("yeni  silahınız " + getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }

        }





    }


    public void printArmor() {

        System.out.println("------Zırhlar---------");
        System.out.println();

        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " Para : " + a.getPrice() + " Zırh : " + a.getBlock());

        }
    }

    public void byArmor() {
        System.out.println("Lütfen bir zırh seçiniz :");
        int selecetedArmorId = scanner.nextInt();


        Armor selectedArmorId = Armor.getArmorObjById(selecetedArmorId);
        while (selecetedArmorId < 1 || selecetedArmorId > Armor.armors().length) {
            System.out.println("Geçersiz bir sayı girdiniz lütfen tekrar deneyiniz ");
            selecetedArmorId = scanner.nextInt();
        }
        if (selectedArmorId != null) {
            if (selectedArmorId.getPrice() > this.getPlayer().getMony()) {
                System.out.println("Yeterli paranız bulunamamaktadır.");
            } else {
                System.out.println(selectedArmorId.getName() + "zırhını satın aldınız");
                int balance = this.getPlayer().getMony() - selectedArmorId.getPrice();
                this.getPlayer().setMony(balance);
                this.getPlayer().getInventory().setArmor(selectedArmorId);
                System.out.println(" kalan bakiye " + this.getPlayer().getMony());
            }


        }
    }


    public void menu() {

    }

    public void buyArmor() {

    }

}
