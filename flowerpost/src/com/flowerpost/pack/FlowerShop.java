package com.flowerpost.pack;

import java.util.*;

public class FlowerShop {
    //Atrybuty Klasy\\
    public final Address flowerShopAddress;
    public final String phoneNumber;
    Flowers[] stock = new Flowers[0];
    Order[] stockOrders = new Order[0];

    //Gettery i Settery\\
    public Address getFlowerShopAddress() {
        return flowerShopAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Flowers[] getStock() {
        return stock;
    }

    //Konstruktor\\\
    public FlowerShop(Address flowerShopAddress, String phoneNumber) {
        this.flowerShopAddress = flowerShopAddress;
        this.phoneNumber = phoneNumber;
    }

    //Metoda dodająca pozycję do magazynu zamówień\\
    public void addFlowerToStockOrders(Order order){
        int newArraySize = this.stockOrders.length + 1;
        Order[] biggerArray = new Order[newArraySize];
        System.arraycopy(this.stockOrders, 0, biggerArray, 0, stockOrders.length);
        biggerArray[newArraySize - 1] = order;
        this.stockOrders = biggerArray;
    }

    //Metoda dodająca pozycję do magazynu kwiatów\\
    public void addFlowerToStock(Flowers flowersObject) {
        int newArraySize = this.stock.length + 1;
        Flowers[] biggerArray = new Flowers[newArraySize];
        System.arraycopy(this.stock, 0, biggerArray, 0, stock.length);
        biggerArray[newArraySize - 1] = flowersObject;
        this.stock = biggerArray;
    }

    //Metoda usuwająca pozycję z magazynu o określonym id\\
    public void removeFlowerObjectFromStock(String id) {
        for (int i = 0; i < this.stock.length; i++) {
            if (Objects.equals(stock[i].id, id)) {
                for (int j = i; j < this.stock.length -1;j++){
                    this.stock[j] = this.stock[j+1];
                }
                Flowers[] newStock = new Flowers[this.stock.length -1];
                System.arraycopy(this.stock,0,newStock,0,this.stock.length-1);
                this.stock = newStock;
            }
        }
    }

    //Metoda usuwająca kawiaty z obiektu zawartego w liście, spełniającego minimum zawarte w opisie\\
    public void removeFlowerFromAvailableStockObject(Flowers flowers) {
        for (Flowers flowersStocked : this.stock) {
            if (Objects.equals(flowersStocked.name, flowers.name)
                    && Objects.equals(flowersStocked.colour, flowers.colour)
                    && Objects.equals(flowersStocked.availability, flowers.availability)
                    && Objects.equals(flowersStocked.availability, true)
                    && (flowersStocked.quantity >= flowers.quantity)) {
                flowersStocked.quantity = flowersStocked.quantity - flowers.quantity;
                break;
            }
        }
    }

    //Metoda sprawdzająca czy jest na stanie Obiekt kwiat o danym ID\\
    public int checkFlowerFromStockObjectForID(int id) {
        for (int i = 0; i < this.stock.length; i++) {
            if (Objects.equals(stock[i].id, String.valueOf(id))){
                return i;
            }
        }
        return 9999;
    }

    //Metoda utylizująca przeterminowane kwiaty\\
    public String utilize(){
        Date today = new Date();
        Flowers[] utilizedFlowers = new NaturalFlower[0];
        Flower dateFlower = new Flower("date", "date", 0,"19970101");
        for (Flowers flowers : stock) {
            if (!Objects.equals(flowers.disposalDate.toString(), dateFlower.disposalDate.toString())) {
                if ((flowers).getDisposalDate().before(today)) {
                    int newArraySize = utilizedFlowers.length + 1;
                    Flowers[] biggerUtylizedFlowers = new Flowers[newArraySize];
                    System.arraycopy(utilizedFlowers, 0, biggerUtylizedFlowers, 0, utilizedFlowers.length);
                    biggerUtylizedFlowers[newArraySize - 1] = (flowers);
                    utilizedFlowers = biggerUtylizedFlowers;

                    flowers.setAvailability(false);
                }
            }
        }
        return (Arrays.toString(utilizedFlowers));
    }

    //Metoda "realizująca dostawę" czyli przenosząca obiekty Flower z deliveryItems do stock i zmieniająca avalibility na true.
    //*TODO* [ ]  Dodać błąd kiedy próbuje się zrealizować dostawę nie w tej kwiacierni.
    //*TODO* [X]  Zmienić działanie funkcji, aby jedynie zmieniała dostępność anego obiektu Flower w magazynie, zmieana do późniejszej implementacji raport\\
    public void addDelivery(Delivery delivery){
        int ammountOfItems = delivery.deliveryItems.length;
        for(Flowers item : delivery.deliveryItems){
            this.addFlowerToStock(item);
        }
    }

    //Metoda zmieniająca dostępność kwiatów z dzisiejszych dostaw\\//*TODO* [X] Nie działa, naprawić trzebas
    public String checkDelivery(){
        Date today = new Date();
        Flowers[] deliveredFlowers = new Flowers[0];
        for (Flowers flowers : stock) {
            if ((flowers).getDeliveryDate().before(today) || (flowers).getDeliveryDate().equals(today)) {
                int newArraySize = deliveredFlowers.length + 1;
                Flowers[] biggerDeliveredFlowers = new Flowers[newArraySize];
                System.arraycopy(deliveredFlowers, 0, biggerDeliveredFlowers, 0, deliveredFlowers.length);
                biggerDeliveredFlowers[newArraySize - 1] = ((Flowers) flowers);
                deliveredFlowers = biggerDeliveredFlowers;

                flowers.setAvailability(true);
            }
        }
        return (Arrays.toString(deliveredFlowers));
    }

    //*TODO* [X] Metoda "realizująca zamówienie\\ czyli na podstawie parametrów tworząca obiekt zamówienia i usuwająca kwiaty z magazynu.\\
    //*TODO* [~] Jeśli nie ma wystarczającej ilości, zwracany jest błąd.\\

    public void createOrder(){
        Date orderSubmitDateUtil = new Date();
        java.sql.Date orderSubmitDateSql = new java.sql.Date(orderSubmitDateUtil.getTime());
        String orderExecutionDate;
        String postalCode;
        String townName;
        String streetName;
        String buildingNumber;
        String noteToOrder;
        String noteToReceiver;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPodaj date wykonania zamówienia w formacie RRRRMMDD:\t");
        orderExecutionDate = scanner.nextLine();
        System.out.println("\nPodaj kod pocztowy do zamówienia:\t");
        postalCode = scanner.nextLine();
        System.out.println("\nPodaj nazwę miasta do zamówienia:\t");
        townName = scanner.nextLine();
        System.out.println("\nPodaj nazwę ulicy do zamówienia:\t");
        streetName = scanner.nextLine();
        System.out.println("\nPodaj numer budynku do zamówienia:\t");
        buildingNumber = scanner.nextLine();
        System.out.println("\nPodaj notę dla dostawcy(zostaw puste jeśli bez):\t");
        noteToOrder = scanner.nextLine();
        System.out.println("\nPodaj notę dla odbiorcy(zostaw puste jeśli bez):\t");
        noteToReceiver = scanner.nextLine();
        Order order = new Order("20201212", orderExecutionDate, postalCode, townName, streetName, buildingNumber, noteToOrder, noteToReceiver);
        order.orderSubmitDate = orderSubmitDateSql;
        boolean running = true;
        boolean buquetRunning = true;
        Flower dateFlower = new Flower("date", "date", 0,"19970101");
        int option;
        int buquetOption;
        int chosenID;
        int stockIndex;
        int buquetFlowersQuantity;
        while (running) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj kwiat do zamówienia.");
            System.out.println("2. Dodaj bukiet do zamówienia.");
            System.out.println("3. Zakończ składanie zamówienia i je wykonaj.");
            System.out.println("4. Zakończ składanie zamówienia i je usuń.");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.println("Wybierz id kwiatu który zostanie dodany do zamówienia.");
                    for (Flowers flowers : stock) {
                        if (flowers.availability) {
                            System.out.println("\nNazwa: " + flowers.name + "\tKolor: " + flowers.colour + "\tCena: " + flowers.price + "\tDostępna ilość:" + flowers.quantity + "\tID: " + flowers.id);
                        }
                    }
                    chosenID = Integer.parseInt(scanner.nextLine());
                    stockIndex = checkFlowerFromStockObjectForID(chosenID);
                    if (Objects.equals(this.stock[stockIndex].disposalDate.toString(), dateFlower.disposalDate.toString())) {
                        Flowers tempSynthethicFlower = this.stock[stockIndex].clone();
                        tempSynthethicFlower.setQuantity(1);
                        order.addFlowersToOrder(tempSynthethicFlower);
                    } else {
                        Flowers tempNaturalFlower = this.stock[stockIndex].clone();
                        tempNaturalFlower.setQuantity(1);
                        order.addFlowersToOrder(tempNaturalFlower);
                    }
                    this.stock[stockIndex].removeQuantity(1);
                    if (this.stock[stockIndex].quantity == 0) {
                        removeFlowerObjectFromStock(String.valueOf(chosenID));
                    }
                }
                case 2 -> {
                    buquetRunning = true;
                    FlowersBouquet bouquetOrdered = new FlowersBouquet();
                    while (buquetRunning) {
                        System.out.println("Wybierz opcję:");
                        System.out.println("1. Dodaj kwiaty do bukietu.");
                        System.out.println("2. Skończ tworzyć bukiet i dodaj do zamówienia.");
                        buquetOption = Integer.parseInt(scanner.nextLine());
                        switch (buquetOption) {
                            case 1 -> {
                                System.out.println("Wybierz id kwiatu który zostanie dodany do bukietu.");
                                for (Flowers flowers : stock) {
                                    if (flowers.availability) {
                                        System.out.println("\nNazwa: " + flowers.name + "\tKolor: " + flowers.colour + "\tCena: " + flowers.price + "\tDostępna ilość:" + flowers.quantity + "\tID: " + flowers.id);
                                    }
                                }
                                chosenID = Integer.parseInt(scanner.nextLine());
                                stockIndex = checkFlowerFromStockObjectForID(chosenID);
                                System.out.println("Podaj ilość kwiatów:");
                                buquetFlowersQuantity = Integer.parseInt(scanner.nextLine());
                                if (Objects.equals(this.stock[stockIndex].disposalDate.toString(), dateFlower.disposalDate.toString())) {
                                    Flowers tempSynthethicFlower = this.stock[stockIndex].clone();
                                    tempSynthethicFlower.quantity = buquetFlowersQuantity;
                                    boolean temp = true;
                                    for(Flowers item : bouquetOrdered.bouquet){
                                        if(Objects.equals(item.id, tempSynthethicFlower.id)){
                                            item.addQuantity(buquetFlowersQuantity);
                                            temp = false;
                                        }
                                    }
                                    if(temp){
                                        bouquetOrdered.addFlower(tempSynthethicFlower);
                                    }
                                } else {
                                    Flowers tempNaturalFlower = this.stock[stockIndex].clone();
                                    tempNaturalFlower.quantity = buquetFlowersQuantity;
                                    boolean temp = true;
                                    for(Flowers item : bouquetOrdered.bouquet){
                                        if(Objects.equals(item.id, tempNaturalFlower.id)){
                                            item.addQuantity(buquetFlowersQuantity);
                                            temp = false;
                                        }
                                    }
                                    if(temp){
                                        bouquetOrdered.addFlower(tempNaturalFlower);
                                    }
                                }
                                this.stock[stockIndex].removeQuantity(buquetFlowersQuantity);
                                if (this.stock[stockIndex].quantity == 0) {
                                    removeFlowerObjectFromStock(String.valueOf(chosenID));
                                }
                                System.out.println("Kwiaty w twoim bukiecie:");
                                for (Flowers flowers : bouquetOrdered.bouquet) {
                                    System.out.println(flowers.quantity + " " + flowers.name + " " + flowers.colour);
                                }
                            }
                            case 2 -> {
                                order.addBouquetToOrder(bouquetOrdered);
                                buquetRunning = false;
                                System.out.println("Dodano bukiet do zamówienia.");
                            }
                        }
                    }
                }
                case 3 -> {
                    running = false;
                    this.addFlowerToStockOrders(order);
                    System.out.println("Dodano zamówienie do realizacji.");
                }
                case 4 -> {
                    running = false;
                    order.clearOrder();
                    System.out.println("Zamówienie usunięte.");
                }
            }
        }
    }

    public void createDelivery(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPodaj zaplanowaną date otrzymania dostawy w formacie RRRRMMDD:\t");
        String deliveryDate = scanner.nextLine();
        System.out.println("\nPodaj kod pocztowy do zamówienia:\t");
        String postalCode = scanner.nextLine();
        System.out.println("\nPodaj nazwę miasta do zamówienia:\t");
        String townName = scanner.nextLine();
        System.out.println("\nPodaj nazwę ulicy do zamówienia:\t");
        String streetName = scanner.nextLine();
        System.out.println("\nPodaj numer budynku do zamówienia:\t");
        String buildingNumber = scanner.nextLine();
        System.out.println("\nPodaj numer telefonu kwiaciatni do której jest dostawa:\t");
        String phoneNumberFlowerShop = scanner.nextLine();
        Delivery delivery = new Delivery(deliveryDate,postalCode,townName,streetName,buildingNumber,phoneNumberFlowerShop);
        boolean running = true;
        int option;
        int option2;
        while (running){
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj pozycję do dostawy.");
            System.out.println("2. Zatwierdź dostawę i zakończ.");
            System.out.println("3. Usuń dostawę i zakończ.");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.println("\nWybierz rodzaj kwiatów:\t");
                    System.out.println("1. Kwiat sztuczny\t\t2. Kwiat naturalny");
                    option2 = Integer.parseInt(scanner.nextLine());
                    System.out.println("\nDodaj nazwe kwiatów:\t");
                    String flowersName = scanner.nextLine();
                    System.out.println("\nDodaj kolor kwiatów:\t");
                    String flowersColor = scanner.nextLine();
                    System.out.println("\nDodaj ilość kwiatów:\t");
                    int flowersQuantity = Integer.parseInt(scanner.nextLine());
                    System.out.println("\nDodaj cene jednego kwiatu:\t");
                    float flowersPriceOfOne = Float.parseFloat(scanner.nextLine());
                    if (option2 == 1) {
                        System.out.println("\nPodaj materiał z którego są sztuczne kwiaty:\t");
                        String flowersMaterial = scanner.nextLine();
                        SyntheticFlower tempSyntheticFlower = new SyntheticFlower(flowersName, flowersColor, flowersMaterial, flowersQuantity, flowersPriceOfOne, "19970101");
                        delivery.addFlower(tempSyntheticFlower);
                    } else {
                        System.out.println("\nPodaj datę urzyteczności kwiatów RRRRMMDD:\t");
                        String flowerUtilizeDate = scanner.nextLine();
                        NaturalFlower tempNaturalFlower = new NaturalFlower(flowersName, flowersColor, flowersQuantity, flowersPriceOfOne, "19970101", flowerUtilizeDate);
                        delivery.addFlower(tempNaturalFlower);
                    }
                }
                case 2 -> {
                    delivery.setDeliveryDateForAllItems();
                    this.addDelivery(delivery);
                    running = false;
                    System.out.println("Dodano dostawę.");
                }
                case 3 -> {
                    delivery = new Delivery("19970101", "", "", "", "", "");
                    running = false;
                    System.out.println("Usunięto dostawę.");
                }
            }

            }
    }

    public void completeOrder(String ID){
        for(Order order : stockOrders){
            if(Objects.equals(order.id, ID)){
                order.completed = true;
            }
        }
    }

    //TEST
    public  static void main(String[] args){
//        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
//        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, "222123456");
//        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
//        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
//        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20211212", "20211220");
//        Rose19122021.setAvailability(true);
//        Rose12122021.setAvailability(true);
//        PlasticRose.setAvailability(true);
//        GunNRoses.addFlowerToStock(Rose12122021);
//        GunNRoses.addFlowerToStock(Rose19122021);
//        GunNRoses.addFlowerToStock(PlasticRose);
//
//        System.out.println(GunNRoses.utilize());
//        System.out.println(Arrays.toString(GunNRoses.stock));
//
//        GunNRoses.createDelivery();
//        System.out.println(Arrays.toString(GunNRoses.stock));
//        GunNRoses.createOrder();

        System.out.println("=======================================================================");
//
//        //Delivery delivery = new Delivery("20220324","98101", "Seattle", "Cobain", "27");
//        NaturalFlower RosePink = new NaturalFlower("rose", "pink", 30, 12.50F, "", "20220119");
//        SyntheticFlower PlasticRoseBlue = new SyntheticFlower("rose", "blue", "plastic", 15, 7.50F,"");
//        delivery.addFlower(RosePink);
//        delivery.addFlower(PlasticRoseBlue);
//        delivery.setDeliveryDateForAllItems();
//        System.out.println(Arrays.toString(delivery.deliveryItems));
//        GunNRoses.addDelivery(delivery);
//        GunNRoses.checkDelivery();
//        System.out.println(Arrays.toString(GunNRoses.stock));


    }
}

