import java.util.Scanner;

class Jurnal3 {

    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Data> list = new LinkedList();

    public static void main(String[] args) {

        list.inputDepan(new Data(0, null, null));
        list.inputDepan(new Data(1, null, null));
        list.inputDepan(new Data(2, null, null));
        list.inputBelakang(new Data(3, null, null));

        list.printAllData();
        menu();
        list.printAllData();
        
    }

    public static void menu() {
        System.out.println("Pilihlah menu:");
        System.out.println("1. Input data");
        System.out.println("2. Hapus data");
        System.out.println("3. Cetak list pegawai");
        System.out.println("4. keluar");

        int masukanMenu = scanner.nextInt();

        switch(masukanMenu) {
            case 1: {
                System.out.println("Masukkan dari depan atau belakang? (d/b)");
                String dOrB = scanner.next();
                if (dOrB.equalsIgnoreCase("d")) {
                    list.inputDepan(new Data(scanner.nextInt(), scanner.next(), scanner.next()));
                } else if(dOrB.equalsIgnoreCase("b")) {
                    list.inputBelakang(new Data(scanner.nextInt(), scanner.next(), scanner.next()));
                } else {
                    System.out.println("hanya isi sesuai pilihan yang disediakan!");
                }
                menu();
                break;
            }
            case 2: {
                System.out.println("Hapus dari depan atau belakang? (d/b)");
                String dOrB = scanner.next();
                if (dOrB.equalsIgnoreCase("d")) {
                    list.hapusDepan();
                } else if(dOrB.equalsIgnoreCase("b")) {
                    list.hapusBelakang();
                } else {
                    System.out.println("hanya isi sesuai pilihan yang disediakan!");
                }
                menu();
                break;
            }
            case 3: {
                list.printAllData();
                menu();
                break;
            }
            case 4: {
                break;
            }
        }

    }

    
}

class LinkedList<Data> {
    Node head;

    public void LinkedList(){
        head = null;
    }

    public void inputDepan(Data data) {
        Node<Data> newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void inputBelakang(Data data) {
        Node newNode = new Node(data);
        Node iterator = head;

        while (iterator.next!=null) {
            iterator = iterator.next;
        }
        iterator.next = newNode;
    }

    public void hapusDepan() {
        head = head.next;
    }

    public void hapusBelakang() {
        if(head.next==null) {
            head = null;
        } else {
            Node iterator = head;
            while(iterator.next.next!=null) {
                iterator = iterator.next;
            }
            iterator.next = null;
        }
    }

    public void getData(){
        System.out.println(head.getData().toString());
    }

    public void printAllData() {
        Node iterator = head;
        while (iterator!=null) {
            System.out.println(iterator.getData().toString());;
            iterator = iterator.next;
        }
    }
}

class Node<Data> {
    Data data;
    Node next;

    Node(Data data) {
        this.data = data;
        this.next = null;
    }

    public Data getData() {
        return data;
    }

}

class Data {
    int nip;
    String nama;
    String divisi;

    Data(int nip, String nama, String divisi) {
        this.nip = nip;
        this.nama = nama;
        this.divisi = divisi;
    }
    public int getNip() {
        return nip;
    }

    @Override
    public String toString() {
        return "nip : "+nip+"\nnama : "+nama+"\ndivisi : " + divisi;
    }
}