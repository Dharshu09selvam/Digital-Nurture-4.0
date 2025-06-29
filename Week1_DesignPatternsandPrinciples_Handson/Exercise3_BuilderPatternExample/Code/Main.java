public class Main {
    public static void main(String[] args) {

        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
                                    .build();

    
        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB")
                                    .setStorage("1TB SSD")
                                    .setGraphicsCard("NVIDIA RTX 4070")
                                    .setOperatingSystem("Windows 11")
                                    .build();


        Computer workstation = new Computer.Builder("AMD Ryzen 9", "32GB")
                                    .setStorage("2TB SSD")
                                    .setGraphicsCard("NVIDIA Quadro RTX 6000")
                                    .setOperatingSystem("Linux Ubuntu")
                                    .build();

        System.out.println("Basic: " + basicComputer);
        System.out.println("Gaming: " + gamingComputer);
        System.out.println("Workstation: " + workstation);
    }
}
