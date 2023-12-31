import java.util.Scanner;

public class ProjectAkhir {
    private static final int MAX_MAHASISWA = 100;
    private static String[] nimArray = new String[MAX_MAHASISWA];
    private static String[] kodeMatkulArray = new String[MAX_MAHASISWA];
    private static int[] nilaiArray = new int[MAX_MAHASISWA];
    private static int jumlahMahasiswa = 3;
    private static String peran;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String peran = null; // Inisialisasi peran

        while (true) {
            if (peran == null) {
                System.out.println("SISTEM AKADEMIK");
                System.out.println("LOGIN SEBAGAI: ");
                System.out.println("1. ADMIN");
                System.out.println("2. DOSEN");
                System.out.println("3. MAHASISWA");
                System.out.print(": ");
                peran = scanner.next();

                // Menambahkan fitur login dengan password
                System.out.print("Password: ");
                String password = scanner.next();

                if (!login(peran, password)) {
                    System.out.println("Login gagal. Peran atau password salah. Silakan coba lagi.");
                    peran = null; // Mengatur ulang peran saat login gagal
                    continue;
                }
            }

            if (peran.equalsIgnoreCase("ADMIN")) {
                menuAdmin(scanner);
            } else if (peran.equalsIgnoreCase("DOSEN")) {
                menuDosen(scanner);
            } else if (peran.equalsIgnoreCase("MAHASISWA")) {
                menuMahasiswa(scanner);
            }
        }
    }

    public static boolean login(String peran, String password) {
        // Menambahkan logika untuk memeriksa peran dan password
        if (peran.equalsIgnoreCase("ADMIN") && password.equals("123")) {
            return true;
        } else if (peran.equalsIgnoreCase("DOSEN") && password.equals("456")) {
            return true;
        } else if (peran.equalsIgnoreCase("MAHASISWA") && password.equals("789")) {
            return true;
        }
        return false;
    }
    

    public static void menuAdmin(Scanner scanner) {
        // Implementasi menu Admin
        System.out.println("MENU ADMIN");
        // Tambahkan logika menu Admin di sini
        System.out.println("1. INPUT DATA MAHASISWA");
        System.out.println("2. INPUT DATA MATA KULIAH");
        System.out.println("3. INPUT NILAI");
        System.out.println("4. REKAP NILAI SEMUA MAHASISWA");
        System.out.println("5. SEARCH");
        System.out.println("6. KELUAR");
    
        System.out.println("\nPilih Menu Anda: ");
        int choice = scanner.nextInt();
        processAdminChoice(choice, scanner);
    }
    
    public static void menuDosen(Scanner scanner) {
        // Implementasi menu Dosen
        System.out.println("MENU DOSEN");
        // Tambahkan logika menu Dosen di sini
        System.out.println("1. INPUT NILAI");
        System.out.println("3. SEARCH");
        System.out.println("4. KELUAR");
    
        System.out.println("\nPilih Menu Anda: ");
        int choice = scanner.nextInt();
        processDosenChoice(choice, scanner);
    }
    

    // ... (Sisanya tetap sama)

    public static void menuMahasiswa(Scanner scanner) {
        // Implementasi menu Mahasiswa
        System.out.println("MENU MAHASISWA");
        // Tambahkan logika menu Mahasiswa di sini
        System.out.println("1. UPDATE DATA MAHASISWA");
       
        System.out.println("2. KELUAR");

        System.out.println("\nPilih Menu Anda: ");
        int choice = scanner.nextInt();
        processMahasiswaChoice(choice, scanner);
    }

    // ... (Sisanya tetap sama)

    public static void processAdminChoice(int choice, Scanner scanner) {
        // Implement logic for Admin choices
        switch (choice) {
            case 1:
                inputDataMhs(scanner);
                break;
            case 2:
                // Logic for INPUT DATA MATA KULIAH
                inputDataMataKuliah(scanner);
                break;
            // Add cases for other menu options
            case 3:
                InputNilai(scanner);
                break;
            
            case 4:
                RekapNilai(scanner);
                break;
            case 5:
                Search(scanner);
                break;
            case 6:
                System.out.println("Terima kasih!");
                System.exit(0); // Exit the program
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }

    public static void processDosenChoice(int choice, Scanner scanner) {
        // Implement logic for Dosen choices
        switch (choice) {
            case 1:
                // Logic for INPUT NILAI
                InputNilai(scanner);
                break;
            
            case 2:
                Search(scanner);
                break;
            case 3:
                System.out.println("Terima kasih!");
                System.exit(0); // Exit the program
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }

    public static void processMahasiswaChoice(int choice, Scanner scanner) {
        // Implement logic for Mahasiswa choices
        switch (choice) {
            case 1:
                inputDataMhs(scanner);
                break;
          
            case 2:
                System.out.println("Terima kasih!");
                System.exit(0); // Exit the program
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }

    public static void inputDataMhs(Scanner scanner) {
        Scanner input = new Scanner(System.in);

        // Batasi jumlah mahasiswa
        final int MAX_MAHASISWA = 10;

        // Array untuk menyimpan data mahasiswa
        int[] nomor = new int[MAX_MAHASISWA];
        String[] nama = new String[MAX_MAHASISWA];
        String[] nim = new String[MAX_MAHASISWA];

        int jumlahMahasiswa = 0; // Jumlah mahasiswa yang telah diinput

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Exit");
            System.out.print("Pilih menu (1/2/3): ");

            String pilihan = scanner.next();

            if (pilihan.equals("1")) {
                if (jumlahMahasiswa < MAX_MAHASISWA) {
                    System.out.println("Input Data Mahasiswa:");

                    // Input nomor
                    nomor[jumlahMahasiswa] = jumlahMahasiswa + 1;

                    // Input nama
                    System.out.print("Nama Mahasiswa: ");
                    nama[jumlahMahasiswa] = scanner.next();

                    // Input NIM
                    System.out.print("NIM Mahasiswa: ");
                    nim[jumlahMahasiswa] = scanner.next();

                    jumlahMahasiswa++;

                    System.out.println("Data Mahasiswa berhasil diinput.");
                } else {
                    System.out.println("Jumlah maksimal mahasiswa telah tercapai.");
                }
            } else if (pilihan.equals("2")) {
                if (jumlahMahasiswa > 0) {
                    System.out.println("Data Mahasiswa:");

                    // Tampilkan data mahasiswa
                    for (int i = 0; i < jumlahMahasiswa; i++) {
                        System.out.println("Nomor: " + nomor[i]);
                        System.out.println("Nama: " + nama[i]);
                        System.out.println("NIM: " + nim[i]);
                        System.out.println("------------------------");
                    }
                } else {
                    System.out.println("Belum ada data mahasiswa.");
                }
            } else if (pilihan.equals("3")) {
                System.out.print("Apakah Anda yakin ingin keluar? (y/n): ");
                String konfirmasi = scanner.next();
                if (konfirmasi.equalsIgnoreCase("y")) {
                    System.out.println("Terima kasih!");
                    break;
                }
            } else {

                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            
        }
    }
}

    public static void inputDataMataKuliah(Scanner scanner) {

        int maksMataKuliah = 100;

        String[] kodeMataKuliah = new String[maksMataKuliah];
        String[] namaMataKuliah = new String[maksMataKuliah];
        int[] jumlahSKS = new int[maksMataKuliah];

        int count = 0;

        char keluar;
        do {

            System.out.print("Masukkan Kode Mata Kuliah: ");
            kodeMataKuliah[count] = scanner.next();

            System.out.print("Masukkan Nama Mata Kuliah: ");
            scanner.nextLine();
            namaMataKuliah[count] = scanner.next();

            System.out.print("Masukkan Jumlah SKS: ");
            jumlahSKS[count] = scanner.nextInt();

            count++;

            System.out.print("Keluar Fitur (y/n): ");
            keluar = scanner.next().charAt(0);

        } while (keluar != 'y' && keluar != 'Y' && count < maksMataKuliah);

        System.out.printf("=========================================================\n");
        System.out.printf("                     DATA MATA KULIAH    \n");
        System.out.printf("=========================================================\n");
        System.out.printf("=========================================================\n");
        System.out.printf("|No. | Kode Mata Kuliah | Nama Mata Kuliah | Jumlah SKS\n");
        System.out.printf("=========================================================\n");

        for (int i = 0; i < count; i++) {
            System.out.println(
                    (i + 1) + "\t|" + kodeMataKuliah[i] + "\t\t|" + namaMataKuliah[i] + "\t\t |" + jumlahSKS[i]);

        }
        System.out.printf("=========================================================\n");
    }

    public static void InputNilai(Scanner scanner) {
        String[] namaMahasiswa = {"Bagas Satria YN", "Arimbi", "Angga"};  // Ganti dengan nama sesuai jumlah mahasiswa yang akan diinput
        String[] nimMahasiswa = {"2341760108", "2341760109", "2341760110"};
        String[] hurufMutu = new String[MAX_MAHASISWA];
        String[] jumlahSKS = new String[MAX_MAHASISWA];
        String[] nilaiTugas = new String[MAX_MAHASISWA];
        String[] nilaiUTS = new String[MAX_MAHASISWA];
        String[] nilaiUAS = new String[MAX_MAHASISWA];
        int nomorMahasiswa = -1;
        // for (int i = 0; i < namaMahasiswa.length; i++) {
            
        // }
        // nimArray[1] = "2341760109";
        // kodeMatkulArray[1] = "SIB231008";
        // jumlahSKS[1] = "3";
        // nilaiTugas[1] = "85";
        // nilaiUTS[1] = "90";
        // nilaiUAS[1] = "80";
        // hurufMutu[1] = "B";

        // nimArray[2] = "2341760110";
        // kodeMatkulArray[2] = "SIB231002";
        // jumlahSKS[2] = "2";
        // nilaiTugas[2] = "90";
        // nilaiUTS[2] = "90";
        // nilaiUAS[2] = "85";
        // hurufMutu[2] = "A";

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Pilih nama mahasiswa");
            System.out.println("2. Cetak KHS");
            System.out.println("3. Input Nilai Mahasiswa");
            System.out.println("4. Exit");
            System.out.print("Pilih menu (1/2/3): ");
            String pilihan = scanner.next();

            if (pilihan.equals("1")) {
                System.out.println("Daftar Nama Mahasiswa:");
                for (int i = 0; i < namaMahasiswa.length; i++) {
                    System.out.println((i + 1) + ". " + namaMahasiswa[i]);
                }
    
                System.out.print("Pilih nomor mahasiswa: ");
                nomorMahasiswa = scanner.nextInt();
                nomorMahasiswa--;  // Konversi ke indeks array
                nimMahasiswa[0] = nimMahasiswa[nomorMahasiswa];
                // Masukkan data mahasiswa yang dipilih ke dalam array
                // nimArray[1] = nimMahasiswa[1];
                // kodeMatkulArray[1] = "SIB231009";  // Contoh kode mata kuliah, ganti sesuai kebutuhan
                // jumlahSKS[1] = "3";  // Contoh jumlah SKS, ganti sesuai kebutuhan
                // nilaiTugas[1] = "85";  // Contoh nilai tugas, ganti sesuai kebutuhan
                // nilaiUTS[1] = "90";  // Contoh nilai UTS, ganti sesuai kebutuhan
                // nilaiUAS[1] = "80";  // Contoh nilai UAS, ganti sesuai kebutuhan
                // hurufMutu[1] = "B";  // Contoh huruf mutu, ganti sesuai kebutuhann
    
                System.out.println("Data mahasiswa berhasil dipilih.");
            } else if (pilihan.equals("2")) {
                if (nomorMahasiswa == -1) {
                    System.out.println("Belum ada mahasiswa yang dipilih. Pilih nama mahasiswa terlebih dahulu.");
                } else {
                    System.out.println("NAMA: " + namaMahasiswa[nomorMahasiswa]);
                    System.out.println("NIM : " + nimMahasiswa[nomorMahasiswa]);
            
                    System.out.println("No.\tKode Mata Kuliah\tJumlah SKS\tNilai Tugas\t Nilai UTS\t Nilai UAS\tHuruf Mutu");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.printf("1.\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n", kodeMatkulArray[nomorMahasiswa], jumlahSKS[nomorMahasiswa],
                            nilaiTugas[nomorMahasiswa], nilaiUTS[nomorMahasiswa], nilaiUAS[nomorMahasiswa], hurufMutu[nomorMahasiswa]);
                    System.out.println("-----------------------------------------------------------------------");
                }
            // if (pilihan.equals("1")) {
            //     for (int i = 0; i < namaMahasiswa.length; i++) {
            //         System.out.println("NAMA: " + namaMahasiswa[i]);
            //         System.out.println("NIM : " + nimMahasiswa[i]);
    
            //         System.out.println("No.\tKode Mata Kuliah\tJumlah SKS\tNilai Tugas\t Nilai UTS\t Nilai UAS\tHuruf Mutu");
            //         System.out.println("-----------------------------------------------------------------------");
            //         System.out.printf("1.\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n", kodeMatkulArray[i], jumlahSKS[i],
            //                 nilaiTugas[i], nilaiUTS[i], nilaiUAS[i], hurufMutu[i]);
            //         System.out.println("-----------------------------------------------------------------------");
            //     }
                // System.out.println("Nama : Bagas Satria YN");
                // System.out.println("Nim  : 2341760108");

                // System.out.println("No.\tKode Mata Kuliah\tJumlah SKS\tNilai Tugas\t Nilai UTS\t Nilai UAS\tHuruf Mutu");
                // for (int i = 0; i < jumlahMahasiswa; i++) {
                //     System.out.println(
                //             (i + 1)  + "\t" + kodeMatkulArray[i]  + "\t\t" + jumlahSKS[i]+  "\t\t" + nilaiTugas[i] + "\t\t" + nilaiUTS[i] + "\t\t" + nilaiUAS[i] + "\t\t" + hurufMutu[i] );
                // }
            } else if (pilihan.equals("3")) {
                if (nomorMahasiswa != -1 && jumlahMahasiswa < MAX_MAHASISWA) {
                    

                    System.out.print("Masukkan Kode Mata Kuliah: ");
                    kodeMatkulArray[nomorMahasiswa] = scanner.next();

                    System.out.print("Masukkan Jumlah SKS: ");
                    jumlahSKS[nomorMahasiswa] = scanner.next();

                    System.out.print("Masukkan Nilai Tugas: ");
                    nilaiTugas[nomorMahasiswa] = scanner.next();

                    System.out.print(" Masukkan Nilai UTS: ");
                    nilaiUTS[nomorMahasiswa] = scanner.next();

                    System.out.print(" Masukkan Nilai UAS: ");
                    nilaiUAS[nomorMahasiswa] = scanner.next();

                    System.out.print(" Masukkan Huruf Mutu: ");
                    hurufMutu[nomorMahasiswa] = scanner.next();
                    

                    jumlahMahasiswa++;
                    System.out.println("Data berhasil ditambahkan.");
                } else if (nomorMahasiswa == -1) {
                    System.out.println("Belum ada mahasiswa dipilih.");
                } else {
                    System.out.println("Jumlah maksimal mahasiswa telah tercapai.");
                }
            } else if (pilihan.equals("4")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    
    public static void RekapNilai(Scanner scanner) {
        // Maksimum jumlah mahasiswa, bisa disesuaikan
        final int MAX_MAHASISWA = 100;
        String[][] nilaiMahasiswa = new String[MAX_MAHASISWA][5];
        int jumlahMahasiswa = 0;
    
        // Input data nilai mahasiswa
        while (true) {
            System.out.print("Masukkan NIM : ");
            String nim = scanner.next();
    
            if (nim.equals("0")) {
                break;
            }
    
            System.out.print("Masukkan Nama Mahasiswa: ");
            String nama = scanner.next();
    
            System.out.print("Masukkan Nilai Tugas: ");
            String nilaiTugas = scanner.next();
    
            System.out.print("Masukkan Nilai UTS: ");
            String nilaiUTS = scanner.next();
    
            System.out.print("Masukkan Nilai UAS: ");
            String nilaiUAS = scanner.next();
    
            // Membuat array String dan menambahkannya ke dalam array 2 dimensi
            nilaiMahasiswa[jumlahMahasiswa][0] = nim;
            nilaiMahasiswa[jumlahMahasiswa][1] = nama;
            nilaiMahasiswa[jumlahMahasiswa][2] = nilaiTugas;
            nilaiMahasiswa[jumlahMahasiswa][3] = nilaiUTS;
            nilaiMahasiswa[jumlahMahasiswa][4] = nilaiUAS;
    
            jumlahMahasiswa++;
        }
    
        // Menampilkan header tabel
        System.out.println("\nNIM\tNAMA MAHASISWA\tUTS\tTUGAS\tUAS\tNILAI AKHIR\tKETERANGAN");
    
        // Menampilkan data nilai mahasiswa
        for (int i = 0; i < jumlahMahasiswa; i++) {
            double nilaiAkhir = hitungNilaiAkhir(nilaiMahasiswa[i]);
            String keterangan = getKeterangan(nilaiAkhir);
    
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%.1f\t\t%s\n", nilaiMahasiswa[i][0], nilaiMahasiswa[i][1],
                    nilaiMahasiswa[i][3], nilaiMahasiswa[i][2], nilaiMahasiswa[i][4], nilaiAkhir, keterangan);
        }
    }
    
    public static double hitungNilaiAkhir(String[] nilaiArray) {
        double nilaiUTS = Double.parseDouble(nilaiArray[3]);
        double nilaiTugas = Double.parseDouble(nilaiArray[2]);
        double nilaiUAS = Double.parseDouble(nilaiArray[4]);
        return (nilaiUTS + nilaiTugas + nilaiUAS) / 3.0;
    }
    
    public static String getKeterangan(double nilaiAkhir) {
        return nilaiAkhir >= 60 ? "LULUS" : "TIDAK LULUS";
}
    

    public static void Search(Scanner scanner) {
        final int MAX_MATAKULIAH = 3;  // Jumlah maksimum mata kuliah, sesuaikan jika diperlukan
        final int DATA_LENGTH = 4;  // Panjang data untuk setiap mata kuliah (Kode, Nama, SKS, Nilai)
    
        // Menambahkan data nilai mahasiswa
        String[][] nilaiMahasiswa = {
            {"SIB231009", "Praktikum Daspro", "3", "A+", "87"},
            {"SIB231008", "Dasar Pemrogaman", "2", "A", "90"},
            {"SIB231110", "Bahasa Indonesia", "2", "A", "96"}
        };
    
        // Input NIM untuk pencarian
        System.out.print("Search : Cetak KHS\nNIM\t: ");
        String nimCari = scanner.next();
    
        // Menampilkan header KHS
        System.out.println("NIM\t\t: " + nimCari);
        System.out.println("NAMA\t: " + "Bagas Satria YN"); // Nama mahasiswa bisa disimpan di sini jika diperlukan
        System.out.println("No.\tKode Mata Kuliah\tMata kuliah\t\tSKS\tHuruf Mutu\tNilai");
    
        // Menampilkan data KHS
        boolean found = false;
        for (String[] mataKuliah : nilaiMahasiswa) {
            if (mataKuliah[0].equals(nimCari)) {
                found = true;
                int nomor = 1;
                for (int i = 1; i < MAX_MATAKULIAH + 1; i++) {
                    System.out.printf("%d.\t%s\t\t\t%s\t\t%d\t%s\t\t%d\n", nomor, mataKuliah[i * DATA_LENGTH - 3],
                            "Nama Mata Kuliah", // Nama mata kuliah bisa disimpan di sini jika diperlukan
                            Integer.parseInt(mataKuliah[i * DATA_LENGTH - 2]), mataKuliah[i * DATA_LENGTH - 1],
                            Integer.parseInt(mataKuliah[i * DATA_LENGTH]));
                    nomor++;
                }

                break;
            }
        }
    
            if (!found) {

            System.out.println("Data mahasiswa tidak ditemukan.");
        }
    }
    

        public static int[] createNilaiMataKuliah(String namaMk, int sks, String hurufMutu, int nilai) {

    int[] nilaiMkArray = new int[3];
    nilaiMkArray[0] = sks;
    nilaiMkArray[1] = convertHurufMutu(hurufMutu);
    nilaiMkArray[2] = nilai;
    return nilaiMkArray;
    
    }

    public static int convertHurufMutu(String hurufMutu) {
    // Implementasi konversi huruf mutu ke nilai numerik jika diperlukan
        return 0; // Implementasi sesuai kebutuhan
    }
}